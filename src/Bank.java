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
		String abc;
		
		
		System.out.println("Welcome to the banking program. How many accounts will you be opening today?");
		numOfAccount = sc.nextInt();
		
		// Catches any input errors that result in an array larger than 99
		while(numOfAccount>999) {
			System.out.println("You may not open more 999 accounts.");
			System.out.println("How many accounts will you be opening today?");
			numOfAccount = sc.nextInt();
		}
		
		// Creates array of PaypalAccount Objects
		PaypalAccount[] accts = new PaypalAccount[numOfAccount];
		
		// Gives the user an option to use their own PID or mine
		System.out.println();
		System.out.println("Would you like to use the programmer's or the user's Campus ID for account calculation purposes?");
		System.out.println("1 Programmer");
		System.out.println("2 User");
		int answer = sc.nextInt();
		
		// Catches input errors this question
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
		abc = PID.substring(0, 3);
		String de = PID.substring(4, 6);
		String fghi = PID.substring(7, 11);
		
		int myAcct = Integer.parseInt(abc);
		double myBal = Double.parseDouble(de+fghi)/100;
				
		// Creates your/my account within the array
		if(answer==1) {
			System.out.println("My account number is "+abc);
			System.out.println("My account balance is: $"+myBal);
		}
		else {
			System.out.println("Your account number is "+abc);
			System.out.println("Your account balance is: $"+myBal);
		}
		
		// If your acct number is greater than the max number within the array, replaces the last index,
		// otherwise creates your account at the appropriate point in the array.
		if(myAcct>=accts.length) accts[accts.length-1] = new PaypalAccount(myAcct, myBal);
		else accts[myAcct-1] = new PaypalAccount(myAcct, myBal);
		
		// Initializing variables for calculation
		double sum=0;
		double max=0;
		double min=Double.MAX_VALUE;
		int maxi=0;
		int mini=0;
		
		for(int i=0;i<accts.length;i++) {
			double balance = Math.random()*1000;
			
			// Creates a new account for each index of the array, except the one exists already
			if (!(accts[i] instanceof PaypalAccount)) accts[i] = new PaypalAccount(balance);
			else PaypalAccount.tally();
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
		if(accts[maxi].getID()==myAcct) System.out.println("Congratulations on having the highest account balance!");
		
		// Prints the min
		System.out.println();
		System.out.println("The account with the lowest balance:");
		System.out.println(accts[mini]);
	}

}
