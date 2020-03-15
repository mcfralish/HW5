import java.util.*;
public class Ticketer {

	public static void main(String[] args) {
		
		//Ticket t1 = new StudentAdvance(2,10);
		//System.out.println(t1);
		Scanner sc = new Scanner(System.in);
		System.out.println("How many tix?");
		int howMany = sc.nextInt();
		
		Ticket[] tix = new Ticket[howMany];
		
		for (int i=0;i<tix.length;i++) {
			System.out.println("Was this ticket purchased in advance?(yes/no)");
			String advance = sc.next();
			advance = advance.toLowerCase();
			
			int howLong=0;
			String student=null;
			if(advance.equals("yes")) {
				System.out.println("How many days in advance?");
				howLong = sc.nextInt();
				System.out.println("Is this ticket for a student?(yes/no");
				student = sc.next();
				student = student.toLowerCase();
			}
			
			
			if(advance.equals("yes")&&student.equals("yes")) tix[i] = new StudentAdvance(i+1,howLong);
			else if (advance.equals("yes")&&student.contentEquals("no")) tix[i] = new AdvanceTicket(i+1,howLong);
			else tix[i] = new WalkupTicket(i+1);
			System.out.println(tix[i]);
		}
		sc.close();
	}

}
