
public class ErrorHandler{


	public boolean sLength(String s, int l, int h)
	{
		if(s.length() > h|| s.length() < l)
			return true;
		else
			return false;
		}
	public boolean sCheckSpace(String s)
	{
		int x;
		
		for(x = 0; x< s.length(); x++)
		{
			if(s.charAt(x) == ' ' && s.charAt(x+1) == ' ')
				return false;
		}
			return true;
	}
			
	public boolean sCheckNames(String s)
	{
		int x;
		if((s.isEmpty()))
                                return false;
		for(x = 0; x < s.length(); x++)
		{
			if((s.charAt(x) < 48 && s.charAt(x) != 32 && s.charAt(x) !=45) || (s.charAt(x) > 57 && s.charAt(x) < 65) || (s.charAt(x) > 90 && s.charAt(x) < 96) || (s.charAt(x) > 122 && s.charAt(x) < 128) || s.charAt(x) > 165)
				return false;
			if(s.charAt(x) == ' ' && s.charAt(x+1) == ' ')
				return false;
		}
		return true;
	}
	
	public boolean sCheckCodes(String s, int stype) //stype 1 = username & stype 0 = password & stype 2 for numbers
	{
		int x;
		if((s.isEmpty()))
                                return false;
                
		for(x = 0; x < s.length(); x++)
		{
                        
			
                        if((s.charAt(x) < 33 || s.charAt(x) > 126) && stype == 0){
                                return false;
                        }
                                
                        if((s.charAt(x) < 48 || (s.charAt(x) > 57 && s.charAt(x) < 65) || (s.charAt(x) > 90 && s.charAt(x) < 97) || s.charAt(x) > 122) && stype ==1)
				return false;
                        if((s.charAt(x) < 48 || s.charAt(x) > 57) && stype == 2)
                                return false;
		}
		return true;
	}
}
