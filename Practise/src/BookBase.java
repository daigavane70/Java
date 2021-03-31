import java.util.*;

public class BookBase {
	String title;
	String publisher;
	int cost;
	
	void read()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("\nTitle: ");
		title=sc.nextLine();
		System.out.print("Publisher: ");
		publisher=sc.nextLine();
		System.out.print("Cost: ");
		cost=sc.nextInt();
	}
	
	void display()
	{
		System.out.print("\nTitle: "+title+"\nPublisher: "+publisher+"\nCost"+cost);
	}

public class TextBook extends BookBase 
{
	int n; 				//number of authors
	String authors[];	//authors list
	double edition;		//Book Edition
	int ISBN;			//ISBN number
	
	void read()			//reading Content
	{
		super.read();
		Scanner sc=new Scanner(System.in);	
		
		System.out.print("No. of Authors: ");
		n=sc.nextInt();							//reading number of authors
		authors=new String[n];					
		System.out.println("Enter Authors Name");
		
		for(int i=0;i<n;i++)					//reading all the authors name
		{
			System.out.print(i+". ");
			authors[i]=sc.nextLine();
		}
		
		System.out.print("Edition: ");			//reading the Edition
		edition=sc.nextDouble();
		
		System.out.print("ISBN: ");				//reading the ISBN number
		ISBN=sc.nextInt();
	}
	
	void display()			//display Function
	{
		super.display();	//displaying the contents of Base Class
		System.out.print("Authors: ");	//display authors name
		for(int i=0;i<n;i++)	System.out.print(authors[i]+"|");
		System.out.print("\nEdition: "+edition);	//display Edition
		System.out.println("\nISBN: "+ISBN);		//display ISBN
	}
	
	void issue()
	{
		System.out.println("Issue Date: "+java.time.LocalDate.now());
		System.out.println("Return Date: "+java.time.LocalDate.now().plusDays(8));
	}
}

public class Journal extends BookBase
{
	int dd,mm,yy;
	int DOI;
	String date;
	int ISSN;
	
	void read()										//Read Method
	{
		super.read();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Date(dd mm yy): ");
		dd=sc.nextInt();							//Day
		mm=sc.nextInt();							//Month
		yy=sc.nextInt();							//Year
		
		System.out.print("DOI: ");					//reading DOI
		DOI=sc.nextInt();
		
		System.out.println("ISSN: ");				//Reading ISSN
		ISSN=sc.nextInt();
	}
	
	void display()									//Display Method
	{
		super.display();			//calling display Function of Base Class
		System.out.print("\nDOI: "+DOI);
		System.out.print("\nISSN: "+ISSN);
		System.out.print("\nDate: "+dd+"/"+mm+"/"+yy);
	}
	
	void issue()									//Issue Method
	{
		System.out.println("Issue Date: "+java.time.LocalDate.now());				//Current Date
		System.out.println("Return Date: "+java.time.LocalDate.now().plusDays(4));	//Return Date
	}
}

public class Magazine extends BookBase
{
	String type;
	
	void read()
	{
		super.read();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Type: ");
		type=sc.nextLine();
	}
	
	void display()
	{
		super.display();
		
		System.out.println("Type: "+type);
	}
	
	void issue()
	{
		System.out.println("Issue Date: "+java.time.LocalDate.now());
		System.out.println("Return Date: "+java.time.LocalDate.now().plusDays(2));
	}
}

	public void main(String args[])
	{
		TextBook tb=new TextBook();
		
		tb.read();
		tb.display();
	}

}