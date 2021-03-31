import java.util.*;
public class TIME {
	int hr;			//Declaring int variable for Hour
	int mn;			//Declaring int variable for Minutes
	int ss;			//Declaring int variable for Seconds
	
	void readTime()	//Method to read take the time as input from user
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter Time in Format HH MM SS - ");
		int a=scan.nextInt();	//reading Hours
		int b=scan.nextInt();	//reading Minutes
		int c=scan.nextInt();	//reading Seconds
		
		this.hr=a;				//assigning values to the class variable
		this.mn=b;				
		this.ss=c;
	}
	
	void showTime()
	{
		System.out.print("\nThe Time You Entered is: ");
		System.out.printf("%02d"+':'+"%02d"+':'+"%02d",hr,mn,ss);
	}
	
	public static void main(String args[])
	{
		TIME obj = new TIME();		//defining obj as instance of TIME class
		obj.readTime();				//calling function readTime to take input
		obj.showTime();				//calling function showTime to print the time
	}
}
