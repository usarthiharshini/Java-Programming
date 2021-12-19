import java.util.Scanner;

public class BankApplication {
        
  public static void main(String[] args) {
	  
	  System.out.println("Hi!");
	
	 
	  Account acc[]= new Account[10]; //creating objects of class Account
	  acc[0]= new Account(1000, "harshi", "@bye", 1000);
	  acc[1]= new Account(1001, "gajala", "@hi", 20);
	  acc[2]= new Account(1002, "bokka", "@entra", 3000);
	  acc[3]= new Account(1003, "venky", "@bye", 2000);
	  acc[4]= new Account(1004, "jilebi", "@hello", 7000); 
	
	  
	  if(acc[0].login(1000, "@bye")) {
		  acc[0].credit(3400);
		  acc[0].debit(20);
		  acc[0].transfer(acc[2], 300);
	  }
	  if(acc[1].login(1001, "@hi")) {
		  acc[1].credit(400);
		  
		  acc[1].transfer(acc[3], 100);
	  }
	  for(int i = 0 ; i < 5;i++ ) {
		  acc[i].display(acc[i]);
	    }
}
static class Account{
    private int accnum;
    private String accname;
    private String passwd;
    private int balance;
    private  int noOfTransac;
    
    public Account(int accnum, String accname, String passwd, int balance) {//constructor
    	this.setAccnum(accnum);
    	this.setAccname(accname);
    	this.setPasswd(passwd);
    	this.setBalance(balance);
    
    }

	

	



	public int getAccnum() {
		return accnum;
	}

	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}

	public String getAccname() {
		return accname;
	}

	public void setAccname(String accname) {
		this.accname = accname;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	//figuring out how to object as input from user
	public  void accCreation() {
		System.out.println("Enter account details:");
	  Scanner input = new Scanner(System.in);
		 int accnum = input.nextInt();
		 String accname = input.next();
		 String passwd = input.next();
		 int balance = input.nextInt();
		 input.close();
         System.out.println("Account number:"+ accnum + " Account Name:"+accname + " balance:" + balance + " password:" + passwd);
		
	}
	
	public void display(Account ac) {
		 System.out.println("Account number:"+ ac.getAccnum() + " Account Name:"+ac.getAccname() + " balance:" + ac.getBalance()+"number of transactions:"+ac.getNoOfTransac());
	}
	public boolean login(int accnum,String passwd){//to check if account number and password matches
		return (this.accnum==accnum && this.passwd==passwd);
	}
	public int getNoOfTransac() {//to get number of transactions
	return noOfTransac;

}
	
	public int credit(int amount) {
		noOfTransac++;
		return balance+= amount;
	}
	public int debit(int amount) {
		noOfTransac++;
		return balance-= amount;
	}
	public void transfer(Account ac1,int amount) {
		noOfTransac++;
		this.balance-=amount;
		ac1.balance+=amount;
		
	}
}}