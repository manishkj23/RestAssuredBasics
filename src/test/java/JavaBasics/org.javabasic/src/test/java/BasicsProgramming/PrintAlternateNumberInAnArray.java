package BasicsProgramming;

public class PrintAlternateNumberInAnArray {

	public static void main(String[] args) {

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Alternate numbers in the array are:");
        for (int i = 0; i < numbers.length; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        
        
        //Method 2:
        System.out.println("Alternate numbers in the array are:");
        int i = 0;
        while (i < numbers.length) {
            System.out.print(numbers[i] + " ");
            i += 2;
        }
        
	}

}
