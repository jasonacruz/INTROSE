import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class DepartmentDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean addDepartment(Department d)
	{
		try {
				String queryString = "INSERT INTO Department(Department)VALUES (?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, d.getDeptname());
				stmt.executeUpdate();
			}catch (SQLException e) {
			return false;
	}
	return true;
	}
	public boolean addDepartmentEmp(Department d)
	{
		try {
				String queryString = "INSERT INTO DepartmentEmp(dept_name, dept_empID, dept_hiredate, dept_hiredto) VALUES(?,?, CURRENT_DATE, '9999-12-31')";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, d.getDeptname());
				stmt.setInt(2, d.getEmpID());	
				stmt.executeUpdate();
			}catch (SQLException e) {
			return false;
	}
	return true;
	}
}
