import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class EmployeeDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	public boolean addEmployees(Employee emp)
	{
	try
		{
			String queryString = "INSERT INTO EMPLOYEE(emp_id, emp_firstname, emp_midname, emp_lastname, emp_pos, emp_pass, emp_user, emp_changedpass, emp_phone, emp_address) VALUES (?,?,?,?,? , 12345678 , emp_id, false, ? ,?)";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
			stmt.setInt(1, emp.getID());
			stmt.setString(2, emp.getFirstname());
			stmt.setString(3, emp.getMidname());
			stmt.setString(4, emp.getLastname());
			stmt.setString(5, emp.getPosition());
			stmt.setString(6, emp.getPhone());
			stmt.setString(7, emp.getAddress());
			stmt.executeUpdate();
			}catch (SQLException e) {
			 System.out.println(e.getMessage() + e.getErrorCode());
			return false;
	}
		return true;
			}
	public boolean regEmployees(Employee emp)
	{
            int x =0;
	try
		{
			String queryString = "UPDATE EMPLOYEE SET emp_pass = ?, emp_user = ?, emp_changedpass = ? WHERE emp_id = ? AND emp_firstname = ? AND emp_midname = ? AND emp_lastname = ? AND emp_pos = ? AND emp_changedpass = false";
			connection = getConnection();
			stmt = connection.prepareStatement(queryString);
                        
                        stmt.setString(1, emp.getPass());
			stmt.setString(2, emp.getUsername());
                        stmt.setBoolean(3, true);
                        stmt.setInt(4, emp.getID());
			stmt.setString(5, emp.getFirstname());
			stmt.setString(6, emp.getMidname());
			stmt.setString(7, emp.getLastname());
                        stmt.setString(8, emp.getPosition());
			x = stmt.executeUpdate();
                        System.out.println(x);
			}catch (SQLException e) {
			 System.out.println(e.getMessage());
                         x = 0;
	}
                if(x == 0)
                    return false;
                else
                    return true;
			}
        public boolean getEmpInfo(Employee emp)
        { 
            try
            {
                    String queryString = "SELECT * FROM EMPLOYEE WHERE emp_lastname = ? AND emp_firstname = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, emp.getLastname());
                    stmt.setString(2, emp.getFirstname());
                    
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    emp.setFirstname(resultString.getString("emp_firstname"));
                    emp.setMidname(resultString.getString("emp_midname"));
                    emp.setLastname(resultString.getString("emp_lastname"));
                    emp.setID(resultString.getInt("emp_id"));
                    emp.setChangedpass(resultString.getBoolean("emp_changedpass"));
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
                         return true;
        }
              
        
        public String getLoginReq(Employee emp) 
        {
            String x = "null";
            try
            {
                    String queryString = "SELECT * FROM EMPLOYEE WHERE emp_user = ? AND emp_pass = ?";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    stmt.setString(1, emp.getUsername());
                    stmt.setString(2, emp.getPass());
                    
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    x = resultString.getString("emp_pos");
                    emp.setFirstname(resultString.getString("emp_firstname"));
                    emp.setMidname(resultString.getString("emp_midname"));
                    emp.setLastname(resultString.getString("emp_lastname"));
                    emp.setID(resultString.getInt("emp_id"));
                    emp.setPhone(resultString.getString("emp_phone"));
                    emp.setAddress(resultString.getString("emp_address"));
                    emp.setChangedpass(resultString.getBoolean("emp_changedpass"));
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
            }
		return x;
        }
			
}
