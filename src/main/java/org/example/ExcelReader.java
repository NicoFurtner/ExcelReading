package org.example;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Klasse um eine ExcelDatei zu lesen und evtl später zu verarbeiten und umzuwandeln
 * Quelle für excelreaderstring methode:  * Quelle: https://www.geeksforgeeks.org/opening-existing-excel-sheet-in-java-using-apache-poi/
 * @author Nico Furtner
 * @version 2024-10-16
 */
public class ExcelReader {
    private String exceldatei;

    public ExcelReader(String exceldatei) {
        this.exceldatei = exceldatei;
    }
    public String ExcelReaderString() {
        String text = "";
        try (FileInputStream fis = new FileInputStream(exceldatei);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    text += cell.toString() + "\t";
                }
                text += "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    public String checkFile(){
        boolean isValidExcel = true;
        try {
            File file = new File(this.exceldatei);

            if (!file.exists() || file.isDirectory()) {
                isValidExcel = false;
            } else {
                if (!(exceldatei.endsWith(".xls") || exceldatei.endsWith(".xlsx"))) {
                    isValidExcel = false;
                } else {
                    try {
                        WorkbookFactory.create(file);
                    } catch (IOException e) {
                        isValidExcel = false;
                    }
                }
            }
        } catch (Exception e) {
            isValidExcel = false;
        }
        if (!isValidExcel) {
            return "File is not a valid Excel file: " + exceldatei;
        }
        else {
            return "File is a valid Excel file" + exceldatei;
        }
    }

    public void toCSV() {

    }

}
