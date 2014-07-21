
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeDAO {
    Connection connection = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
	
	public boolean addGradeComp(Grade g)
	{
		try {
				String queryString = "INSERT INTO gradecomp(course_name, grade_type, grade_number, student_id, student_grade, class_prof, schoolquarter, schoolYear) VALUES (?, ?, ?, ?,?,?,1,year(current_time))";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, g.getRoom().getCourse().getCoursename());
				stmt.setString(2, g.getGrade_type());
                                stmt.setInt(3, g.getGrade_number());
				stmt.setInt(4, g.getRoom().getStudent().getId());
                                stmt.setInt(5, g.getSt_grade());
                                stmt.setInt(6, g.getRoom().getEmp().getID());
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
	}
        
        public boolean addFinalGrade(Grade g)
        {
		try {
				String queryString = "INSERT INTO finalgrade(course_name, student_id, student_grade, class_prof, schoolquarter, schoolYear) VALUES (?, ?, ?, ?, 1, year(current_time))";
				connection = getConnection();
				stmt = connection.prepareStatement(queryString);
				stmt.setString(1, g.getRoom().getCourse().getCoursename());
				stmt.setInt(2, g.getRoom().getStudent().getId());
                                stmt.setInt(3, g.getSt_grade());
                                stmt.setInt(4, g.getRoom().getEmp().getID());
                                stmt.setInt(5, g.getSchoolquarter());
                                stmt.setInt(6, g.getSchoolyear());
                                
				stmt.executeUpdate();
			}catch (SQLException e) {
                            System.out.println(e.getMessage());
			return false;
	}
	return true;
	}
}
