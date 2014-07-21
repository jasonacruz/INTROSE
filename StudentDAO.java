import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class StudentDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
       
	public boolean addStudent(Student s)
	{
		try {
				String queryString = "INSERT INTO Student(st_id, st_lastname, st_midname, st_firstname, st_gender, st_enrolled,st_phone, st_address, st_age, st_gradelevel) VALUES (? ,?, ?, ?, ?, true,?,?,?,?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setInt(1, s.getId());
				stmt.setString(2, s.getLastname());
				stmt.setString(3, s.getMidname());
				stmt.setString(4, s.getFirstname());
				stmt.setString(5, s.getGender());
                                stmt.setString(6, s.getPhone());
                                stmt.setString(7, s.getAddress());
				stmt.setInt(8, s.getAge());
                                stmt.setInt(9, s.getGradelevel());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
                            if(e.getErrorCode() == 1062)
                            {
                                try{
                                String queryString = "UPDATE STUDENT SET st_gradelevel = ? WHERE st_id = ?";
				connection = getConnection();
                                stmt = connection.prepareStatement(queryString);
                                stmt.setInt(1, s.getGradelevel());
				stmt.setInt(2, s.getId());
                                }catch(SQLException ex)
                                {}
                            }
	}
	return true;
	}
        
        public Boolean getStudentDetails(Student s)
        {
            try
            {
                    String queryString = "SELECT * FROM student";
                    connection = getConnection();
                    stmt = connection.prepareStatement(queryString);
                    
                    ResultSet resultString = stmt.executeQuery();
                    resultString.next();
                    s.setFirstname(resultString.getString("st_firstname"));
                    s.setMidname(resultString.getString("st_midname"));
                    s.setLastname(resultString.getString("st_lastname"));
                    s.setID(resultString.getInt("st_id"));
                    s.setPhone(resultString.getString("st_phone"));
                    s.setGradelevel(resultString.getInt("st_gradelevel"));
                    s.setAddress(resultString.getString("st_address"));
            }
            catch (SQLException e) {
			 System.out.println(e.getMessage());
                         return false;
            }
                return true;
        }
}
