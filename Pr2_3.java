



//Prepared by 21CE106_Vraj
/*Aim = Use the Account class created as above to simulate an ATM machine.
Create 10 accounts with id AC001…..AC010 with initial balance 300₹. The system prompts the users to enter an id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id is accepted, display menu with multiple choices.
1.	Balance inquiry
2.	Withdraw money [Maintain minimum balance 300₹]
3.	Deposit money
4.	Money Transfer
5.	Create Account
6.	Deactivate Account
7.	Exit*/

import java.util.*;
class Account{
	static int count=0;
	private String accountID;
	private double accountBalance=300;
	private double annualInterestRate=0.07;
	private Date dateCreated;
	Scanner sc;
	
	Account(){
		count++;
		if(count >= 10) {
			accountID = "AC0" + (count);
			
		}
		else {
			accountID = "AC00" + (count);
		}
		accountBalance = 300;
		annualInterestRate = 0.07;
		dateCreated = new Date();
		sc=new Scanner(System.in);
	}
	void AccountDetail() {
		System.out.println("Account ID : " + accountID);
		System.out.println("Balance : " + accountBalance);
		System.out.println("Interest Rate : " + annualInterestRate);
		System.out.println("Date and Time when account was created : " + dateCreated);
		System.out.println("Current Date and Time : " + new Date());
        System.out.println();
	}
	void balanceInquiry() {
		//AccountDetail();
		System.out.println("Account " +accountID+ "\nBalance : " +accountBalance+ "\nAccount Created on " +dateCreated+ "\nCurrent date" + new Date());
	}
	int setbalance() {
		System.out.print("Enter  account Balance : ");
		double money = sc.nextDouble();
		if(money >= 300) {
			accountBalance=money;
			return 1;
		}
		else {
			System.out.println("Enter balance greater than or equal to 300 Rs");
			return 0;
		}
	}
	double getannualInterest() {
		return accountBalance*annualInterestRate;
	}
	void withdrawMoney(double money) {
		if(accountBalance>=300 && accountBalance-money>=300) {
			accountBalance-=money;
			System.out.println("Ammount of Rs. "+money+" withdrawn Successfully.");
			System.out.println("Current ammount is : " +accountBalance);
		}
		else {
			System.out.println("Not enough fund is available.");
		}
	}
	void depositMoney(double money) {
		accountBalance+=money;
	}
	String getAccountID() {
		return accountID;
	}
	//sc.close();
}

public class Pr2_3 {
	static int getIndex(ArrayList<Account> persons) {
		
		String ID=null;
		int i=0;
		boolean flag = true;
		//@SuppressWarnings("resource")
		Scanner sc1 = new Scanner (System.in);
		System.out.print("Enter ID of the account : ");
		for(i=0;i<persons.size()+1;i++) {
			if(flag) {
				ID=sc1.next();
				i=0;
				flag=false;
			}
			else if(i==persons.size()) {
				System.out.println("No account found.");
				flag=true;
				i=0;
				break;
			}
			if(ID.equals(persons.get(i).getAccountID())) {
				System.out.println("Account ID " + persons.get(i).getAccountID()+ "Found");
				break;
			}
		}
		return i;
		//sc1.close();
	}
	public static void main(String argc[]) {
		ArrayList<Account> persons = new ArrayList<Account>();
		boolean flag=true;
		double money;
		int i;
		for(i=0;i<10;i++) {
			Account a=new Account();
			persons.add(a);
		}
		for(i=0;i<10;i++) {
			persons.get(i).AccountDetail();
		}
		int x;
		Scanner sc2=new Scanner(System.in);
		while(flag==true) {
			
			System.out.println("\nChoice \t\t choice No");
			System.out.println(" Balance inquiry  :  1");
			System.out.println(" Withdraw money   :  2");
			System.out.println("  Deposit money   :  3");
			System.out.println("  Money Transfer  :  4");
			System.out.println("  Creat Account   :  5");
			System.out.println("  Deactivate Account  :  6");
			System.out.println("  Deposit money   :  7");
			System.out.print("choose any option : ");
			x=sc2.nextInt();
			System.out.println();
			if(x<=0 && x>7)continue;
			else if (x==7)break;
			switch(x) {
					case 1:
						i=getIndex(persons);
						persons.get(i).balanceInquiry();
						break;
					case 2:
						i=getIndex(persons);
						System.out.print("Enter amount to withdraw : ");
						money = sc2.nextDouble();
						persons.get(i).withdrawMoney(money);
						break;
					case 3:
						i=getIndex(persons);
						System.out.print("Enter amount to deposit : ");
						money = sc2.nextDouble();
						persons.get(i).depositMoney(money);
						System.out.println("Amount Deposited Successfully.");
						break;
					case 4:
						i=getIndex(persons);
						System.out.print("Enter account ID  in which you want to transfer the money : ");
						//money = sc2.nextDouble();
						
						int j=getIndex(persons);
						System.out.print("Enter amount to transfer : ");
						money=sc2.nextDouble();
						persons.get(i).withdrawMoney(money);
						persons.get(j).depositMoney(money);
						break;
					case 5:
						Account p=new Account();
						i=p.setbalance();
						if(i==1) {
							p.AccountDetail();
							persons.add(p);
							break;
						}
						else {
							System.out.println("Account is not Created.");
							break;
						}
					case 6:
						i=getIndex(persons);
						persons.remove(i);
						System.out.println("Account removed successfully.");
						break;
					case 7:
						flag=false;
						break;
					case 0:
						flag=false;
						break;
				
			}
			
		}
		sc2.close();
	}

}
