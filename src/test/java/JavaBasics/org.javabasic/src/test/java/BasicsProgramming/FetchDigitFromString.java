package BasicsProgramming;

import java.util.stream.Collectors;

public class FetchDigitFromString {

	public static void main(String[] args) {
		
		System.out.println("************** Using replaceAll ******************");  

		int total = 200;
		String input = "Searched 100 Pages";
        String digits = input.replaceAll("\\D+", "");
        /*
         Explanation:
				input.replaceAll("\\D+", ""): This line uses a regular expression to replace all non-digit 
				characters (\\D+) with an empty string, effectively extracting only the digits from the 
				input string.
         */
        System.out.println("Extracted Digits: " + digits);
        
        if(total == (Integer.parseInt(digits)))
        {
        	System.out.println("total row matches");
        }
        else
        {
        	System.out.println("total row mismatches");
        }
        
        String digits3= input.replaceAll("\\C+", "");
        System.out.println("Extracted Character : " + digits3);
        
      System.out.println("************** Using toCharArray ******************");  
     
      StringBuilder digits1 = new StringBuilder();

      for (char c : input.toCharArray()) {
          if (Character.isDigit(c)) {
              digits1.append(c);
          }
      }

      System.out.println("Extracted Digits: " + digits1.toString());
      
      if(digits1.equals(total) )
      {
      	System.out.println("total row matches via Stringbuider");
      }
      else
      {
      	System.out.println("total row mismatches via Stringbuider");
      }
      
      /*
       Explanation:
We use a StringBuilder to efficiently build the string of digits.
We iterate through each character of the input string using a for-each loop.
For each character, we check if it is a digit using Character.isDigit(c).
If it is a digit, we append it to the StringBuilder.
Finally, we convert the StringBuilder to a string and print the extracted digits.
       */
      
      
      System.out.println("************** By using Java Streams ******************");  
      
      
      String digits2 = input.chars()
              .filter(Character::isDigit)
              .mapToObj(c -> String.valueOf((char) c))
              .collect(Collectors.joining());

      			System.out.println("Extracted Digits: " + digits2);
      
      			/*
      			 Explanation:
input.chars(): Converts the string into an IntStream of characters.
filter(Character::isDigit): Filters the stream to include only digit characters.
mapToObj(c -> String.valueOf((char) c)): Maps each integer in the stream to its corresponding character and then to a string.
collect(Collectors.joining()): Collects the resulting strings into a single string.
      			 */
  }

}
