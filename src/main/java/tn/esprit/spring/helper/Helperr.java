package tn.esprit.spring.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Relance;

public class Helperr {
	 //check that file is of excel type or not
    public static boolean checkExcelFormat(MultipartFile file) {

        String contentType = file.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
            return true;
        } else {
            return false;
        }

    }


    //convert excel to list

    public static List<Relance> convertExcelToListOfRelance(InputStream is) {
        List<Relance> list = new ArrayList<>();

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

                Relance r = new Relance();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            r.setIdR((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            r.setDate_action(cell.getDateCellValue());
                            break;
                        case 2:
                            r.setType_action(cell.getStringCellValue());
                            break;
                        case 3:
                            r.setAction(cell.getStringCellValue());
                            break;
                        case 4:
                            r.setMontant_action((float)cell.getNumericCellValue());
                            break;
                        case 10:
                            r.setIdclient((long)cell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(r);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }


}

