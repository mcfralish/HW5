
public class AdvanceTicket extends Ticket{
	
	private int daysAhead;
	
	public AdvanceTicket(int num, int daysAhead) {
		super(num);
		this.daysAhead=daysAhead;
	}
	
	public int getPrice() {
		int basePrice = super.getPrice();
		if (daysAhead<10) return basePrice-10;
		else return basePrice-20;
	}
	
	public String getType() {
		return "Advance";
	}
}
