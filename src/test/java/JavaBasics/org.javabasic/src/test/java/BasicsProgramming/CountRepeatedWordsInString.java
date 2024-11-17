package BasicsProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatedWordsInString {

	public static void main(String[] args) {
		String str = "Learning Java Program And Java Collections";
		Integer count = 1;
		Map<String , Integer> map = new HashMap<String , Integer>();
		String[] arr = str.split(" ");
		for(int i=0;i<arr.length;i++)
		{
			if(!map.containsKey(arr[i]))
			{
				map.put(arr[i], count);
			}
			else
			{
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		//printing the output
		for(String x:map.keySet())
		{
			System.out.println("The count of word :"+x+" = " +map.get(x));
		}
		
		
		System.out.println("----------------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }		

	}

}
