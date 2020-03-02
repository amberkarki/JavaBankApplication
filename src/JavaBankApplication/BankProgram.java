package JavaBankApplication;

import java.text.DecimalFormat;
import java.util.*;
// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;
import java.util.ArrayList;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | "
				+ "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		System.out.print("\n*** Account list ***\n");

		if (!accountList.isEmpty()) {
			for (Account a : accountList) {
				System.out.println("Number: " + a.getAccountNumber() + " |" + " Balance: " + a.getBalance() + " euros");
			}
		} else {
			System.out.println("Sorry Acounts list is Empty!!");
		}
	}

	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter  Account number: ");
		String accountNumber = input.nextLine();

		for (int i = 0; i < accountList.size(); i++) {
			while (accountNumber.equals(accountList.get(i).getAccountNumber())) {
				System.out.println("Account not created. Account  "+accountNumber+ "  exists already!");
				System.out.print("Enter account number: ");
				accountNumber = input.nextLine();

			}
		}
		accountList.add(new Account(accountNumber));
		System.out.println("Account created successfully!");

	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.
	private static Account findAccount(String accountNumber) {
		Account myAccount = new Account();

		for (Account a : accountList) {
			if (accountNumber.equals(a.getAccountNumber())) {
				return myAccount = a;
			}
		}

		return new Account();
	}

	private static void depositMoney() {
		System.out.print("\n*** Deposit money to an account ***\n");

		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();

		Account a = findAccount(accountNumber);
		if (accountNumber.equals(a.getAccountNumber())) {
			System.out.print("Enter amount: ");
			
			
			double amount = Double.parseDouble(input.nextLine().replace(',','.'));
			
			a.deposit(amount);

		} else {
			System.out.println("Account  " + accountNumber + "  does not exist!");

		}

	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");

		System.out.print(" Enter account number:  ");
		String accountNumber = input.nextLine();
		Account a = findAccount(accountNumber);

		if (accountNumber.equals(a.getAccountNumber())) {
			System.out.print("Enter the amount to be withdrawn: ");
			double amount = Double.parseDouble(input.nextLine());
			a.withdraw(amount);
		} else {
			System.out.println("Account  " + accountNumber + "  does not exist!");
			;
		}

	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		Account a = findAccount(accountNumber);
		if (accountNumber.equals(a.getAccountNumber())) {
			accountList.remove(a);
			System.out.println("Account deleted successfully!");
		} else {
			System.out.println("Nothing deleted. Account  " + accountNumber + "  does not exist!");
		}
	}

}

// End