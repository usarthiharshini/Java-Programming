

public class BankMain{

    public static void main(String[] args) {
        Account genacc = new Account();
        genacc.setAccountNumber(1000);
        genacc.setName("harshi");
        genacc.setPassword("password");
        genacc.setBalance(10000);
        genacc.deposit(100);
        genacc.withdraw(2000);
        genacc.addInterest();
        genacc.printBalance();

        SavingsAccount savacc = new SavingsAccount(10001, "password", "jaffa", 50000, 12);
        savacc.deposit(100);
        savacc.withdraw(2000);
        savacc.setInterest_percent(12);
        savacc.addInterest();
        savacc.printBalance();

        CurrentAccount curracc = new CurrentAccount(10002, "password", "name", 5000, 1000);
        curracc.deposit(100);
        curracc.withdraw(2000);
        curracc.addInterest();
        curracc.printBalance();


    }
    
}

 class Account{

    private int accountNumber;
    private String password;
    private String name;
    private double balance;

    public Account(int accountNumber,String password,String name,int balance){
        this.accountNumber = accountNumber;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }
    public Account() {
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getBalance() {
       
        return balance;
    }
    public void printBalance(){
        System.out.println("balance in the account :"+ balance);
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double deposit(int amount){
        System.out.println("amount depositted :"+ amount);
           return balance+=amount;

    }
    public double withdraw(int amount){
        System.out.println("amount of withdrawn :"+ amount);
        return balance-=amount;
 }
    public void addInterest(){
        System.out.println("interest : 10%");
        setBalance(balance+balance*10/100);
    }

}
class SavingsAccount extends Account{

    public SavingsAccount(int accountNumber, String password, String name, int balance,double interest_percent) {
        super(accountNumber, password, name, balance);
        this.interest_percent = interest_percent;
    }

    private double interest_percent;

    public double getInterest_percent() {
        return interest_percent;
    }
    public void setInterest_percent(double interest_percent) {
        this.interest_percent = interest_percent;
    }

    public void addInterest(){
         setBalance(getBalance()+getBalance()*interest_percent/100);
    }



}
class CurrentAccount extends Account{

    public CurrentAccount(int accountNumber, String password, String name, int balance,double limit) {
        super(accountNumber, password, name, balance);
        this.limit = limit;
    }

    private double limit;

    public double getLimit() {
        return limit;
    }
    public void setLimit(double limit) {
        this.limit = limit;
    }
    public double withdraw(int amount){
        
        if(amount<=limit)
           setBalance(getBalance()-amount);
           else
           System.out.println("Transaction failed . Exceeded limit");
           return getBalance();
 }

    
}