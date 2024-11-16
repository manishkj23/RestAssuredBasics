package BasicsProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetLengthOfEachStringInAnArrayUsingHashMap {

	public static void main(String[] args) {

		String[] arr = {"apple","grapes","kiwi","pineapple"};
	    List<String> str = Arrays.asList(arr);
	    HashMap<String,Integer> map = new HashMap<>();

	    for ( String s : str)
	    {
	        int len = s.length();
	        map.put(s,len);
	    }
	 
	    for (Map.Entry<String,Integer> entry : map.entrySet())
	    {
	        System.out.println(entry.getKey()+ ":" + entry.getValue());
	    }
	    
	    
	}

}
