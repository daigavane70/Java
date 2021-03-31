import java.io.*;
import java.util.Scanner;

class Info{
	String Name="Unknown";
	int accNo=0;
	String type="Saving";
	double Balance=0;
}

class Bank extends Info{
	int customers=0;
	Info[] list;
	Scanner sc=new Scanner(System.in);
	
	Bank(int intialTotal){
		list=new Info[intialTotal];
	}
	
	void createAccount() {
		
		list[customers]=new Info();
		
		System.out.println("-------------Enter Details-----------");
		System.out.println("Name: ");
		list[customers].Name=sc.nextLine();
		System.out.println("Type: ");
		list[customers].type=sc.nextLine();
		list[customers].accNo=(1000)+(++customers);
		
		System.out.println("Account Created SuccessFully");
		this.accountDetails(list[customers-1]);
	}
	
	void display() {
		for(int i=0;i<customers;i++) 
			System.out.println(i+". "+list[i].Name+' '+list[i].accNo+list[i].type+list[i].Balance);
	}
	
	int selectAccount() {
		System.out.print("Enter the Account Number to Select: ");
		int account=sc.nextInt();
		while(true) {
		if(account<=1000+customers) {
			return account-1001;
		}
		else {
			System.out.println("Invalid Account No, ENter Again: ");
			account=sc.nextInt();
		}
		}
	}
	
	boolean search(int account) {
		
		for(int i=0;i<customers;i++)
			if(list[i].accNo==account) return true;
		return false;
	}
	
	void accountDetails(Info account) {
		System.out.println("----------Account Details----------");
		System.out.println("Name: "+account.Name);
		System.out.println("Account Number: "+account.accNo);
		System.out.println("Type: "+account.type);
		System.out.println("Balance: "+account.Balance);
		System.out.println("-----------------------------------");
	}
	
	void BalanceCheck() {
		int account=this.selectAccount();
		System.out.println("Account Balance is: " + list[account].Balance);
	}
	
	void deposit() {
		int account=this.selectAccount();
		if(this.search(account+1001)) {
			int i;
			for(i=0;i<customers;i++) 
				if(list[i].accNo==1001+account) break;
			accountDetails(list[i]);
			System.out.print("Deposit Amount: ");
			int Deposit=sc.nextInt();
			
			if(Deposit<=50000) 
				list[account].Balance+=Deposit;
			else
				System.out.println("Maximum Deposit Amount should be <=100000");
		}
		else
			System.out.println("Account Not Found");
	}
	
	void withdraw() {
		int account=this.selectAccount();
		if(this.search(1001+account)) {
			int i=0;
			for(i=0;i<customers;i++) 
				if(list[i].accNo==1001+account) break;
			accountDetails(list[i]);
			System.out.print("Deposit Amount: ");
			int wDraw=sc.nextInt();
			
			if(wDraw<=50000) {
				if(wDraw<=list[account].Balance)
					list[account].Balance-=wDraw;
				else
					System.out.println("Insufficient Funds, Account Balance: "+list[account].Balance);
			}
			else
				System.out.println("Maximum WithDraw Amount should be <=50000");
		}
		else
			System.out.println("Account Not Found");
	}
}

public class CaseStudy {
	
	public static void main(String args[]) {
		Bank obj=new Bank(10);			//creating an array of 10 account Holders
		
		int choice=0;
		
		Scanner sc=new Scanner(System.in);
		
		while(choice<6) {
			
			System.out.println("1. Create Account");
			System.out.println("2. Account Details");
			System.out.println("3. WithDraw");
			System.out.println("4. Deposit");
			System.out.println("5. Balance Check");
			System.out.println("6. Exit");
			System.out.print("Enter the CHoice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				obj.createAccount();
				break;
			case 2:
				obj.accountDetails(obj.list[obj.selectAccount()]);
				break;
			case 3:
				obj.withdraw();
				break;
			case 4:
				obj.deposit();
				break;
			case 5:
				obj.BalanceCheck();
				break;
			}
		}
	}

}

/*
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 1
-------------Enter Details-----------
Name: 
Vedant Daigavane
Type: 
Savings
Account Created SuccessFully
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 0.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 1
-------------Enter Details-----------
Name: 
Rohit James
Type: 
Savings
Account Created SuccessFully
----------Account Details----------
Name: Rohit James
Account Number: 1002
Type: Savings
Balance: 0.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 2
Enter the Account Number to Select: 1002
----------Account Details----------
Name: Rohit James
Account Number: 1002
Type: Savings
Balance: 0.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 2
Enter the Account Number to Select: 1001
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 0.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 4
Enter the Account Number to Select: 1001
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 0.0
-----------------------------------
Deposit Amount: 10000
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 2
Enter the Account Number to Select: 1002
----------Account Details----------
Name: Rohit James
Account Number: 1002
Type: Savings
Balance: 0.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 2
Enter the Account Number to Select: 1001
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 10000.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 3
Enter the Account Number to Select: 1001
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 10000.0
-----------------------------------
Deposit Amount: 5000
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 2
Enter the Account Number to Select: 1001
----------Account Details----------
Name: Vedant Daigavane
Account Number: 1001
Type: Savings
Balance: 5000.0
-----------------------------------
1. Create Account
2. Account Details
3. WithDraw
4. Deposit
5. Balance Check
6. Exit
Enter the CHoice: 6
*/