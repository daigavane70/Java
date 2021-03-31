import java.util.*;

public class Employee {
	String Name;
	int Id;
	String Address;
	String eMail;
	long Mob_No;
	
	Employee()							//Employee constructor
	{
		System.out.println("Employee Object is Created");
	}
										//Getter Methods
	void setName(String name) {
		this.Name=name;
	}
	void setId(int code) {
		this.Id=code;
	}
	void setAddress(String Addr) {
		this.Address=Addr;
	}
	void setE_Mail(String mail) {
		this.eMail=mail;
	}
	void setMob_No(long no) {
		this.Mob_No=no;
	}
	
										//Setter Methods
	String getName() {
		return this.Name;
	}
	int getId() {
		return this.Id;
	}
	String getAddress() {
		return this.Address;
	}
	String getE_Mail() {
		return this.eMail;
	}
	
	long getMob_No() {
		return this.Mob_No;
	}
										//read the members of BaseClass
	void read() {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Name: ");
		this.setName(sc.nextLine());
		
		System.out.print("Id: ");
		this.setId(sc.nextInt());
		
		sc.nextLine();		
		System.out.print("Address: ");
		this.setAddress(sc.nextLine());
		
		System.out.print("E-Mail: ");
		this.setE_Mail(sc.nextLine());
		
		long n;
		System.out.print("Mobile: ");
		n=sc.nextLong();
		while(n>=10000000000l && n<7000000000l)
		{
			System.out.print("Invalid Mobile Number, Enter again: ");
			n=sc.nextLong();
		}
		this.setMob_No(n);
	}
	
	//display the members of BaseClass
	void display() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Name: "+Name);
		System.out.println("ID: "+Id);
		System.out.println("Address: "+Address);
		System.out.println("E-Mail: "+eMail);
		System.out.println("Contact No: "+Mob_No);
	}
	
	public class Programmer extends Employee{		//Programmer Class derived From Employee
		double BP;
		double DA=0.97*BP;
		double HRA=0.1*BP;
		double PF=0.12*BP;
		double staffClubFunc=0.001*BP;
		
		double grossSalary=BP+DA+HRA;
		double netSalary=grossSalary-PF-staffClubFunc;
		
		Programmer()
		{
			System.out.println("Programmer Object is Created");
		}
		
		void read()
		{
			Scanner sc=new Scanner(System.in);
			
			super.read();
			System.out.print("BP: ");
			BP=sc.nextDouble();
		}
		
		void display() {
			super.display();
			System.out.println("BP: "+BP);
			System.out.println("Gross Salary: "+grossSalary);
			System.out.println("Net Salary: "+netSalary);
		}
	}
	
	public class TeamLead extends Programmer{
		TeamLead()
		{
			System.out.println("TeamLead Object Created");
		}
	}
	
	public class assistantProjectManager extends Programmer{
		assistantProjectManager()
		{
			System.out.println("assistantProjectManager Object Created");
		}
	}
	
	public class projectManager extends Programmer{
		projectManager()
		{
			System.out.println("projectManager Object is Created");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e=new Employee();
		e.read();
		e.display();
		
		Programmer p=e.new Programmer();
		p.read();
		p.display();
		
		TeamLead t=p.new TeamLead();
		t.read();
		t.display();
		
		assistantProjectManager apm=p.new assistantProjectManager();
		apm.read();
		apm.display();
		
		projectManager pm=p.new projectManager();
		pm.read();
		pm.display();
	}
}
