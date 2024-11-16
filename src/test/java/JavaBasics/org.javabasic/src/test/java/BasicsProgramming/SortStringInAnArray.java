package BasicsProgramming;

import java.util.Arrays;

public class SortStringInAnArray {

	public static void main(String[] args) {
		
		
		System.out.println("**************** Using For Loop ********************"); 

		//defining an array of type String  
		String[] countries = {"Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", "Australia", "Denmark", "France", "Netherlands", "Italy", "Germany"};  
		int size = countries.length;  
		//logic for sorting   
		for(int i = 0; i<size; i++)   
		{  
			for (int j = i+1; j<countries.length; j++)   
			{  
				//compares each elements of the array to all the remaining elements  
				if(countries[i].compareTo(countries[j])>0)   
				{  
					//swapping array elements  
					String temp = countries[i];  
					countries[i] = countries[j];  
					countries[j] = temp;  
				}  
			}  
		}  
		//prints the sorted array in ascending order  
		System.out.println(Arrays.toString(countries)); 
		
		System.out.println("**************** Using Stream ********************"); 
		
		
		// Using Java 8 Streams to sort the array
        Arrays
            .stream(countries) // Creating a stream from the array
            .sorted() 		   // Sorting the stream of strings
            .forEach(System.out::println); // Printing each sorted element
        
        
        System.out.println("**************** Using Array.sort logic********************"); 
        
        
      String[] arr = {"Wood apple", "Blackberry", "Date", "Naseberry", "Tamarind", "Fig", "Mulberry",  "Apple", "Plum",  "Orange", "Custard apple",  "Apricot"};  
      //sorts string array in alphabetical order or ascending order  
      Arrays.sort(arr);  
      //prints the sorted string array in ascending order  
      System.out.println(Arrays.toString(arr));  
      }     

}