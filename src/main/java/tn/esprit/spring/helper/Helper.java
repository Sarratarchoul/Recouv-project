package tn.esprit.spring.helper;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Facture;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {


    //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list of products

    public static List<Facture> convertExcelToListOfFacture(InputStream is) {
        List<Facture> list = new ArrayList<>();

        try {


            XSSFWorkbook workbook = new XSSFWorkbook(is);

            XSSFSheet sheet = workbook.getSheet("data");

            int rowNumber = 0;
            Iterator<Row> iterator = sheet.iterator();

            while (iterator.hasNext()) {
                Row row = iterator.next();

                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;

                Facture f = new Facture();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            f.setNum_facture((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            f.setDate_echeance(cell.getDateCellValue());
                            break;
                        case 2:
                            f.setDate_emission(cell.getDateCellValue());
                            break;
                        case 3:
                            f.setDelai_paimentF(cell.getDateCellValue());
                            break;
                        case 4:
                            f.setGarantie_assureur((float)cell.getNumericCellValue());
                            break;
                        case 5:
                            f.setMontant_initial((float)cell.getNumericCellValue());
                            break;
                        case 6:
                            f.setMontant_restant((float)cell.getNumericCellValue());
                            break;
                        case 7:
                            f.setRetards((int) cell.getNumericCellValue());
                            break;
                        case 8:
                            f.setStatus(cell.getStringCellValue());
                            break;
                        case 9:
                            f.setLimite_credit((float) cell.getNumericCellValue());
                            break;
                       case 10:
                            f.setIdclient((long)cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(f);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}

