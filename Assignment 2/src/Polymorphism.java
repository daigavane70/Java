import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

class Publication{
	String title;
	int price;
	int copies;
	
	public void settitle(String tle) {
		title=tle;
	}
	
	public String gettitle() {
		return this.title;
	}
	
	public void setprice(int prc) {
		price=prc;
	}
	
	public int getprice() {
		return this.price;
	}
	
	public void setcopies(int cpy) {
		copies=cpy;
	}
	
	public int getcopies() {
		return this.copies;
	}
	
	public void read()			//read Method for 
	{
		System.out.println("<----Publication---->");
		Scanner s= new Scanner(System.in);
		System.out.print("\nTitle: ");
		settitle(s.nextLine());
		System.out.print("Price: ");
		setprice(s.nextInt());
		System.out.print("Copies: ");
		setcopies(s.nextInt());
	}
	public void display()
	{
	    System.out.println("------------------------------------------------");
		System.out.println("Title \t\t Price \t\t Copies \t\t");
	    System.out.println(title + "\t\t" + price + "\t\t" + copies + "\t\t");
	    System.out.println("------------------------------------------------");
	}
	
	public void sellcopy(int qty)
	{
		if(qty<=copies)			//available
			System.out.println("Successfully Sold, Total cost: "+(qty*this.price));
		else					//unavailable
			System.out.println("Sorry Only "+copies+" Available");
	}
}

class Book extends Publication{
	String[] authors;		//authors list
	int n;					//number of authors
	public void read()
	{
		System.out.println("<----Book---->");
		
		Scanner sc=new Scanner(System.in);
		
		super.read();
			
		System.out.print("Enter No of authors: ");	//getting Number of authors
		n=sc.nextInt();
		authors=new String[n];							//initializing string of size n
			
		authors[0]=sc.nextLine();		//skipping '\n'
		for(int i=0;i<n;i++)
		{
			System.out.print("Author "+(i+1)+": ");		//getting authors name
			authors[i]=sc.nextLine();
		}
	}
		
	public void display()
	{
		super.display();	
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Author "+(i+1)+": "+authors[i]);
		}
	}
		
	public void sellcopy(int qty)
	{
		if(copies>=qty)					//sufficient Copies available
			System.out.println("Copies sold successfully, Amount Paid: "+(qty*getprice())+"\n");
		else							//sufficient Copies not avalable
			System.out.println("Sorry Only "+copies+" Available");
	}
}

class Magazine extends Publication
{
	int orderQty;
	String currissue;
	
	public void read()
	{
		System.out.println("<----Magazine---->");
		super.read();					//reading details
	}
		
	public void display()
	{
		super.display();
		System.out.println("Current Issued: "+currissue);
	}
		
	public void recvNewIssue(String s)
	{
		setcopies(orderQty);		//Filling the copies Again by the number of Sold Copies
		currissue=s;				
	}
		
	public void sellcopy(int qty)
	{
		orderQty=qty;
		if(copies>=qty)			//sufficient copies available
			System.out.println("Copies Sold Successfully, Amount Paid: "+(qty*getprice())+"\n");
		else					//insufficient copies
			System.out.println("Sorry only "+copies +" Are available");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int n;	//no of copies to buy
		
		Publication pb=new Publication();		//creating object of publication
		pb.read();				
		pb.display();			
		System.out.println("Enter the Amount of Copies yout want to Buy: ");
		n=sc.nextInt();				//reading no. of copies to issue
		pb.sellcopy(n);
		
		Book bk=new Book();					//creating object of Book
		bk.read();
		bk.display();
		System.out.print("Enter the Amount of Copies yout want to Buy: ");
		n=sc.nextInt();				//reading no. of copies to issue
		pb.sellcopy(n);
		
		Magazine mgz=new Magazine();			//creating object of Magazine
		mgz.read();
		mgz.display();
		mgz.recvNewIssue("Science Report");
		System.out.print("Enter the Amount of Copies yout want to Buy: ");
		n=sc.nextInt();				//reading no. of copies to issue
		pb.sellcopy(n);
	}
}
