package StringsPrograms;

public class ExtractWordsFromString {

	public static void main(String[] args) {
		String s = "My Name Is";
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
				System.out.println(w);
				w = "";
			}	
		}

	}

}