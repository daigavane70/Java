import java.util.*;

public class Book {
	
	int no;			//Number of Authors	
	String[] author;	//Authors
	String title;	//title of book
	int ISBN;		//ISBN
	int cost;		//cost of Book
	int total;		//total Published
	int issued;		//total Issued Books
	
	void getdetails()		//Function to get Details
	{
		Scanner sc=new Scanner(System.in);	
		
		System.out.print("Title: ");
		title=sc.nextLine();
		
		System.out.print("Enter Number Of authors: ");
		no=sc.nextInt();
		
		author=new String[no];
		sc.nextLine();
		for(int i=0;i<no;i++)
		{
			System.out.print("Author "+(i+1)+": ");
			author[i]=sc.nextLine();
		}
		
		System.out.print("ISBN: ");
		ISBN=sc.nextInt();
		
		System.out.print("Cost: ");
		cost=sc.nextInt();
		
		System.out.print("Total compies Published: ");
		total=sc.nextInt();
		
		issued=0;
	}
	
	int search(Book obj[],int n,String s)	//search method
	{
		for(int i=0;i<n;i++)	//searching the list
		{
			if(obj[i].title.contentEquals(s))	//comparing the title
			{
				return i;	//returning index
			}
		}
		return -1;			//not Found
	}
	
	void details()	//printing the detail of One Book
	{
		System.out.print("-------------------------------------------------------");
		System.out.println("\n|Name\t|Cost\t|Total\t|Issued\t|ISBN");
		System.out.print("-------------------------------------------------------");
		System.out.print("\n|"+title);
		System.out.print("\t|"+ISBN);
		System.out.print("\t|"+cost);
		System.out.print("\t|"+total);
		System.out.print("\t|"+issued);
		System.out.print("\t|");
		for(int i=0;i<no;i++)
		{
			System.out.print(author[i]+",");
		}
		System.out.println("\n-------------------------------------------------------");
	}
	
	void all_details(Book obj[],int n)	//Printing the details of the Books
	{
		System.out.print("-------------------------------------------------------");
		System.out.println("\n|No.\t|Name\t|ISBN\t|Cost\t|Total\t|Issued\t|author");
		System.out.print("-------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			System.out.print("\n|"+(i+1));
			System.out.print("\t|"+obj[i].title);
			System.out.print("\t|"+obj[i].ISBN);
			System.out.print("\t|"+obj[i].cost);
			System.out.print("\t|"+obj[i].total);
			System.out.print("\t|"+obj[i].issued);
			System.out.print("\t|");
			for(int j=0;j<no;j++)
			{
				System.out.print(obj[i].author[j]+",");
			}
		}
		System.out.println("\n-------------------------------------------------------");
	}
	
	int available()		//checking available copies
	{
		return total-issued;
	}
	
	int issue(int k)
	{
		if(this.available()>=1)
		{
			issued+=k;	//incrementing the number of issued books
			return 1;
		}
		return 0;		//book not available
	}
	
	void returnBook()	//returning the Book
	{
		if(issued>0) issued--;		//decrementing the number of issued books
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int n=0;						//total books
		
		Book[] obj=new Book[0];			//creating array of objects
		
//		Book p,q;
		
		int choice=0;					//users choice
		
		while(choice<=6)				//menu driven loop
		{								//printing the menu
			System.out.println("<===========Menu===========>");
			System.out.println("1. Enter Books Details");
			System.out.println("2. Search Book");
			System.out.println("3. Check Availability");
			System.out.println("4. Return Book");
			System.out.println("5. Issue a Book");
			System.out.println("6. Display All Book Details");
			System.out.println("7. Exit");
			System.out.println("============================");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter Total Number of Books: ");
				n=sc.nextInt();					//reading total numbers of Books
				
				obj=new Book[n];				//creating and array of object
				
				for(int i=0;i<n;i++)			//loop to take the input of list
				{
					obj[i]=new Book();			//creating the a new object
					System.out.println("Book "+(i+1));
					obj[i].getdetails();		//reading the details of the book
					System.out.println("");
				}
				break;
			}
			
			case 2:	//Search a Book By Title
			{
				if(n>0)	//list is not empty
				{
				String s;						//title
				System.out.print("Enter the Book Title to Search: ");
				s=sc.next();					//reading the title to search
				int k=obj[0].search(obj,n,s);	//calling search()
				if(k+1>0)
				{
					System.out.println("Found");	//book found
					obj[k].details();			//printing the book details
				}
				else
				{								//book not found
					System.out.println("Not Found");
				}
					break;
				}
			}
			case 3:	//Check Availability
			{
				if(n>0)	//list is not Empty
				{
					String s;						//title
					System.out.print("Title: ");
					s=sc.next();					//reading the title to search
					int k=obj[0].search(obj, n, s);	//calling search Function
					if(k+1>0)						
					{								//printing total available Copies
						System.out.println(obj[k].available()+" Available Copies");
					}
				}
				
				else	//list is empty
				{
					System.out.println("List is Empty");
				}
				
				break;
			}
			case 4:	//return Book
			{
				if(n>0)	//list is not empty
				{
				obj[0].all_details(obj, n);		//print the list
				int k;							//Serial Number
				System.out.print("\nEnter the Serial Number to return that book: ");
				k=sc.nextInt();					//Scanning the Serial Number
				
				if(obj[k-1].available()<obj[k-1].total) //checking if returnable
				{
					obj[k-1].returnBook();		//returning the book
				}
				}
				else 	//list is empty
				{
					System.out.println("List is Empty");
				}
				
				break;
			}
			case 5:	//issue a book
			{
				if(n>0)	//list is not empty
				{
					obj[0].all_details(obj, n);				//Printing the list of books
					int k,copies;							//Store the serial number of book
		
					System.out.print("\nEnter the ISBN Number to issue that book: ");
					k=sc.nextInt();							//Scanning the ISBN number
					
					for(int i=0;i<n;i++)					//Searching the ISBN number
					{
						if(obj[i].ISBN==k)					//comparing
						{
							k=i;
							break;
						}
						
						else if(i==n)
						{
							k=-1;
						}
					}
					
					if(k>=0)								//ISBN found
					{
						System.out.print("No of Copies: ");
						copies=sc.nextInt();								//number of copies to issue
					
						if(copies<=obj[k-1].available() && copies>=0)		//Checking the availability 
						{
							obj[k-1].issue(copies);							//Issuing the Book
							System.out.println("Issued Book Successfully");
						}
					
						else	//Not Available
						{
							System.out.println("Sorry only "+obj[k-1].available()+" Copies are Availble");
						}
					}
					
					else									//ISBN not found
					{
						System.out.println("Invalid ISBN Number");
					}
				}
				
				else	//list is empty
				{
					System.out.println("List is Empty");
				}
				
				break;
			}
			case 6:	//printing list
			{
				if(n>0)	//list is not empty
				{
					obj[0].all_details(obj, n);		//calling the function to print the complete list of books
					break;
				}
				else	//list is empty
				{
					System.out.println("List is Empty");
				}
			}
			}
		}
	}
}