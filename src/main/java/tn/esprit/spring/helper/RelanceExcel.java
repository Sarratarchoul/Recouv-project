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

import tn.esprit.spring.entity.Relance;

public class RelanceExcel {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Relance> relances;
     
    public RelanceExcel(List<Relance> relances) {
        this.relances = relances;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Relances");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Num relance", style);  
        createCell(row, 1, "Date action", style);  
        createCell(row, 2, "Type action", style);    
        createCell(row, 3, "Action", style);
        createCell(row, 4, "Montant action", style);
        createCell(row, 5, "Code client", style);
    
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
                 
        for (Relance cat : relances) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            
            createCell(row, columnCount++, cat.getIdR(), style);
            createCell(row, columnCount++, cat.getDate_action(), style);
            createCell(row, columnCount++, cat.getType_action(), style);
            createCell(row, columnCount++, cat.getAction(), style);
            createCell(row, columnCount++, cat.getMontant_action(), style);
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
