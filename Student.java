
import java.util.Date;

public class Student
{
	private int st_id;
        private String st_phone;
	private String st_lastname;
	private String st_midname;
	private String st_firstname;
	private String st_gender;
        private String st_address;
        private int st_gradelevel;
	private int st_age;
	private boolean st_enrolled;

	public void setID(int st_id)
	{
		this.st_id = st_id;
	}
        
        public void setGradelevel(int st_gradelevel)
        {
                this.st_gradelevel = st_gradelevel;
        }
        public void setPhone(String st_phone)
        {
                this.st_phone = st_phone;
        }
        
	public void setLastname(String st_lastname)
	{
		this.st_lastname = st_lastname;
	}
	public void setAddress(String st_address)
	{
		this.st_address = st_address;
	}
	public void setMidname(String st_midname)
	{
		this.st_midname = st_midname;
	}	
	
	public void setFirstname(String st_firstname)
	{
		this.st_firstname = st_firstname;
	}
	
	public void setGender(String st_gender)
	{
		this.st_gender = st_gender;
	}	
	
	public void setAge(int st_age)
	{
		this.st_age = st_age;
	}

	public void setEnrolled(boolean st_enrolled)
	{
		this.st_enrolled = st_enrolled;
	}
	
	public int getId()
	{
		return st_id;
	}
	
        public String getPhone()
        {
                return st_phone;
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
	
        public String getAddress()
        {
                return st_address;
        }
        
	public String getGender()
	{
		return st_gender;
	}
        
	
	public int getAge()
        {
            return st_age;
	}
	
	public boolean getEnrolled()
	{
		return st_enrolled;
	}
        
        public int getGradelevel()
        {
                return st_gradelevel;
        }
	}
