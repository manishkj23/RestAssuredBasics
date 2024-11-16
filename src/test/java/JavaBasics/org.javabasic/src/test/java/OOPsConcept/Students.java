package OOPsConcept;

public class Students {
	
	//Object and Class Example: Initialization through method
	//In this example, we are creating the two objects of Student class and initializing the value to 
	//these objects by invoking the insertRecord method.Here, we are displaying the state (data) of 
	//the objects by invoking the displayInformation() method. from TestStudent class.

		int rollno;  
		String name;
		
		void insertRecord(int r, String n)
		{  
			  rollno=r;  
			  name=n;  
		}  
		
		void displayInformation()
		{
			System.out.println("Student roll and name is : " +rollno+" "+name);
		} 

}
