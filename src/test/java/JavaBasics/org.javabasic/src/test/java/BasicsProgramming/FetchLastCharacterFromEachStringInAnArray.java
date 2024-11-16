package BasicsProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FetchLastCharacterFromEachStringInAnArray {

	public static void main(String[] args) {

		String[] stringArray = {"Hello", "World", "Java", "Programming"};
        List<String> stringList = new ArrayList<>(Arrays.asList(stringArray));

        Iterator<String> iterator = stringList.iterator();

        System.out.println("Last characters of each string:");
        while (iterator.hasNext()) 
        {
            String currentString = iterator.next();
            if (!currentString.isEmpty()) {
                char lastChar = currentString.charAt(currentString.length() - 1);
                System.out.println(lastChar);
            } else {
                System.out.println("Empty string");
            }
        } 
        
        System.out.println("**************Using For Loop***********************");
        
        
        //Using For loop:
        String[] arr = {"mango","apple","kiwi"};
        for(int i=0;i<arr.length;i++)
        {
            String ele = arr[i];
            for(int j=ele.length()-1;j>0;j--)
            {
            char c = ele.charAt(j);
//            System.out.println("Last character of the string is : " + c);
            System.out.print(c+""); //add all the first character of the word to make it a meaningful word
            break;
            }
        }
        
	}

}