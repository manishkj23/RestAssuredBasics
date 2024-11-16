package interview;

import java.util.HashSet;
import java.util.Set;

public class GetTheFinalStringAfterRemovingDuplicateCharacter {

	public static void main(String[] args) {
		
		System.out.println("************* Using toCharArray ****************************");

		String strName = "Maanniish";
        char[] c = strName.toCharArray();
        Set<Character> sc = new HashSet<>();
        char s = ' ';
        for(int i=0;i<c.length;i++)
        {
            if(sc.add(c[i]) == false)
            {
                sc.add(c[i]);
            }
            
        }
        System.out.println(sc);
        
        
        System.out.println("************* Using charAt****************************");
        String str = "Maanniish";
        Set<Character> sc1 = new HashSet<>();
        for(int i=0;i<c.length;i++)
        {
        	char s2 = str.charAt(i);
            if(sc1.add(s2) == false)
            {
                sc1.add(s2);
            }
            
        }
        System.out.println(sc1);
	}

}