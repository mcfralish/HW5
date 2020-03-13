/* Michael C Fralish
 * 03/27/2020
 * PID: 001-17-6489
 * Title: PaypalAccount
 * The class file for Object PaypalAccount.
 */
public class PaypalAccount {
	
	static private int IDs=1;

	private double balance;
	private int accountID;
	
	// Constructor for regular accts
	public PaypalAccount(double balance) {
		this.balance=balance;
		accountID = IDs;
		IDs++;
	}
	
	// Constructor for myAcct
	public PaypalAccount(int myAcct, double myBalance) {
		this.balance=myBalance;
		this.accountID=myAcct;
	}
	
	// Formats and Prints
	public String toString() {
		String acctID = String.format("%03d", accountID);
		String bal = String.format("%.2f", balance);
		return "Account ID: "+acctID+"\nBalance: $"+bal;
	}
	
	// Getter for balance
	public double getBalance() {
		return balance;
	}
	
	// Getter for ID
	public int getID() {
		return accountID;
	}
	
	// Setter for balance
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	// Tallies up the class variable 
	public static void tally() {
		IDs++;
	}
	
	
}
