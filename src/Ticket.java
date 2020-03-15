
public class Ticket {
	
	private int price;
	private int num;
	
	public Ticket(int num) {
		price = 50;
		this.num=num;
	}
	
	public String toString() {
		return "Number: "+num+"\nPrice: "+this.getPrice()+"\nType: "+this.getType();		
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getType() {
		return "Standard";
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
}
