package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.repository.OrderEntityRepository;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.mapper.OrderMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.OrderDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Service
public class BillService extends BaseService<BillEntity, BillDTO, BillRequestDTO,
        BillMapper, BillEntityRepository> {

    @Autowired
    BillEntityRepository billEntityRepository;

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    BillMapper billMapper;

    @Autowired
    OrderMapper orderMapper;

    @Override
    protected BillMapper getMapper() {
        return this.billMapper;
    }

    @Override
    protected BillEntityRepository getRepository() {
        return this.billEntityRepository;
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

}
