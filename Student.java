
import java.util.Date;

public class Student
{
	private int st_id;
	private String st_lastname;
	private String st_midname;
	private String st_firstname;
	private String st_gender;
	private Date st_birthdate;
	
	public Student(int st_id, String st_lastname, String st_midname, String st_firstname, String st_gender, Date st_birthdate)
	{
		this.st_id = st_id;
		this.st_lastname = st_lastname;
		this.st_midname = st_midname;
		this.st_firstname = st_firstname;
		this.st_gender = st_gender;
		this.st_birthdate = st_birthdate;
	}
	
	public int getId()
	{
		return st_id;
	}
	
	public String getLastname()
	{
		return st_lastname;
	}
	
	public String getMidname()
	{
		return st_midname;
	}
	
	public String getFirstname()
	{
		return st_firstname;
	}
	
	public String getGender()
	{
		return st_gender;
	}
	
	public Date getBirthdate()
	{
		return st_birthdate;
	}
	
	}
