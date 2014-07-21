import java.util.Date;
public class Department{

	private String dept_name;
	private int dept_empID;
	private Date dept_hired;
	private Date dept_hiredto;
        private Employee emp;
	public void setDepartmentName(String dept_name)
	{
		this.dept_name = dept_name;
	}
	public void setDepartmentEmp(String dept_name, int dept_empID, Date dept_hired)
	{
		this.dept_name = dept_name;
		this.dept_empID = dept_empID;
		this.dept_hired = dept_hired;
	}

        public void setEmp(Employee emp)
        {
            this.emp = emp;
        }
        
	public void setEmployee(int dept_empID)
	{
		this.dept_empID = dept_empID;
	}
	
	public void setEmpHired(Date dept_hired)
	{
		this.dept_hired = dept_hired;
	}
	
	public void setEmpHiredto(Date dept_hiredto)
	{
		this.dept_hiredto = dept_hiredto;
	}
	
	public String getDeptname()
	{
		return dept_name;
	}
	
        public Employee getEmp()
        {
            return emp;
        }
	public int getEmpID()
	{
		return dept_empID;
	}
	
	public Date getHired()
	{
		return dept_hired;
	}
	
	public Date getHiredto()
	{
		return dept_hiredto;
	}
}

	
