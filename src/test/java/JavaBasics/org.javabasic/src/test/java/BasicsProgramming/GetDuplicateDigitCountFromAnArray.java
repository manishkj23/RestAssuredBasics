package BasicsProgramming;
import java.util.HashMap;
import java.util.Map;

public class GetDuplicateDigitCountFromAnArray {

	public static void main(String[] args) {

		int[] nums = {1, 2, 3, 4, 3, 5, 6, 7, 8, 7, 9, 8,10};
	    
	   HashMap<Integer,Integer> map = new HashMap<>();

	   for ( int arr : nums)
	   {
	        if(map.containsKey(arr))
	       {
	           map.put(arr,map.get(arr)+1);
	        }
	       else
	        {
	            map.put(arr,1);
	       }
	   }

	    for(Map.Entry<Integer,Integer> entry : map.entrySet())
	    {
	       System.out.println(entry.getKey()+":" + entry.getValue());
	       if(entry.getValue() > 1)
	       {
	        System.out.println("Duplicate values are : " + entry.getKey());
	       }
	    }
    }
	    

}
