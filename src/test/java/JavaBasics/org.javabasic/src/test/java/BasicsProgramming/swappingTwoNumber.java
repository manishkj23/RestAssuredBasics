package BasicsProgramming;

public class swappingTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a= 10; int b = 20;
//		System.out.println("Before swapping value : " +a+"  "+b);
////		Logic-1 : using third variable
//		int c;
//		c=a;
//		a=b;
//		b=c;
//		System.out.println("After swapping value : " +a+"  "+b);		
//		System.out.println("**************************************");
		
////		Logic-2 : using + & - without using third variable
//		a=a+b; //10+20 = 30
//		b=a-b; // 30-20 = 10
//		a=a-b; //30-10
//		System.out.println("swapping value with + & - and without using third variable: " +a+"  "+b);
//		System.out.println("**************************************");
//		
//		Logic-3 : using * & / without using third variable
//		//here a & b should not be zero
//		a=a*b; //10*20 = 200
//		b=a/b; //200/20 = 10
//		a=a/b;
//		System.out.println("swapping value with * & / and without using third variable: " +a+"  "+b);
//		
//		Logic-4 : using single statement
		b=a+b-(a=b);
		System.out.println("swapping value with single statement and without using third variable: " +a+"  "+b);
	}

}
