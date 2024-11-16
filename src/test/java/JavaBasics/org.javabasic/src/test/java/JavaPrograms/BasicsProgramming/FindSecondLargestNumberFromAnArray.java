package BasicsProgramming;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FindSecondLargestNumberFromAnArray {

	public static void main(String[] args) {
		
		int[] numbers = {12, 20, 10,43,30, 45};
        System.out.println("Second largest number is: " + findSecondLargest(numbers));
        
        //using Iterator:
        System.out.println("**************Using Iterator ********************");
        Integer[] numbersArray = {12, 20, 30, 40};
        List<Integer> numbersList = Arrays.asList(numbersArray);
        System.out.println("Second largest number is: " + findSecondLargest(numbersList));
    }

	//Using For Loop:
    public static int findSecondLargest(int[] array) {
    	
      int largest = 0;
      int secondLargest = 0;

        for (int number : array) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } 
            else if (number > secondLargest && number != largest) {
              secondLargest = number;
           }
        }        

        return secondLargest;  
    }
    
    //Using Iterator:
    public static int findSecondLargest(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        int largest = 0;
        int secondLargest = 0;

        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number != largest) {
                secondLargest = number;
            }
        }

        return secondLargest;
    }
}
