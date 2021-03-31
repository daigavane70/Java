package Mypack;

public class A {
	private int a=1;		//private
	public int b=2;			//public
	protected int c=3;		//protected
	
	void msg() {			//default
		System.out.println("HEllo");
	}
							//accessing the variables within the class
	public void access()
	{
		System.out.println("\nAccessing within the Class");
		System.out.println("(Private Accessed) a: "+a);
		System.out.println("(Public Accessed) b: "+b);
		System.out.println("(Protected Accessed) c: "+c);
		System.out.println("(Default Accessed)");
		this.msg();
	}
}