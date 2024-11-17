package ListConcept;

public class Students implements Comparable<Students> {
	
	private int rollNumber;
    private String name;
    private int age;  
	
    // Constructor
    public Students(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }
    
 // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
 // Implement compareTo method to sort by rollNumber (default sorting)
    @Override
    public int compareTo(Students other) {
        return Integer.compare(this.rollNumber, other.rollNumber);
    }
    
    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", name=" + name + ", age=" + age + "]";
    }
	
	

}
