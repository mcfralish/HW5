
public class StudentAdvance extends AdvanceTicket{
	
	public StudentAdvance(int num, int daysAhead) {
		super(num, daysAhead);
	}
	
	public String toString() {
		return super.toString()+"\n(ID Required)";
	}
	
	public int getPrice() {
		return super.getPrice()/2;
	}
	
	public String getType() {
		return "Student Advance";
	}
}
