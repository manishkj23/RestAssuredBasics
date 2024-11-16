package OOPsConcept;

public class BankAccountExample {

	public static void main(String[] args) {
		BankAccount ba1 = new BankAccount();
		
		ba1.insert(007, "Manish", 10000);
		ba1.deposit(100);
		ba1.withdraw(100);
		ba1.checkBalance();
		ba1.display();	

	}

}
