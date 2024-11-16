package BasicsProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class CompareTwoArrayListAndPrintDifferentValue {

	public static void main(String[] args) {
		
		System.out.println("**************Common Value***********");

		String arr1[]= {"java","interview","questions","for","experienced"};
		String arr2[]= {"java","fresher","interview","questions"};
		Set<String> res = new HashSet<>();
		
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i] == arr2[j])
					res.add(arr1[i]);
			}
		}
		for(String s : res)
			System.out.println("Common Values are: " + s);
		
		
		System.out.println("**************Common Value using Stream ***********");
		
		String[] a = {"java","python","hibernate", "spring"};
		String[] b= {"core","java","spring","microservices"};

		List<String> a1 = Arrays.asList(a);
		List<String> b1 = Arrays.asList(b);
		List<String> collect = a1.stream().filter(b1::contains).collect(Collectors.toList());
		System.out.println(collect);
		
		
//		String[] s1 = {"java","python","aws"};
//		String[] s2 = {"java","perl","aws"};
//		Arrays.stream(s2).filter(Arrays.asList(s1)::contains)
//			  .forEach(str -> System.out.print(str + "  "));
		
		
		System.out.println("**************Union & Intersection***********");
		
		String ar[]= {"java","interview","questions","for","experienced"};
		String ar1[]= {"java","fresher","interview","questions"};
		Set<String> set=new HashSet<>();

		for(int i=0;i<ar.length;i++) {
			set.add(ar[i]);
		}

		System.out.println("Array Intersection is: ");
		for(int i=0;i<ar1.length;i++) 
		{
			if(set.contains(ar1[i]))
			{
				System.out.print(ar1[i]+" "); // will give you Intersection means the common value
			}
			else
			{
				set.add(arr2[i]);
			}
		}

		System.out.println("\nArray Union is: "+set);

	}

}
