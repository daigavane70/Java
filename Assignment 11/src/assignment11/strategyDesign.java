package assignment11;
import java.util.*;
interface payment{
	void pay(int amount);
}
class paypal implements payment{
	String Password="1234";
	String EnteredPassword;
	Scanner sc=new Scanner(System.in);
	
	paypal(String pass) {
		EnteredPassword=pass;
	}
	
	public void pay(int amount) {
		if(EnteredPassword==Password) {
			System.out.println("Rs."+amount+"Paid SuccessFully");
		}
		else {
			System.out.println("Payment Failed, Invalid Password");
		}
	}
}
class card implements payment{
	int cvv=156;
	int enteredCVV;
	String Password="123456";
	String enteredPassword;
	
	card(int No, String pass){
		this.enteredCVV=No;
		this.enteredPassword=pass;
		
		System.out.print(this.enteredCVV+' '+this.enteredPassword);
	}
	
	public void pay(int amount) {
		if(enteredPassword==Password && cvv==enteredCVV) {
			System.out.println("Rs."+amount+"Paid SuccessFully");
		}
		else if(enteredPassword!=Password) {
			System.out.println("Payment Failed, Invalid Password");
		}
		else if(enteredCVV!=cvv) {
			System.out.println("Payment Failed, Invalid CVV");
		}
	}
}
class bitcoin implements payment{
	int BlockNo=156;
	int enteredBlock;
	String Password="123456";
	String enteredPassword;
	
	bitcoin(int No, String pass){
		this.enteredBlock=No;
		this.enteredPassword=pass;
	}
	
	public void pay(int amount) {
		if(enteredPassword==Password && BlockNo==enteredBlock) {
			System.out.println("Rs."+amount+"Paid SuccessFully");
		}
		else if(enteredPassword!=Password) {
			System.out.println("Payment Failed, Invalid Password");
		}
		else if(enteredBlock!=BlockNo) {
			System.out.println("Payment Failed, Invalid BlockNumber");
		}
	}
}
class Product{
	private String identity;
	private int price;
	Product(String id,int price){
		this.identity=id;
		this.price=price;
	}
	String getId()
	{
		return identity;
	}
	int getPrice() {
		return price;
	}
}
class Shop{
	Scanner sc=new Scanner(System.in);
	Product menu() {
		System.out.println("***********MENU***********\n1)Pizza\n2)Burger\n3)Juice");
		int choice=sc.nextInt();
		Product item=null;
		switch(choice) {
		case 1:
			item=new Product("Pizza",400);
			break;
		case 2:
			item=new Product("Burger",100);
			break;
		case 3:
			item=new Product("Juice",50);
			break;
		}
		return item;
	}
	int bill()
	{
		Product item=menu();
		System.out.println("To Buy "+item.getId()+", Please Pay: "+item.getPrice());
		return item.getPrice();
	}
	
	void pay(payment paymentMethod,int amt) {
		paymentMethod.pay(amt);
	}
}
public class strategyDesign {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		Shop s=new Shop();
		int amt=s.bill();
		System.out.println("\nPayment Methods\n1)Card\n2)Paypal\n3)bitcoin");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			int cardNo;
			String Password;
			
			System.out.print("Enter Card No: ");
			cardNo=sc.nextInt();
			System.out.print("Enter Password: ");
			Password=sc.nextLine();
			Password=sc.nextLine();
			s.pay(new card(cardNo,Password),amt);
			break;
		case 2:
			String password;
			System.out.println("Enter the Password: ");
			password=sc.nextLine();
			s.pay(new paypal(password),amt);
			break;
		case 3:
			int BlockNo;
			String pass;
			System.out.print("Enter the block Number");
			BlockNo=sc.nextInt();
			pass=sc.nextLine();
			s.pay(new bitcoin(BlockNo,pass),amt);
			break;
		}
	}

}
/************MENU***********
1)Tea
2)Coffee
3)Juice
1
**************BILL**************
Item bought: Tea
Item price: 10

Payment Methods
1)Card
2)Paypal
3)bitcoin
2
10 paid using Paypal
*/