




import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {


    public static void main(String[] args) {
        List<Employee> employeeList = populateEmployee();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet();

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Employee ID");
            headerRow.createCell(1).setCellValue("Employee Name");
            headerRow.createCell(2).setCellValue("Employee Address");
            headerRow.createCell(3).setCellValue("Employee Salary");
            headerRow.createCell(4).setCellValue("Employee Mobile");
            headerRow.createCell(5).setCellValue("Department");
            headerRow.createCell(6).setCellValue("Date of Joining");
            headerRow.createCell(7).setCellValue("Policy Id");

            // Write employee data to sheet
            int rowNum = 1;
            for (Employee employee : employeeList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getEmpId());
                row.createCell(1).setCellValue(employee.getEmpName());
                row.createCell(2).setCellValue(employee.getEmpAddress());
                row.createCell(3).setCellValue(employee.getEmpSalary());
                row.createCell(4).setCellValue(employee.getEmpMobile());
                row.createCell(5).setCellValue(employee.getDepartment());
                row.createCell(6).setCellValue(employee.getDateOfJoining());
                row.createCell(7).setCellValue(employee.getPolicyId());
            }

            // Write the Excel file to the specified path
            try (FileOutputStream fileOut = new FileOutputStream("/Users/sarojshrestha/Desktop/Zorba/Zorba-Exam-Submission/zorba_exam/employees.xlsx")) {
                workbook.write(fileOut);
            }

            // Alter the employee table to add policy_id column and foreign key constraint
            alterEmployeeTable();

            System.out.println("Excel file has been populated and database table altered successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Employee> populateEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1001, "Jhon Tracker", "Austin", 1200.93, 9099991212L, "Finance", "2021-02-03", 1001));
        employeeList.add(new Employee(1002, "Bhaba George", "Texas", 2312.21, 7809991212L, "HR", "1998-12-21", 1003));
        employeeList.add(new Employee(1003, "James Adams", "Florida", 1220.12, 9879799670L, "Finance", "1989-12-12", 1004));
        employeeList.add(new Employee(1004, "Shiv Sharma", "London", 1345.21, 8879799670L, "Engg", "2009-05-01", 1002));
        employeeList.add(new Employee(1005, "David Goon", "France", 1890.98, 6766676670L, "Science", "2003-09-09", 1003));
        return employeeList;
    }

    private static double alterEmployeeTable() {
        Connection connection = null;
        Statement statement = null;
        String sql = "{? = call calculate_premium(?, ?, ?, ?)}";

        try {
            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zorba_exams", "root", "root");

            // Create statement object to execute SQL queries
            statement = connection.createStatement();


            // Alter the employee table to add the policy_id column
            String alterQuery = "alter table employees add column policy_id int";
            statement.executeUpdate(alterQuery);


// Add foreign key constraint to link policy_id with emp_policy table
            String addForeignKeyQuery = "alter table employees " +
                    "add constraint fk_policy foreign key (policy_id) " +
                    "references emp_policy(policy_id)";
            statement.executeUpdate(addForeignKeyQuery);

            // SQL query to add a new column 'emp_premium' in the 'employee' table
            String sql1 = "ALTER TABLE employee ADD COLUMN emp_premium DECIMAL(10, 2);";
            statement.executeUpdate(sql1);
            System.out.println("Column 'emp_premium' added successfully.");




            List<Employee> employeeList = populateEmployee();
            for (Employee emp : employeeList) {
                CallableStatement callableStatement = connection.prepareCall(sql);
                callableStatement.setInt(2, emp.getEmpId());
                callableStatement.registerOutParameter(1, Types.DOUBLE);

                callableStatement.execute();
                double premium = callableStatement.getDouble(1);


                System.out.println("Premium for employee " + emp.getEmpName() + ": " + premium);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}

    }
