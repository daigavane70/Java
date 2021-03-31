import java.util.Scanner;

abstract class Shape{
	double val1;	//first value
	double val2;	//second value
	
	//setter methods
	void setval1(double val) {
		this.val1=val;
	}
	void setval2(double val) {
		this.val2=val;
	}
	//getter methods
	double getval1() {
		return this.val1;
	}
	double getval2() {
		return this.val2;
	}
	
	abstract void computeArea();					//defining an abstract function to Compute area
	
	public void input()								//reading the values of Two Double values
	{
		double val;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter First Value: ");
		val=sc.nextDouble();
		setval1(val);
		
		System.out.print("Enter Second Value: ");
		val=sc.nextDouble();
		setval2(val);
	}
}

class Triangle extends Shape{
	
}

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
