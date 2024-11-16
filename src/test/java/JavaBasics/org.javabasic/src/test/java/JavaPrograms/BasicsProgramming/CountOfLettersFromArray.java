package BasicsProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CountOfLettersFromArray {

	public static void main(String[] args) {
		String[] alpha = {"a","b","","c","aa.bb","aa","c","d","c","b"};
		
		//Approach : 1 --> when you don't want to split the decimal part

		Integer count = 1;
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<alpha.length;i++)
		{
			if(!map.containsKey(alpha[i]))
			{
				map.put(alpha[i],count);
			}
			else
			{map.put(alpha[i], map.get(alpha[i])+1);}
		}

		for(Entry<String, Integer> entry : map.entrySet())
		{
			System.out.println(entry.getKey() + entry.getValue());
		}
		
		System.out.println("********************************************");
		
		//Approach : 2
		String[] array = {"a", "b", "", "c", "aa.bb", "aa", "c", "d", "c", "b"};
        HashMap<String, Integer> elementCountMap = new HashMap<>();

        for (String element : array) {
            if (element.isEmpty()) {
                continue; // Skip empty strings
            }
            // Split elements by dot and count each part separately
            String[] parts = element.split("\\.");
            for (String part : parts) {
                if (elementCountMap.containsKey(part)) {
                    elementCountMap.put(part, elementCountMap.get(part) + 1);
                } else {
                    elementCountMap.put(part, 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : elementCountMap.entrySet()) 
        {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }


}

