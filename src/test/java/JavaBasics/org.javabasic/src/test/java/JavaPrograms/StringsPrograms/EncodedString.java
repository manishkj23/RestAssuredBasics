package StringsPrograms;

public class EncodedString {

	public static void main(String[] args) {
		
		String enc="";
		String s = "SIMPLY";
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c == 'Y' || c == 'y' || c == 'Z' || c == 'z')
			{
			c-=26;
			}
			c+=2;
			enc = enc + c ;			
		}
		System.out.println(enc);
		
	}

}