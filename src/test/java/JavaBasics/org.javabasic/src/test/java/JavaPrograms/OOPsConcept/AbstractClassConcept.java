package OOPsConcept;

public class AbstractClassConcept extends AbstractMethod{
	void display()
	{
		System.out.println("Abstract method implemented successfully");
	}
	
	public static void main(String args[])  
	{  
	//creating object of abstract class  
		AbstractMethod obj = new AbstractClassConcept();  
	//invoking abstract method  
		obj.display();
	} 

}
