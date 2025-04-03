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

        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection established");


        String sql = "select * from student";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);


        while(rs.next()) {
            int id = rs.getInt("sid");
            String name = rs.getString("sname");
            int marks = rs.getInt("marks");
            System.out.println(id + " : " + name + " : " + marks);
        }

        con.close(); //close the connection
    }
}
