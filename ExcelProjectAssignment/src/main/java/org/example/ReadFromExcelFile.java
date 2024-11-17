package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromExcelFile {
    public static void main(String[] args) {
        try {
            //Load the excel file
            File file = new File("C:\\Users\\fc\\Java_1016_Batch_Class_Notes\\FileInputOutputOperations\\src\\main\\resources\\students.xlsx");
            //Convert the file to byte array
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            //creating workbook and passing the byte array
            //XSSFWorkbook help to convert this byte array to java Object of Excel file
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(bufferedInputStream);
            System.out.println("Number Of sheets : "+ xssfWorkbook.getNumberOfSheets());
            List<Student> studentList = new ArrayList<>();
            //Read the sheet
            for (int i = 0; i < xssfWorkbook.getNumberOfSheets(); i++) {
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                System.out.println("Total Number Of Rows : "+ sheet.getLastRowNum());
                //iterate over each row
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Student student = new Student();
                    Row row = rowIterator.next();
                    System.out.println("Row Number : "+row.getRowNum());
                    System.out.println("The number of Cell/Column : "+row.getLastCellNum() + 1);
                    if (row.getRowNum() == 0) {
                        continue;
                    }
                    //Read the all the cell / column present in a particular row
                    Iterator<Cell> cellIterator = row.iterator();
                    //iterate over each cell of a row
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        System.out.println("Column Index : " + cell.getColumnIndex());
                        //this cell type can be Text/number/boolean/date of the excel file
//                        String cellType = cell.getCellType().name();
//                        System.out.println("Data Type of the Cell : "+cellType);
//                        switch (cellType) {
//                            case "STRING":
//                                System.out.println(cell.getStringCellValue());
//                                break;
//                            case "NUMERIC":
//                                System.out.println(cell.getNumericCellValue());
//                                break;
//                            case "BOOLEAN":
//                                System.out.println(cell.getBooleanCellValue());
//                                break;
//                        }
                        //populating student object based on the column index
                        switch (cell.getColumnIndex()) {
                            case 0:
                                Integer studId = (int) (cell.getNumericCellValue());
                                student.setStudentId(studId);
                                break;
                            case 1:
                                student.setStudName(cell.getStringCellValue());
                                break;
                            case 2:
                                Float sub1Score = Float.parseFloat(String.valueOf(cell.getNumericCellValue()));
                                student.setSub1Score(sub1Score);
                                break;
                            case 3:
                                student.setSub2Score(Float.parseFloat(String.valueOf(cell.getNumericCellValue())));
                                break;
                            case 4:
                                student.setSub3Score(Float.parseFloat(String.valueOf(cell.getNumericCellValue())));
                                break;
                            case 5:
                                student.setFinalScore(Float.parseFloat(String.valueOf(cell.getNumericCellValue())));
                                break;
                        }
                    }
                    System.out.println(student);
                    studentList.add(student);
                }
            }
            System.out.println(studentList);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
