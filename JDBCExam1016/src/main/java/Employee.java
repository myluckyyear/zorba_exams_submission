import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Employee {
    public static void main(String[] args)  {
        //1
      try{  Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/zorba_exams?user=root&password=AlinaSALA.$2013");

          // 1 -- create schema zorba_exams

          Statement createStatement = con.createStatement();

          /*
          2. Create a new table named employee (emp_id int pk, emp_name varchar
                    (255), emp_address varchar (255), emp_salary decimal (12, 2),
                emp_mobile int (10), dept_name varchar (255), doj datetime).
           */
          String statement = "Create table if not exists employee( emp_id int Primary Key, emp_name varchar(255), " +
                  "emp_address varchar(255), emp_salary decimal(12, 2)," +
                  "emp_mobile int(10), dept_name varchar(255), doj datetime default '1970-01-01');";

          createStatement.executeUpdate(statement);


          /*
          3. Alter the employee table and make emp_name and dept_name field as
            not null. And make doj field has default constraints as ‘1970-01-01’;
           */
          String alterEmpName = "Alter table employee modify column emp_name varchar(255) not null;";
        createStatement.executeUpdate(alterEmpName);


          String alterEmpDept = "Alter table employee modify column dept_name varchar(255) not null;";
          createStatement.executeUpdate(alterEmpDept);

          System.out.println("modified the table");


         //4. Create a new application.properties file under resource. Store all the
          //necessary DB credentials along with jdbc url in application.properties
          //file. Read from all those information from properties file and pass for
          //jdbc connection.

          Properties pf = new Properties();

          FileInputStream pfile = new FileInputStream("C:\\Users\\fc\\Zorba_exam_submission\\JDBCExam1016\\src\\main\\resources\\application.properties");

          pf.load(pfile);

         String url = pf.getProperty("url");
         String user = pf.getProperty("user");
         String password = pf.getProperty("password");

          System.out.println(url);


          Connection con1 = DriverManager.getConnection(url, user, password);



          /*
        5. Read data from employee.xlsx file and insert into the employee table.
        */

        File file = new File("C:\\Users\\fc\\Zorba_exam_submission\\JDBCExam1016\\src\\main\\resources\\employee.xlsx");

        FileInputStream fileInputStream = new FileInputStream(file);


          XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
          Sheet sheet = workbook.getSheetAt(0);

          String insertStatement = "Insert into employee values(?,?,?,?,?,?,?);";

          PreparedStatement preparedStatement = con.prepareStatement(insertStatement);

          for(Row row : sheet) {
              if(row.getRowNum() == 0) {
                  continue;
              }
              int empid = (int) row.getCell(0).getNumericCellValue();
              String empName = row.getCell(1).getStringCellValue();
              String empAddress = row.getCell(2).getStringCellValue();
              double salary = row.getCell(3).getNumericCellValue();
              int empMobile = (int) row.getCell(4).getNumericCellValue();
              String deptName = row.getCell(5).getStringCellValue();
              Date doj = row.getCell(6).getDateCellValue();

              preparedStatement.setInt(1, empid);
              preparedStatement.setString(2, empName);
              preparedStatement.setString(3, empAddress);
              preparedStatement.setDouble(4, salary);
              preparedStatement.setInt(5, empMobile);
              preparedStatement.setString(6, deptName);

              SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
              String formattedDate = simpleDateFormat.format(doj);

              preparedStatement.setString(7, formattedDate);

              preparedStatement.executeUpdate();


          }

          // 6
    }catch(SQLException e){
          System.out.println("connection error");
      e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

}
