
public class StudentAdvance extends AdvanceTicket{
	
	public StudentAdvance(int num, int daysAhead) {
		super(num, daysAhead);
	}
	
	public int getPrice() {
		return super.getPrice()/2;
	}
	
	public String getType() {
		return "Student Advance";
	}
}
