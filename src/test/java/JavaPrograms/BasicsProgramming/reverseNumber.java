package BasicsProgramming;

import java.util.Scanner;

public class reverseNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num = sc.nextInt();
		//1. using algorithm
		
		int rev = 0;
		while(num !=0)
		{
			rev = rev*10 + num%10;
			num =  num/10;
		}
		System.out.println("Reverse number is : " + rev);
		
		//2. using StringBuffer class
		int numb = sc.nextInt();
		StringBuffer rever;
		StringBuffer sb = new StringBuffer(String.valueOf(numb)); 
		//here we are converting our number int value "number" in String format and that string value will be stored in sb with the help of String.valueOf method.
		rever = sb.reverse();
		System.out.println("Reverse number is : " + rever);
		
		//3. Using StringBuilder class
		int number = sc.nextInt();
		StringBuilder sbl = new StringBuilder();
		sbl.append(number);
		StringBuilder reverse = sbl.reverse();
		System.out.println("Reverse number is : " + reverse);	
				
	}

}
