import java.util.*;

public class strings {
	String TEMP="12";
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String s=new String("ABC");
		String a="12";
		String b="12";
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));

		System.out.println("Issue Date: "+java.time.LocalDate.now());
		System.out.println("Return Date: "+java.time.LocalDate.now().plusDays(2));
	
	}

}
