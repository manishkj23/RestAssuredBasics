package interview;

public class RevString {

	public static void main(String[] args) {
		String str = "java selenium tutorial";
		String arr[] = str.split(" ");
		for (int i=0;i<arr.length;i++)
		{
			String rev="";
			String ele = arr[i]; // java

			for(int j=ele.length()-1;j>=0;j--)
			{
				rev=rev+ele.charAt(j);
			}
			System.out.print(rev + " ");		
		}

		System.out.println("\n************ Another Approach*************");
	// Online Java Compiler
	// Use this editor to write, compile and run your Java code online

	        String str1 = "malayalam";
	        int count = 0;
	        for ( int i=0;i<str.length();i++)
	        {
	            char c = str.charAt(i);
	            if(c == 'a')
	            {
	                count++;
	            }  
	        } 
	        System.out.println("Total count of a: " + count);
}
}