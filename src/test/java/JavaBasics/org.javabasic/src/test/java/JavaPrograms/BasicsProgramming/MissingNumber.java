package BasicsProgramming;

public class MissingNumber {

	public static void main(String[] args) {
		
		int a[] = {1,2,4,5};
		int sum = 0;
		for(int i=0; i<a.length;i++)
		{
			sum = sum + a[i];
		}
		System.out.println("Addition of the numbers present in array are: " + sum);
		
		int sum1 = 0;
		for (int j=0; j<=5;j++)
		{
			sum1 = sum1 + j;
		}
		System.out.println("Addition of the numbers present in for loop are: " + sum1);
		
		System.out.println("Missing number is: " + (sum1 - sum));
		

	}

}
