import java.util.*;
public class ConstEx {
	public int n;
	public ConstEx(int a)
	{
		a=n;
	}
	
	public void setVal()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Start Entering the Students Roll Numbers: ");
		for(int i=0;i<n;i++)
		{
			System.out.printf("Student %d: ",i+1).println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
