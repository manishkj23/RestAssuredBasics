package StreamsConcept;

import java.util.ArrayList;

public class StreamFilterConcept {

	public static void main(String[] args) {
	
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Adam");
		arr.add("Germany");
		arr.add("Andaman");
		arr.add("Scotland");
		arr.add("France");
		
		Long c = arr.stream().filter(s->s.startsWith("A")).count();
		System.out.println("Total count of city starts with A is: " + c);

	}

}
