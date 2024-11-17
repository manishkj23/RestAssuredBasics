package StringsPrograms;

public class Practice {

	public static void main(String[] args) {

		String name = "Manish Kumar Jain";
		for (char ch : name.toCharArray())
		{
			System.out.println(ch);
		}
		
		System.out.println("**********************");
		
		for (int i=0;i<name.length();i++)
		{
			char ch1 = name.charAt(i);
			System.out.println(ch1);
		}

	}

}
