package BasicsProgramming;

import java.util.Scanner;

public class largestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first numbers");
		int a = sc.nextInt();
		
		System.out.println("Enter second numbers");
		int b = sc.nextInt();
		
		System.out.println("Enter third numbers");
		int c = sc.nextInt();
		if(a>b && a>c)
		{
			System.out.println("A is greater than B & C");
		}
		else if (b>c && b>a)
		{
			System.out.println("B is greater than A & C");
		}
		else
		{
			System.out.println("C is greater than A & B");
		}
		
		

	}

}
