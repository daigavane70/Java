import java.util.*;

class Counter<T>{
	private T[] Array;
	
	public void set(T[] t) {
		this.Array=t;
	}
	
	public T[] get() {
		return Array;
	}
	
	public void Display() {
		for(int j=0;j<Array.length;j++) {
			System.out.println(Array[j]);
		}
	}
	
	public void isPallindrome() {								//checking for Pallindrome
		
		for(int j=0;j<Array.length;j++) {
			
			try {
			
			String s=Array[j].toString();
			
			if(s.length()==1) {
				System.out.println(Array[j]+": is Pallindrome");	//not a pallindrome condition
				continue;
			}
			
			for(int i=0;i<s.length()/2;i++) {
				
				if( s.toCharArray()[i]!=s.toCharArray()[s.length()-1-i] ) {
					System.out.println(Array[j]+": Not Pallindrome");	//not a pallindrome condition
					break;
				}
				
				if(i==s.length()/2-1)
					System.out.println(Array[j]+ ": Is Pallindrome");	//if still in program, then pallindrome
			}
			
			}
			
			catch(RuntimeException e) {
				System.out.println("Operation Cannot Be Performed on this Data Types");
			}
			
		}
	}
	
	public void  isEven() {										//checking for Even
		for(int j=0;j<Array.length;j++) {
			try {
				if((Integer.parseInt((String) Array[j]))%2==0) 								//is even Number
					System.out.println(Array[j]+" is Even");
				else
					System.out.println(Array[j]+" is Prime");	//is not even Number
			}
		
			catch(RuntimeException e){
				System.out.println("Cannot Perform the operation on this Type of Data");
			}
		}
	}
	
	public void  isPrime() {										//checking for Prime Number
		try {
			for(int j=0;j<Array.length;j++) {
				
				if((int)Array[j]==2 || (int)Array[j]==1) {
					System.out.println(Array[j]+" is Prime");
					continue;
				}
				
				for(int i=2;i<(int)Array[j]/2;i++) {
					if((int)Array[j]%i==0) {
						System.out.println(Array[j]+" is Not Prime");
					}
				}
			}
		}
		catch(RuntimeException e){
			System.out.println("Cannot Perform the operation on this Type of Data");
		}
	}
}

public class GenericClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strArray[]= {};
		Counter<String> Str_obj=new Counter<String>();
		
		Scanner sc=new Scanner(System.in);
		
		int choice=0;
		int size=0;
		
		while(choice<6) {
			System.out.println("\n1. Input List.");
			System.out.println("2. Print List");
			System.out.println("3. Check Pallindrome");
			System.out.println("4. Check Even");
			System.out.println("5. Check Prime");
			System.out.println("6. Exit");
			System.out.print("Select Operation: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:{
				System.out.println("\nEnter the No. of elements: ");
				size=sc.nextInt();
				strArray=new String[size];
				System.out.println("Enter "+size+" elements: ");
				for(int i=0;i<size;i++) 
					strArray[i]=sc.nextLine();
				Str_obj.set(strArray);
				
				break;
			}
			case 2:{
				if(size!=0) {
					for(int i=0;i<size;i++) 
						System.out.print("|"+strArray[i]);	
				}
				else
					System.out.println("No data to Display");
				break;
			}
			case 3:{
				if(size!=0) 
					Str_obj.isPallindrome();
				else
					System.out.println("No data to work Upon");
				break;
			}
			case 4:{
				if(size!=0)
					Str_obj.isEven();
				else
					System.out.println("No data to work Upon");
				break;
			}
			case 5:{
				if(size!=0)
					Str_obj.isPrime();
				else
					System.out.println("No data to work Upon");
				break;
			}
			}
		}
	}
}
