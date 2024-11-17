package BasicsProgramming;

import java.util.Scanner;

public class FibonacciSeries {

	public static void main(String[] args) {
		//Method-1
		int n = 10; // Number of terms in the Fibonacci series
        int firstTerm = 0, secondTerm = 1;
        
        System.out.println("Fibonacci Series up to " + n + " terms:");

        for (int i = 1; i <= n; ++i) {
            System.out.print(firstTerm + " ");

            // Compute the next term
            int nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        
        //Method-2
        int fiblength;

     // Use scanner class to get the user input.
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the number : ");
     fiblength = sc.nextInt();

     int[] num = new int[fiblength];
     // Assign values 0 and 1 to the 0 and 1 indices of the defined array
     num[0] = 0;
     num[1] = 1;

     // Logic for getting the values of all the indices of the array using for loop
     for (int i = 2; i < fiblength; i++) {
     num[i] = num[i - 1] + num[i - 2];
     }

     System.out.print("fibonacci series: ");
     // Printing the fibonacci series
     for (int i = 0; i < fiblength; i++) {
     System.out.print(num[i] + " ");
     }
    }

	}
