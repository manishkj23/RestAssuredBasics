package BasicsProgramming;

import java.util.Arrays;

public class SortIntegerInAnArray {

	public static void main(String[] args) {

		System.out.println("************ 1st Approach ***************");

		int[] digits = {5, 3, 8, 1, 2, 7, 4, 6, 9, 0};
		// Sorting the array
		Arrays.sort(digits);	
		// Printing the sorted array
		System.out.println("Sorted Digits: " + Arrays.toString(digits));


		System.out.println("\n************ Sort Integer In Descending Order ***************");

		int[] arr = {3, 5, 8, 1, 2, 7, 4, 6, 9, 0};
		System.out.print("\nBefore Sorting: ");
		for(int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}


		for ( int i=0;i<arr.length;i++)
		{
			int temp = 0;
			for(int j=i+1;j<arr.length;j++)
				if(arr[j]>arr[i]) // 5 > 3 
				{
					temp = arr[j]; //5
					arr[j] = arr[i];
					arr[i] = temp;
				}

		}

		System.out.print("\nAfter Sorting: ");
		for(int i =0; i<arr.length;i++)
		{
			System.out.print(arr[i] + " ");
		}


		System.out.println("\n************ Sort Integer In Ascending Order ***************");


		int[] arr1 = {3, 5, 8, 1, 2, 7, 4, 6, 9, 0};
		System.out.print("\nBefore Sorting: ");
		for(int i =0; i<arr1.length;i++)
		{
			System.out.print(arr1[i] + " ");
		} 
		for ( int i=0;i<arr1.length;i++)
		{
			int temp1 = 0;
			for(int j=i+1;j<arr1.length;j++)
				if(arr1[j]<arr1[i]) // 5 > 3 
				{
					temp1 = arr1[j]; //5
					arr1[j] = arr1[i];
					arr1[i] = temp1;
				}

		} 
		System.out.print("\nAfter Sorting: ");
		for(int i =0; i<arr1.length;i++)
		{
			System.out.print(arr1[i] + " ");
		}

	}
}