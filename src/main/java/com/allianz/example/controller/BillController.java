package com.allianz.example.controller;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.repository.BillEntityRepository;
import com.allianz.example.database.specification.BillSpecification;
import com.allianz.example.mapper.BillMapper;
import com.allianz.example.model.BillDTO;
import com.allianz.example.model.requestDTO.BillRequestDTO;
import com.allianz.example.service.BillService;
import com.allianz.example.service.ExcelGeneratorService;
import com.allianz.example.util.BaseController;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("bill")
public class BillController extends BaseController<
        BillEntity,
        BillDTO,
        BillRequestDTO,
        BillMapper,
        BillEntityRepository,
        BillSpecification,
        BillService> {

    @Autowired
    BillService billService;

    @Autowired
    BillEntityRepository billEntityRepository;

    @Override
    protected BillService getService() {
        return this.billService;
    }


    @GetMapping("/excel/{uuid}")
    public ResponseEntity<String> generateExcel(@PathVariable UUID uuid, HttpServletResponse response) throws IOException {
        return new ResponseEntity<>(billService.generateBillExcel(uuid, response), HttpStatus.OK);
    }

    @GetMapping("/pdf/{uuid}")
    public ResponseEntity<String> getBillAsPDF(@PathVariable UUID uuid, HttpServletResponse response) {
        return new ResponseEntity<>(billService.generateBillPDF(uuid, response), HttpStatus.OK);
    }

}