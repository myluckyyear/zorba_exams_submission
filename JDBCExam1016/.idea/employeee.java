public class employeee {,
        import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

    class Employee {
        private String name;
        private int id;
        private double salary;
        private String address;

        public Employee(String name, int id, double salary, String address) {
            this.name = name;
            this.id = id;
            this.salary = salary;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public double getSalary() {
            return salary;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", salary=" + salary +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public class EmployeeSorter {
        public static void main(String[] args) {
            List<Employee> employees = new ArrayList<>();
            employees.add(new Employee("Alice", 101, 50000, "123 Main St"));
            employees.add(new Employee("Bob", 102, 75000, "456 Elm St"));
            employees.add(new Employee("Charlie", 103, 75000, "789 Oak St"));
            employees.add(new Employee("David", 104, 45000, "101 Maple St"));
            employees.add(new Employee("Eve", 105, 75000, "321 Pine St"));

            Comparator<Employee> complexComparator = Comparator
                    .comparingDouble(Employee::getSalary).reversed()
                    .thenComparing(Employee::getName)
                    .thenComparingInt(Employee::getId);

            employees.sort(complexComparator);

            System.out.println("Employees sorted by salary (descending), name (ascending), and ID (ascending):");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }
    }




import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

    public class ExcelReader {

        public static void main(String[] args) {
            // Create a connection to the MySQL database
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zorba_exams", "root", "Kandara@2")) {
                // Load the database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Connection is Successful....");

                // Fetch the Employee List
                List<Employee> employeeList = populateEmployee();

                // Prepare the SQL insert statement
                String insertStatement = "INSERT INTO employees (emp_id, emp_name, emp_address, emp_salary, emp_mobile, dept_name, doj) VALUES (?, ?, ?, ?, ?, ?, ?)";

                // Insert data into the employees table
                for (Employee employee : employeeList) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertStatement)) {
                        preparedStatement.setInt(1, employee.getEmpId());
                        preparedStatement.setString(2, employee.getEmpName());
                        preparedStatement.setString(3, employee.getEmpAddress());
                        // Convert double to BigDecimal and insert
                        preparedStatement.setBigDecimal(4, BigDecimal.valueOf(employee.getEmpSalary()));
                        preparedStatement.setString(5, String.valueOf(employee.getEmpMobile())); // For VARCHAR (Mobile), use setString
                        preparedStatement.setString(6, employee.getDepartment());
                        preparedStatement.setDate(7, Date.valueOf(employee.getDateOfJoining())); // Converting LocalDate to SQL Date

                        int noOfRows = preparedStatement.executeUpdate();
                        System.out.println(noOfRows + " row inserted!!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }

        // A method to populate employee data (this should read data from the Excel file or populate mock data)
        private static List<Employee> populateEmployee() {
            List<Employee> employeeList = new ArrayList<>();
            // For now, adding mock data, replace with actual data extraction from Excel
            employeeList.add(new Employee(1001, "Jhon Tracker", "Austin", 1200.93, 9099991212L, "Finance", "2021-02-03"));
            employeeList.add(new Employee(1002, "Bhaba George", "Texas", 2312.21, 7809991212L, "HR", "1998-12-21"));
            employeeList.add(new Employee(1003, "James Adams", "Florida", 1220.12, 9879799670L, "Finance", "1989-12-12"));
            employeeList.add(new Employee(1004, "Shiv Sharma", "London", 1345.21, 8879799670L, "Engg", "2009-05-01"));
            employeeList.add(new Employee(1005, "David Goon", "France", 1890.98, 6766676670L, "Science", "2003-09-09"));
            return employeeList;
        }
    }

    class Employee {
        private int empId;
        private String empName;
        private String empAddress;
        private double empSalary; // Change to BigDecimal for option 2
        private long empMobile;
        private String department;
        private LocalDate dateOfJoining;

        public Employee(int empId, String empName, String empAddress, double empSalary, long empMobile, String department, String dateOfJoining) {
            this.empId = empId;
            this.empName = empName;
            this.empAddress = empAddress;
            this.empSalary = empSalary;
            this.empMobile = empMobile;
            this.department = department;
            this.dateOfJoining = LocalDate.parse(dateOfJoining); // Converting String to LocalDate
        }

        // Getters
        public int getEmpId() {
            return empId;
        }

        public String getEmpName() {
            return empName;
        }

        public String getEmpAddress() {
            return empAddress;
        }


        public double getEmpSalary() {
            return empSalary;
        }

        public long getEmpMobile() {
            return empMobile;
        }

        public String getDepartment() {
            return department;
        }

        public LocalDate getDateOfJoining() {
            return dateOfJoining;
        }
    }

}
