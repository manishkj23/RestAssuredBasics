package BasicsProgramming;
import java.util.HashMap;
import java.util.Map;

public class GetFirstCharacterFromEachWordAndAdd {

	public static void main(String[] args) 
	{

		String str = "Manish Kumar Jain";
	     Map<Character,Integer> map = new HashMap<>();
	       char[] ch = str.toCharArray();
	       for( Character c : ch)
	       {
	           if(c == ' ')
	           {
	               continue;
	           }
	           if(map.containsKey(c))
	           {
	               map.put(c,map.get(c)+1);
	           }
	           else
	           {
	               map.put(c,1);
	           }
	       }
	       System.out.println("Occurence of each Character :");
	       for(Map.Entry<Character,Integer> entry : map.entrySet())
	       {
	            System.out.println(entry.getKey()+ ":" + entry.getValue());
	       }
	    }

}
