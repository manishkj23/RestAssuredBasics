package BasicsProgramming;

public class reverseString {

	public static void main(String[] args) {

		//1. Using + ( String concatenation ) operator
		String str = "ABCD";
		String rev= "";
		int len = str.length();
		for(int i=len-1;i>=0;i--)
		{
			rev = rev + str.charAt(i);
		}
		System.out.println("Reverse a String is : " +rev);
		
		//2. using character array
		
		System.out.println("***************************************");
		
		String stri = "MANISH";
		String rever= "";
		char a[] = stri.toCharArray();
		int len1 = a.length;
		System.out.println("Lenght of the string is : " + len1);
		
		for(int j=len1-1;j>=0;j--)
		{
//			rever = rever + stri.charAt(j); // or
			rever = rever + a[j];
		}
		System.out.println("Reverse a String is : " +rever);
		
		//3. Using StringBuffer class
		String string = "KUMAR"; 
		StringBuffer sb1 =  new StringBuffer(string);
		System.out.println(sb1.reverse());
		
		System.out.println("**************Reverse A String by each word******************");
		
		String str1 = "eW era snaidnI";
        String[] arr = str1.split(" ");
        StringBuilder reversedString = new StringBuilder();
        String rev1 = " ";
        for(int i = 0;i<arr.length;i++) // eW
        {
            
            for(int j=arr[i].length()-1;j>=0;j--)
            {
                rev1 = rev1 + arr[i].charAt(j);
                
            }
//            reversedString.append(rev.toString());
//            if (i < arr[i].length() - 1) {
//                reversedString.append(" ");
//            }
        }
        System.out.println(rev1);
    
	}

}