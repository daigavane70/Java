import java.util.*;

abstract class Shape {
	
	double val1;	//first value
	double val2;	//second value
	
	abstract void computeArea();					//defining an abstract function to Compute area
	abstract void input();								//reading the values of Two Double values
}

class Triangle extends Shape{
	
	Triangle(){
		System.out.println("Inside Triangle");
	}
	
	void computeArea() {
		double area=val1*val2/2.0;
		
		System.out.println("Area of Triangle is: "+area);
	}
	
	public void input()								//reading the values of Two Double values
	{
		double val;
		Scanner sc=new Scanner(System.in);
		
		while(true) {								
			try {									//validation of NumberFormat
				System.out.println("Enter First Value: ");
				val=sc.nextDouble();
				this.val1=val;
				break;
			}	
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
		
		while(true) {
			try {									//validation of NumberFormat
				System.out.print("Enter Second Value: ");
				val=sc.nextDouble();
				this.val2=val;
				break;
			}	
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
	}
		
}

class Rectangle extends Shape{
	
	Rectangle(){
		System.out.println("Inside Rectangle");
	}
	
	void computeArea() {
		double area=val1*val2;
		System.out.println("Area of Rectangle is: "+area);
	}
	
	public void input()								//reading the values of Two Double values
	{
		double val;
		Scanner sc=new Scanner(System.in);
		
		while(true) {								
			try {									//validation of NumberFormat
				System.out.println("Enter First Value: ");
				val=sc.nextDouble();
				this.val1=val;
				break;
			}	
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
		
		while(true) {
			try {									//validation of NumberFormat
				System.out.print("Enter Second Value: ");
				val=sc.nextDouble();
				this.val2=val;
				break;
			}	
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
	}
}
	
public class Assignment_4{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape obj;
		
		obj=new Triangle();
		
		obj.input();
		obj.computeArea();

		obj=new Rectangle();
		
		obj.input();
		obj.computeArea();
		
	}
}