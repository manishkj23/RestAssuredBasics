package BasicsProgramming;

public class FindDigitsInArray {

	public static void main(String[] args) 
	{


		Object[] array = {'A', 12, 'C', 2, 1, 'W', 'V', 12};

		System.out.println("Digits in an array:");
		for (Object element : array) {
			if (element instanceof Integer) {
				System.out.println(element);
			}
		}

		System.out.println("Characters in an array:");
		for (Object element1 : array) {
			if (element1 instanceof Character) {
				System.out.println(element1);
			}
		}

		String s1="New";
		s1.concat("Delhi");
		System.out.println("Final Output is : " + s1);

		System.out.println("****************New Program***********");

		String str = "welcome to india";
		int countA =0, countE =0, countI =0, countO =0, countU =0;

		for ( int i=0; i<str.length();i++)
		{
			char c = str.charAt(i);    

			switch(c) {

			case 'a': 
				countA++;
				break;

			case 'e':
				countE++;
				break;

			case 'i':
				countI++;
				break;

			case 'o':
				countO++;
				break;

			case 'u':
				countU++;
				break;
			default:

				//            char c = str.charAt(i);
				//            if(c == 'a' || c == 'e' || c == 'i' ||c == 'o' ||c == 'u')
				//            {
				//                count ++;
				//            }
			}

		}
		System.out.println("Total count a:" + ":" + countA );
        System.out.println("Total count e:" + ":" + countE );
        System.out.println("Total count i:" + ":" + countI );
        System.out.println("Total count o:" + ":" + countO );
        System.out.println("Total count u:" + ":" + countU );
	}

}