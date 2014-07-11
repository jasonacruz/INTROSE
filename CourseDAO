import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class CourseDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean addCourse(Course c)
	{
		try {
				String queryString = "INSERT INTO SECTION(course_name, course_description) VALUES (?, ?)";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, c.getCoursename());
				stmt.setString(2, c.getCourseDesc());
				stmt.executeUpdate();
			}catch (SQLException e) {
			return false;
	}
	return true;
	}
}
