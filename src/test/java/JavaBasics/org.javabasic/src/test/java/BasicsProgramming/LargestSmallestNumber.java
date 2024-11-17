package BasicsProgramming;

public class LargestSmallestNumber {

	public static void main(String[] args) {
		int numbers[] = {10,20,30,-8,200};
        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
                max = numbers[i];
        }

        System.out.println("Smallest value: " + min);
        System.out.println("Largest value: " + max);

	}

}
