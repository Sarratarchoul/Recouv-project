package tn.esprit.spring.helper;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.esprit.spring.entity.Client;

public class ClientExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Client> clients;
     
    public ClientExcel(List<Client> clients) {
        this.clients = clients;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Clients");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Code client", style);  
        createCell(row, 1, "Nom client", style);  
        createCell(row, 2, "Senario relance", style);    
        createCell(row, 3, "Adresse", style);
        createCell(row, 4, "email", style);
        createCell(row, 5, "Profil payeur", style);
        createCell(row, 6, "Num Tel", style);
        createCell(row,7, "Personne contact", style);
        createCell(row, 8, "Nom groupe", style);
        createCell(row, 9, "Moyen de paiement", style);
      
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
                 
        for (Client cat : clients) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            
            createCell(row, columnCount++, cat.getCode_client(), style);
            createCell(row, columnCount++, cat.getNom_client(), style);
            createCell(row, columnCount++, cat.getSenario_relance(), style);
            createCell(row, columnCount++, cat.getAdresse_client(), style);
            createCell(row, columnCount++, cat.getEmail(), style);
            createCell(row, columnCount++, cat.getProfil_payeur(), style);
            createCell(row, columnCount++, cat.getNumTel(), style);
            createCell(row, columnCount++, cat.getPersonne_contact(), style);
            createCell(row, columnCount++, cat.getNom_groupe(), style);
            createCell(row, columnCount++, cat.getMoyen_de_paiement(), style);
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