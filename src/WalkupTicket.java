
public class WalkupTicket extends Ticket{
	
	public WalkupTicket(int num) {
		super(num);
	}
	
	public int getPrice() {
		return super.getPrice();
	}
	
	public String getType() {
		return "Walkup";
	}
}
