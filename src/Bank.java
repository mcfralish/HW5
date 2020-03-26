/* Michael C Fralish
 * 03/27/2020
 * PID: 001-17-6489
 * Title: Bank
 * Banking Client Program that opens a user determined number of Paypal Accounts in an array. My program assigns one account as
 * mine/yours based on the Panther ID # of the user or my own depending on user option. It then assigns random balances
 * to each account and gives each an account number in ascending order starting from 001-999(max).
 */
import java.util.*;
public class Bank {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numOfAccount;
		String PID;		
		
		System.out.println("Welcome to the banking program. How many accounts will you be opening today?");
		numOfAccount = sc.nextInt();
		
		// Catches any input errors that result in an array larger than 99
		while(numOfAccount>999) {
			System.out.println("You may not open more 999 accounts.");
			System.out.println("How many accounts will you be opening today?");
			numOfAccount = sc.nextInt();
		}
		
		// Creates array of PaypalAccount Objects with random account balances and ascending account number order
		PaypalAccount[] accts = new PaypalAccount[numOfAccount];
		for(int i=0;i<accts.length;i++) {
			double balance = Math.random()*1000;
			accts[i] = new PaypalAccount(balance);
		}
		
		// Gives the user an option to use their own PID or mine
		System.out.println();
		System.out.println("Would you like to use the programmer's or the user's Campus ID for account calculation purposes?");
		System.out.println("1 Programmer");
		System.out.println("2 User");
		int answer = sc.nextInt();
		
		// Catches input errors for this question
		while(answer>2||answer<1) {
			System.out.println("That is not a valid answer.");
			System.out.println("1 Programmer");
			System.out.println("2 User");
			answer = sc.nextInt();
		}
		
		System.out.println();
		
		// Sets PID to my Panther ID if that option is selected
		if(answer==1) {
			PID = "001-17-6489";
			System.out.println("Programmer's Campus ID has been selected.");
			System.out.println("My Panther ID is: "+PID);
		}
		
		// Prompts the user to input their own PID if that option is chosen
		else {
			System.out.println("User's Campus ID has been selected.");
			System.out.println("What is your Panther ID? (Please enter all neccessary leading 0's and dashes.)");
			PID = sc.next();
			
			// Determines if the input format was correct for the PID, if not, prompts corrective action
			int dash1 = PID.indexOf('-');
			int dash2 = PID.indexOf('-', dash1+1);
			while (dash1!=3||dash2!=6||PID.length()!=11) {
				System.out.println();
				System.out.println("That is not a correct format.");
				System.out.println("Please enter your Panther ID with all neccessary leading 0's and dashes.");
				PID = sc.next();
				dash1 = PID.indexOf('-');
				dash2 = PID.indexOf('-', dash1+1);
			}
			
			System.out.println();
			System.out.println("Your Panther ID is: "+PID);
		}
		
		// Determines acct number and balance based off of PID
		String abc = PID.substring(0, 3);
		String e = PID.substring(5, 6);
		String fghi = PID.substring(7, 11);
		
		int myNum = Integer.parseInt(abc);
		double myBal = Double.parseDouble(e+fghi)/100;
			
		
		
		// If first 3 digits of the selected PID are greater than the number of accts
		if(myNum>=accts.length) {
			// Sets the last acct number within the array equal to the first 3 digits of the selected PID.
			accts[accts.length-1].setID(myNum);
			// Adds all the funds from the first account in the array to this account.
			accts[accts.length-1].transferAll(accts[0]);
			// Sets this account's balance to the last 5 digits of the selected PID.
			accts[accts.length-1].setBalance(myBal);
			System.out.println(accts[accts.length-1]);
		}
		
		else {
			// Adds all funds from the first account in the array to the the account who's
			// account number matches the first 3 digits of the selected PID.
			accts[myNum-1].transferAll(accts[0]);
			// Sets this account's balance to the last 5 digits of the selected PID.
			accts[myNum-1].setBalance(myBal);
			System.out.println(accts[myNum-1]);
		}
		
		// Initializing variables for calculation
		double sum=0;
		double max=0;
		double min=Double.MAX_VALUE;
		int maxi=0;
		int mini=0;
		
		for(int i=0;i<accts.length;i++) {
			
			// Determines the maximum balance
			if (max<accts[i].getBalance()) {
				maxi = i;
				max = accts[i].getBalance();
			}
			
			// Determines the minimum balance
			if (min>accts[i].getBalance()) {
				mini = i;
				min = accts[i].getBalance();
			}
			
			// Adds the balances for averaging
			sum+=accts[i].getBalance();
		}
		
		// Calculates and formats the average
		double avg = sum/accts.length;
		String Savg = String.format("%.2f", avg);
		
		// Prints the average
		System.out.println();
		System.out.println("The average balance is: $"+Savg);
		
		// Prints the max. If it is your acct, then gives a congrats message
		System.out.println();
		System.out.println("The account with the largest balance:");
		System.out.println(accts[maxi]);
		if(accts[maxi].getID()==myNum) System.out.println("Congratulations on having the highest account balance!");
		
		// Prints the min
		System.out.println();
		System.out.println("The account with the lowest balance:");
		System.out.println(accts[mini]);
		
		sc.close();
	}

}
