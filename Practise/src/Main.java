import java.util.*;
import java.io.*;

class Template<T>{
	T[] val;
	
	public T[] getVal() {
		return val;
	}
	public void setVal(T[] val) {
		this.val = val;
	}
	boolean isPalindrome(T[] x) {
		int i=0,j=x.length()-1;
		while(i<j) {
			if(x.charAt(i)!=x.charAt(j)) {
				System.out.println(x+" is not Pallindrome");
			}
			i++;
			j--;
		}
		System.out.println(x+ " is Pallindrome");
	}
	
	void isEven(int x) {
		if(x%2==0) {
			System.out.println("EVEN");
		}
		else {
			System.out.println("ODD");
		}
	}
	
	void isPrime(int x) {
		int a=1;
		for(int i=2;i<(x/2)+1;i++) {
			if(x%i==0) {
				
				a=0;
				break;
			}
			}
		if(a==0) {  
			System.out.println("Non prime");
		}
		else {
			System.out.println("prime");
		}
		
		}
}
public class Generic_name {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Template<Integer> I=new Template<Integer>();
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		
		I.isEven(x);
		I.isPrime(x);
		
		Template<String> S=new Template<String>();
		String p=sc.next();
		if(S.isPalindrome(p)){
			System.out.println("PALINDROME");
		}
		else {
			System.out.println("NON PALINDROME");
		}
	}

}