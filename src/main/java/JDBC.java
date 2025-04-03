import java.sql.*;

public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        Import package
        Load and register the driver
        Create connection
        Create statement
        Execute statement
        Close the connection
         */

        Class.forName("org.postgresql.Driver"); //Optional

        String url = "jdbc:postgresql://localhost:5432/td4";
        String username = "postgres";
        String password = "1234";

        int id = 101;
        String name = "sangeetha";
        int marks = 100;

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");

        String sql = "insert into student values (?,?,?)";

        PreparedStatement st = con.prepareStatement(sql);
              st.setInt(1,id);
              st.setString(2, name);
              st.setInt(3, marks);
              st.execute();

        con.close(); //close the connection
    }
}
