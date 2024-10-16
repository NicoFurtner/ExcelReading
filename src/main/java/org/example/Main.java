package org.example;
/**
 * Main-Klasse für ExcelDatei lesen
 * @author Nico Furtner
 * @version 2024-10-16
 */
public class Main {
    public static void main(String[] args) {
        ExcelReader er = new ExcelReader("FSI-2023-DOWNLOAD.xlsx");

        // ExcelReaderMethode
        String text = er.ExcelReaderString();
        System.out.println(text);


    }
}