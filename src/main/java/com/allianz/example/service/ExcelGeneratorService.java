package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.OrderItemEntity;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Service
public class ExcelGeneratorService {

    public void generateExcel(HttpServletResponse response, BillEntity bill) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Invoice");

        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        String[] headers = {"Name","Surname","Product Name", "Quantity", "Tax Applied", "Ordered Price (TL)"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.GERMANY));
        for (OrderItemEntity orderItem : bill.getOrder().getOrderItemList()) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(bill.getOrder().getCustomer().getPerson().getName());
            row.createCell(1).setCellValue(bill.getOrder().getCustomer().getPerson().getSurname());
            row.createCell(2).setCellValue(orderItem.getProduct().getName());
            row.createCell(3).setCellValue(orderItem.getQuantity());
            row.createCell(4).setCellValue("YES");
            row.createCell(5).setCellValue(decimalFormat.format(orderItem.getOrderPrice()) + " TL");
        }

        // Set response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=invoice.xlsx");

        // Write Excel data to response
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}