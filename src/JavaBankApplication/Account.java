package JavaBankApplication;

// ************************************************************************
// Account.java	  Template created on15.9.2016
// - The class for Account objects
// ************************************************************************
public class Account {
	// Fields
	private String accountNumber;
	private double balance;

	// Constructor
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.balance = 0.00;
	}
	public Account()
	{
		accountNumber=null;
	}

	// Methods

	public void deposit(double amount) {
		
		if (amount > 0) {
			this.balance += amount;
			System.out.println("Amount  Deposited Successfully!!");
		}
		else
		{
			
			System.out.println("Invalid Amount!");
		}
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public double getBalance() {
		return this.balance;
	}

	public boolean withdraw(double amount) {
		if (amount <= this.balance && amount > 0) {
			this.balance = this.balance - amount;
			System.out.println("Withdrawal completed successfully!");
			return true;
		}
		else if(amount <0)
		{
			System.out.println("Sorry Can't withdraw "+amount+ " Amount!!!");
			return false;
		}
		else if (amount>this.balance)
		{
			System.out.println("Withdrawal not completed. Available balance is too low");
			return false;
		}
		else
		{
			System.out.println("Sorry invalid Amount!!!");
			return false;
		}
	}

}
// End