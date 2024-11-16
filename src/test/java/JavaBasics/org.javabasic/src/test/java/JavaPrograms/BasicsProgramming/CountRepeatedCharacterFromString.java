package BasicsProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatedCharacterFromString {

	public static void main(String[] args) {
		
		//1. with space
		String str = "Manish Kumar Jain";
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                charCountMap.put(ch, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println("**********************************");
        
        //2. without space
        String str1 = "Looking for a change";
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char ch1 : str1.toCharArray()) {
            if (ch1 == ' ') {
                continue; // Skip spaces
            }
            if (charCount.containsKey(ch1)) {
            	charCount.put(ch1, charCount.get(ch1) + 1);
            } else {
            	charCount.put(ch1, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println("**********************************");
        
        //3. using charAt index
        
        String str2 = "Learning Selenium with Java";
        HashMap<Character, Integer> charCountMap1 = new HashMap<>();

        for (int i = 0; i < str.length(); i++) 
        {
            char ch2 = str2.charAt(i);
            if (ch2 == ' ') {
                continue; // Skip spaces
            }
            if (charCountMap1.containsKey(ch2)) {
                charCountMap1.put(ch2, charCountMap1.get(ch2) + 1);
            } else {
                charCountMap1.put(ch2, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCountMap1.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        
        System.out.println("**********************************");
        
        for(Character x:charCountMap1.keySet())
		{
			System.out.println("The count of word :"+x+" = " +charCountMap1.get(x));
		}
        
	}

}