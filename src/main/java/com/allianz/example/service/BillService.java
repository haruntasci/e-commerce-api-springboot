package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.database.specification.BillSpecification;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillEntityRepository, BillSpecification> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    PDFGeneratorService pdfGeneratorService;

    @Autowired
    ExcelGeneratorService excelGeneratorService;

    @Autowired
    BillMapper billMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BillSpecification billSpecification;

    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return this.billEntityRepository;
    }

    @Override
    protected BillSpecification getSpecification() {
        return billSpecification;
    }

    @Override
    public BillDTO save(BillRequestDTO billRequestDTO) {
        BillEntity bill = billMapper.requestDTOToEntity(billRequestDTO);
        OrderEntity order = orderEntityRepository.findByUuid(billRequestDTO.getOrderUUID()).orElse(null);
        if (order != null) {
            bill.setOrder(order);
            if (billRequestDTO.getBillNo().equals("")) {
                bill.setBillNo(UUID.randomUUID().toString());
            } else {
                bill.setBillNo(billRequestDTO.getBillNo());
            }
            calculateAmounts(bill, order);
            BillEntity savedBill = billEntityRepository.save(bill);
            return billMapper.entityToDTO(savedBill);
        } else {
            return null;
        }
    }

    public BillDTO createBill(OrderDTO orderDTO) {
        OrderEntity order = orderMapper.dtoToEntity(orderDTO);
        BillEntity bill = new BillEntity();
        bill.setOrder(order);
        bill.setBillNo(UUID.randomUUID().toString());
        calculateAmounts(bill, order);
        BillEntity savedBill = billEntityRepository.save(bill);
        return billMapper.entityToDTO(savedBill);
    }

    private void calculateAmounts(BillEntity bill, OrderEntity order) {
        BigDecimal taxFreeTotalAmount = BigDecimal.ZERO;
        for (OrderItemEntity orderItem : order.getOrderItemList()) {
            BigDecimal taxRate = orderItem.getProduct().getTax().getRate();
            BigDecimal orderPrice = orderItem.getOrderPrice();
            BigDecimal quantity = BigDecimal.valueOf(orderItem.getQuantity());
            taxFreeTotalAmount = taxFreeTotalAmount
                    .add(orderPrice.divide(taxRate, RoundingMode.HALF_UP).multiply(quantity));
        }
        bill.setTotalAmount(order.getTotalAmount());
        bill.setTaxFreeAmount(taxFreeTotalAmount);
        bill.setTaxAmount(order.getTotalAmount().subtract(taxFreeTotalAmount));
    }

    public String generateBillPDF(UUID billUUID, HttpServletResponse response) {
        BillEntity bill = billEntityRepository.findByUuid(billUUID).orElse(null);
        if (bill != null) {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);
            try {
                pdfGeneratorService.export(response, bill);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "Successful";
        } else {
            return "Error";
        }


    }

    public String generateBillExcel(UUID billUUID, HttpServletResponse response) {
        BillEntity bill = billEntityRepository.findByUuid(billUUID).orElse(null);
        if (bill != null) {
            try {
                excelGeneratorService.generateExcel(response,bill);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "Successful";
        } else {
            return "Error";
        }

    }

}
