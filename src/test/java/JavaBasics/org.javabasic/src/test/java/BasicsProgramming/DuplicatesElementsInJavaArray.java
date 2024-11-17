package BasicsProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DuplicatesElementsInJavaArray {

	public static void main(String[] args) {
		//Method:1  --- > Compare each elements : O(nxn) : worst solution
		
		String names[] = {"Java", "JavaScripts", "Python", "Ruby", "C", "Java","Ruby"};
		for ( int i=0; i<names.length; i++)
		{
			for ( int j=i+1; j<names.length; j++)
			{
				
				if(names[i].equals(names[j]))
					{
					System.out.println("Duplicate name is :" + names[i]);
					}
			}
		}


	
		System.out.println("***********************************");

		//Method:2 -- > Using HashSet : Java Collections as it stores only unique values: O(n)

		Set<String> store = new HashSet<String>();
		for ( String name : names)
		{
			if(store.add(name) == false)
				System.out.println("Dup values are: " + name );
		}
		
		System.out.println("*********************************************************");
		
		//Method:3 -- > Using HashMap : with different approach
		
		// Create a HashMap to store the frequency of each element
        HashMap<String, Integer> nameCountMap = new HashMap<>();
        
        // Iterate through the array and update the count in the HashMap
        for (String name : names) {
            if (nameCountMap.containsKey(name)) {
                nameCountMap.put(name, nameCountMap.get(name) + 1);
            } else {
                nameCountMap.put(name, 1);
            }
        }

        // Print the duplicate elements
        System.out.println("Duplicate values are:");
        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
		
		
		System.out.println("****************Set*******************");
		
		//Method:4 -- > Using HashMap
		Map<String, Integer> storeMap = new HashMap<String, Integer>();
		for ( String name : names)
		{
			Integer count = storeMap.get(name);
			if(count == null)
			{
				storeMap.put(name, 1);
			}
			else
			{
				storeMap.put(name, ++count);
			}
		}
		//get the value from this HashMap
		Set<Entry<String, Integer>> getArrayValue = storeMap.entrySet();
		for (Entry<String, Integer> entry : getArrayValue)
		{
			if(entry.getValue()>1)
			{
				System.out.println("duplicate value are:" + entry.getKey());
			}
		}

	}
}
