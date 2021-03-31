import java.util.*;

public class Base {
	
	void display()
	{
		System.out.println("Hello This is the Base Class");
	}
	
	public class Derived extends Base{
		void display()
		{
			System.out.println("Hello This is the Derived Class");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Base obj1=new Base();
		obj1.display();
	}
}
