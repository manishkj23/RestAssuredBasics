package StringsPrograms;

import org.apache.poi.poifs.crypt.ChainingMode;

public class SpecialWordCheck {

	public static void main(String[] args) {
		String s = "Mom Or Dad";
		String w = "";
		s = s + " ";
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c != ' ') 
			{
				w = w + c;
			}
			else
			{
				char f = w.charAt(0);
				char l = w.charAt(w.length()-1);
				if(Character.toUpperCase(f) == Character.toUpperCase(l))
				{
				System.out.println("Special word found in the String: " + w);
				}
				w = "";
			}	
		}

	}

}
