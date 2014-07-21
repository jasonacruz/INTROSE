import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionFactory {
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/try1";
	String dbUser = null;
	String dbPwd = null;

	private static ConnectionFactory connectionFactory = null;
        
        public boolean Authorize() //Idea taken from the INTROSE project example given to us
        {
        try {
			if (dbUser == null && dbPwd == null){
				InputStream input = getClass().getResourceAsStream("db.txt");
				Scanner s = new Scanner(input);
				String user = s.nextLine();
				String pass = s.nextLine();
				this.dbUser= user;
				this.dbPwd = pass;
			}
		}
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;}
              return true;
        }
	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
                        
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
                Authorize();
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
                        
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
}
