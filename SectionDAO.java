import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.lang.Exception;

public class SectionDAO{
	Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean addSection(Section s)
	{
		try {
				String queryString = "INSERT INTO SECTION(sect_num, sect_name, sect_yrlvl) VALUES (?, ?, ?)
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setNull(1, java.sql.Types.INTEGER);
				stmt.setString(2, s.getSectname());
				stmt.setInt(3, s.getYearlvl());
				stmt.executeUpdate();
			}catch (SQLException e) {
			return false;
	}
	return true;
	}
}
