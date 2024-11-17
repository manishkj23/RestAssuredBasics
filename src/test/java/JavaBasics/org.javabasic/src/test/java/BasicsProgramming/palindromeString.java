package BasicsProgramming;

import java.util.Scanner;

public class palindromeString {

	public static void main(String[] args) {

//		String str = "ABCD";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = sc.nextLine();
		String org_str = str;
		String rev= "";
		int len = str.length();
		
		for(int i=len-1;i>=0;i--)
		{
			rev = rev + str.charAt(i);
		}
		System.out.println("Reverse String is : " + rev);
		if(org_str.equalsIgnoreCase(rev))
		{
			System.out.println("String is palindrome string");
		}
		else
		{
			System.out.println("String is not palindrome string");
		}
	}

}
