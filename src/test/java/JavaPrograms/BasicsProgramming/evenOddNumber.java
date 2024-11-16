package BasicsProgramming;

public class evenOddNumber {

	public static void main(String[] args) {
	
		int[] numbers = {10, -10, 20, 40, 60, 22, 15, 33, 45};

        System.out.println("Even numbers:");
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number);
            }
        }

        System.out.println("Odd numbers:");
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.println(number);
            }
        }

	}

}
