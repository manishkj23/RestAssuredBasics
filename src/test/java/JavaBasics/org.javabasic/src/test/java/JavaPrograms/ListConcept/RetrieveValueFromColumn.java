package ListConcept;

import java.util.ArrayList;
import java.util.List;

public class RetrieveValueFromColumn {

	public static void main(String[] args) {
		
		// Create a list of Person objects
        List<Person> people = new ArrayList<>();

        // Add data to the list
        people.add(new Person("Rahul", 30, "Dubai"));
        people.add(new Person("Rohit", 25, "India"));
        people.add(new Person("Vivek", 40, "Nepal"));

        // Print the data in a tabular format
        System.out.println("Name\t\tAge\tLocation");
        System.out.println("----------------------------");
        for (Person person : people) {
            System.out.println(person);
        }

        // Retrieve and print values from the first column (names)
        System.out.println("\nNames from the first column:");
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

}
	
	class Person {
	    // Attributes
	    private String name;
	    private int age;
	    private String location;

	    // Constructor
	    public Person(String name, int age, String location) {
	        this.name = name;
	        this.age = age;
	        this.location = location;
	    }

	    // Getter for name
	    public String getName() {
	        return name;
	    }

	    // Override toString() to display the person data in a readable format
	    @Override
	    public String toString() {
	        return name + "\t\t" + age + "\t" + location;
	    }

	    
	    /*
	     Explanation:
Person Class:

Stores the name, age, and location of a person.
Provides a constructor to initialize these values.
Implements a toString() method to display the information in a tabular format.
List of Person Objects:

A List of Person objects is created using ArrayList.
We add data (persons) to the list using the add() method.
Print Data in a Tabular Format:

The toString() method of the Person class is called when printing the Person objects in a loop, displaying the data in tabular format.
Retrieve Names:

We iterate through the list and use the getName() method to retrieve the names from the first column.
	     */
	    
	    
}
