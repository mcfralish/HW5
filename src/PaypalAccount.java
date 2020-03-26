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
		balance=myBalance;
		accountID=myAcct;
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
	
	// Setter for ID
	public void setID(int num) {
		accountID = num;
	}
	
	// Transfer Funds
	public void transferAll(PaypalAccount from) {
		double amnt = from.getBalance();
		this.balance += amnt;
		from.setBalance(from.getBalance()-amnt);
	}
	
}
