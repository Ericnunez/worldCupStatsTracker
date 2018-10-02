import java.sql.*;

public class Connect {

   public static Connection getConnection() throws SQLException {
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/worldCup?serverTimezone=UTC&useSSL=false";
	String user = "student";
	String password = "student";
	conn =  DriverManager.getConnection(url, user, password);
	return conn;
   }

    public static void test(){
	try {
	    Connection conn = getConnection();
	    if (conn!=null)
	       System.out.println("Connection successful");
	    conn.close();
	}catch(SQLException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	test();  
    }
}
