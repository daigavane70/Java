import java.util.*;

public class Complex {
	
	// A=(real)+(img)i
	
	float real,img;	//declaring real parts of 2 Complex Numbers
	
	Complex(){};
	
	Complex(float r,float i)	//constructor to assign values of two complex Numbers
	{
		real=r;
		img=i;
	}
	
	void display(Complex result)	//display function
	{
		if(result.img<0) System.out.printf("Result: %.2f%.2fi",result.real,result.img);
		else System.out.printf("Result: %.2f+%.2fi",result.real,result.img);
	}
	
	Complex add(Complex result)		//addtion function
	{
		result=new Complex(real+result.real,img+result.img);
		return result;
	}
	
	Complex subtract(Complex result)	//subtract function
	{
		result=new Complex(real-result.real,img-result.img);
		return result;
	}
	
	Complex multiplication(Complex result)		//multiplication function
	{
		result=new Complex((real*result.real)-(img*result.img),(img*result.real)+(real*result.img));
		return result;
	}
	
	Complex divide(Complex result)		//divide function
	{
		Complex mul=multiplication(result.conjugate(result));	//calculating the numerator
		
		result.real*=result.real;
		result.img*=result.img;
		
		float divisor=result.real+result.img;		//calculating divisor
		
		result=new Complex(mul.real/(divisor),mul.img/(divisor));	//setting the resultant real and imaginary value
		
		return result;
	}	
	
	Complex conjugate(Complex obj)		//Function to Calculate the COnjugate of Complex Number
	{
		Complex Conj=new Complex(obj.real,-obj.img);
		return Conj;
	}
	
	int validDivision(Complex obj)	//checking divisor is zero or not
	{
		if(obj.real==0 && obj.img==0)	return 0;
		else return 1;
	}
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);	//defining a Scanner sc
		float real,img;
		
		System.out.println("Enter the 1st Complex Number: ");
		System.out.println("A=a+bi");
		System.out.println("a b: ");
		real=sc.nextFloat();		//reading real value of 1st Number
		img=sc.nextFloat();			//reading imaginary value of 1st Number
		Complex obj=new Complex(real,img);			//creating 'obj' object of class Complex
		
		//printing the complex numbers User has entered
		System.out.printf("\nA=%.2f+%.2fi",real,img).println();
		
		System.out.println("Enter the 2nd Complex Number: ");
		System.out.println("B=c+di");
		System.out.println("c d: ");
		real=sc.nextFloat();		//reading real value of 2nd Number
		img=sc.nextFloat();			//reading imaginary value of 2nd Number
		Complex obj2=new Complex(real,img);
		
		//printing the complex numbers User has entered
		System.out.printf("\nB=%.2f+%.2fi",real,img).println();
		
		int choice=0;
		
		while(choice!=5)	//menu driven loop to perform several operations
		{
		System.out.println("\n****************************************");
		System.out.println("\n__Menu__\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
		System.out.printf("\n****************************************\nEnter Your Choice: ");
		choice=sc.nextInt();
		
		
		if(choice==1)	//performing Addition
			{
			Complex result=obj.add(obj2);	//calling add Function
			obj.display(result);
			}
		
		else if(choice==2)	//Subtraction
			{
			Complex result=obj.subtract(obj2);	//calling subtract Function
			obj.display(result);
			}
		
		else if(choice==3)	//multiply
			{
			Complex result=obj.multiplication(obj2);	//calling multiply Function
			obj.display(result);
			}
		
		else if(choice==4)	//divide
			{
			
			if(obj2.validDivision(obj2)==1)		//checking the divisor
			{
			Complex result=obj.divide(obj2);	//calling divide function
			obj.display(result);
			}
			
			else	System.out.println("Division By Zero Error");	//division not possible
			
			}
		else
			{
				break;
			}
		}
		
		sc.close();
	}
	
	
/*
Enter the 1st Complex Number: 
A=a+bi
a b: 
1 1

A=1.00+1.00i
Enter the 2nd Complex Number: 
B=c+di
c d: 
1 -1

B=1.00+-1.00i

****************************************

__Menu__
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit

****************************************
Enter Your Choice: 1
Result: 2.00+0.00i
****************************************

__Menu__
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit

****************************************
Enter Your Choice: 2
Result: 0.00+2.00i
****************************************

__Menu__
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit

****************************************
Enter Your Choice: 3
Result: 2.00+0.00i
****************************************

__Menu__
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit

****************************************
Enter Your Choice: 4
Result: 0.00+1.00i
****************************************

__Menu__
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit

****************************************
Enter Your Choice: 5

 */
}