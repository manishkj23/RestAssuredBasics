package StringsPrograms;

public class WordChangeInAString {

	public static void main(String[] args) {
		String s = "A RED SEED";
		String w = "";
		s = s + " ";
		String nw = "";
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(c != ' ') 
			{
				w = w + c;
			}
			else
			{
				if(w.equals("RED"))
				{
					nw = nw + "BLUE" + " ";
				}
				else
				{
					nw = nw + w + " ";
				}
				w = "";
			}	
		}
		System.out.println(nw);
	}

}
