package Mypack1;
import Mypack.A;
import Mypack.B;

public class Mocktest1_9 extends A {

	public static void main(String[] args) {
		A objA=new A();
		objA.access();
		
		B objB=new B();
		objB.access();
		
		Mocktest1_9 obj=new Mocktest1_9();
		
		System.out.println("\nAccessing Outside the Package the Class");

		System.out.println("(Protected Not Accessed) c: "+obj.c);
		System.out.println("(Private Not Accessible)");
//		System.out.println("(Private Not Accessed) a: "+objA.a);	//compiler time error
		System.out.println("(Public Accessed) b: "+objA.b);
		System.out.println("(Default Not Accessible)");
//		obj.msg();													//compile time error
	}
}
