package ListConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student1 {


	public static void main(String[] args) {
		
		// Create a list of Student objects
        List<Students> students = new ArrayList<>();
        students.add(new Students(10, "Ajay", 11));
        students.add(new Students(12, "Vijay", 10));
        students.add(new Students(11, "Babita", 12));

        // Sort using the default sorting by rollNumber (Comparable)
        Collections.sort(students);

        // Print sorted students
        for (Students student : students) {
            System.out.println(student);
        }

System.out.println("************ Using Stream************");
        //Approach -2 
        List<Object[]> list = Arrays.asList(
                new Object[]{10, "Ajay", 11},
                new Object[]{12, "Vijay", 10},
                new Object[]{11, "Babita", 12}
            );

            // Sort the list based on the first element of the arrays
            List<Object[]> sortedList = list.stream()
                .sorted(Comparator.comparingInt(arr -> (int) arr[0]))
                .collect(Collectors.toList());

            // Print the sorted list
            sortedList.forEach(arr -> System.out.println(Arrays.toString(arr)));
			
	
	}
	
}  