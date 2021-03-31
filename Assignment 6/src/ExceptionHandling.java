import java.util.*;

interface print{
	public void display(int[] array);
}

class Division implements print {
	public void display(int[] array) {
		//ArithmaticException
		System.out.println("---Performing Division---");
		try {
			int result=array[0]/array[1];	//calculating result
			
			System.out.println(array[0]+"/" +array[1]+"= " +result);
		}
		catch(ArithmeticException err){
			System.out.println(err);
		}
	}
}

public class ExceptionHandling {
	public static void main(String args[])
	{
		int[] array=new int[2];
		
		Scanner sc=new Scanner(System.in);
		
		String s;
		
		//Number Format Checking
		while(true) {
			System.out.print("First Number: ");
			try {
				s=sc.nextLine();
				array[0]=Integer.parseInt(s);
				break;
				
			}
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
		
		//Number Format Checking
		while(true)
		{
			System.out.print("Second Number: ");
			try {
				s=sc.nextLine();
				array[1]=Integer.parseInt(s);
				break;
			}
			catch(NumberFormatException err) {
				System.out.println(err);
			}
		}
		
		//Array index out of bound
		for(int i=0;i<3;i++)
		{
			try {
				System.out.println("Index "+i+": "+array[i]+' ');
			}
			catch(ArrayIndexOutOfBoundsException err) {
				System.out.println(err);
			}
		}
		
		Division obj=new Division();
		obj.display(array);
	}
}
