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

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Relance;

public class Helperc {
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

    public static List<Client> convertExcelToListOfClient(InputStream is) {
        List<Client> list = new ArrayList<>();

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

                Client c = new Client();

                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            c.setCode_client((long) cell.getNumericCellValue());
                            break;
                        case 1:
                            c.setNom_client(cell.getStringCellValue());
                            break;
                        case 2:
                            c.setSenario_relance(cell.getStringCellValue());
                            break;
                        case 3:
                            c.setAdresse_client(cell.getStringCellValue());
                            break;
                        case 4:
                            c.setEmail(cell.getStringCellValue());
                            break;
                        case 5:
                            c.setProfil_payeur(cell.getStringCellValue());
                            break;
                        case 6:
                            c.setNumTel(cell.getStringCellValue());
                            break;
                        case 7:
                            c.setPersonne_contact(cell.getStringCellValue());
                            break;
                        case 8:
                            c.setNom_groupe(cell.getStringCellValue());
                            break;
                        case 9:
                            c.setMoyen_de_paiement(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;

                }

                list.add(c);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }



}
