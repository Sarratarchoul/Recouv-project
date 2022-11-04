package tn.esprit.spring.helper;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Date;
import tn.esprit.spring.entity.Facture;

public class FactureExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Facture> factures;
     
    public FactureExcel(List<Facture> factures) {
        this.factures = factures;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Factures");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Num facture", style);  
        createCell(row, 1, "Date emission", style);  
        createCell(row, 2, "Date echeance", style);    
        createCell(row, 3, "Montant initial", style);
        createCell(row, 4, "Montant restant", style);
        createCell(row, 5, "Status", style);
        createCell(row, 6, "Retards", style);
        createCell(row,7, "Delai paiment", style);
        createCell(row, 8, "Garantie assureur", style);
        createCell(row, 9, "Autres garanties", style);
        createCell(row, 10, "Limite credit", style);
        createCell(row,11, "Notation credit", style);
        createCell(row,12, "Code client", style);
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }
        else if (value instanceof Float) {
            cell.setCellValue((Float) value);
        }
        else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Facture cat : factures) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            
            createCell(row, columnCount++, cat.getNum_facture(), style);
            createCell(row, columnCount++, cat.getDate_emission(), style);
            createCell(row, columnCount++, cat.getDate_echeance(), style);
            createCell(row, columnCount++, cat.getMontant_initial(), style);
            createCell(row, columnCount++, cat.getMontant_restant(), style);
            createCell(row, columnCount++, cat.getStatus(), style);
            createCell(row, columnCount++, cat.getRetards(), style);
            createCell(row, columnCount++, cat.getDelai_paimentF(), style);
            createCell(row, columnCount++, cat.getGarantie_assureur(), style);
            createCell(row, columnCount++, cat.getAutres_garanties(), style);
            createCell(row, columnCount++, cat.getLimite_credit(), style);
            createCell(row, columnCount++, cat.getNotation_credit(), style);
            createCell(row, columnCount++, cat.getIdclient(), style);
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}