package BasicsProgramming;

import java.util.HashMap;
import java.util.Map;

public class ReplaceValueInHashMap {

	public static void main(String[] args) {


		// Create a HashMap and populate it with initial values
        Map<String, String> map = new HashMap<>();
        map.put("ONE", "AAA");
        map.put("TWO", "BBB");
        map.put("THREE", "CCC");
        map.put("FOUR", "DDD");

        // Print the original HashMap
        System.out.println("Original HashMap: " + map);

        // Replace the value "DDD" with "444"
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("DDD")) {
                map.put(entry.getKey(), "444");
            }
        }
        
        for(Map.Entry<String,String> st : map.entrySet())
        {
            System.out.println( st.getKey() + st.getValue());
        }

        // Print the updated HashMap
//        System.out.println("Updated HashMap: " + map);
        
	}

}
