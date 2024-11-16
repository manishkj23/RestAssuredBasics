package BasicsProgramming;

public class NumberPrimeOrNotAndGetPrimeNumber {

	public static void main(String[] args) {
		int number = 29; 
		System.out.println(isPrime(number));
        boolean checkPrime  = isPrime(number);
        
        if (checkPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
        
       getPrimeNumber(number);
	}
	

	public static boolean isPrime(int num) {
		// Validate that the number is neither less than 1 nor equal to 1. It should return false as it cannot be a prime number
		// Edge / Corner cases: 0, 1, and negative numbers are not prime numbers
		if (num <= 1) {
			return false;
		}
		// Logic to check if a number is prime or not. If its Prime, returns true else return false
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void getPrimeNumber( int number )
	{
		for(int i=2; i<=number ; i++)
		{
		if(isPrime(i))
		{
			System.out.println(i + " ");
		}
	}
}
	
}
