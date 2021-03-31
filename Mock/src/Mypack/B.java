package Mypack;

public class B extends A{		//subclass of A
	public void access()
	{
		System.out.println("\nAccessing within the Package");
		System.out.println("(Public Accessed) b: "+b);
		System.out.println("(Protected Accessed) c: "+c);
		System.out.println("(Default Accessed): ");
		this.msg();
		System.out.println("Private Not Accessible");
//		System.out.println("(Private Accessed) a: "+a);			//compiler error
}
}