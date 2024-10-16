package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Klasse um eine ExcelDatei zu lesen und evtl später zu verarbeiten und umzuwandeln
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

}
