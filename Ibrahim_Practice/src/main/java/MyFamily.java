import java.sql.*;

public class MyFamily {
    public static void main(String[] args) throws SQLException {

       Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/zorba_exams","root","AlinaSALA.$2013");
       String createQuery="create table if not exists Ameen(id int, firstname varchar(100),lastname varchar(100),city varchar(100))";
       PreparedStatement preparedStatement = connection.prepareStatement(createQuery);
       preparedStatement.execute();







    }
}
