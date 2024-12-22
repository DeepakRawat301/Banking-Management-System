import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
 Connection con=null;

    public DataConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
           System.out.println("Class not found exception");
        }

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "12345");
        } catch (SQLException e) {

        }
    }
}
