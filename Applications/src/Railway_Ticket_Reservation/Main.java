package Railway_Ticket_Reservation;
import java.util.*;
public class Main 
{
	public static void main(String[] args)
	{
	Ticket_Booking t=new Ticket_Booking();
	Scanner sc=new Scanner(System.in);
	boolean loop=true;
	while(loop)
	{
		System.out.println("1. Book Ticket\n2. Cancel Ticket\n3. Show Chart\n4. Exit");
		int i=sc.nextInt();
		switch(i)
		{
		case 1: 
		{
			System.out.print("Enter Source Location: ");
			char source=sc.next().charAt(0);
			System.out.print("Enter Destination Location: ");
			char destination=sc.next().charAt(0);
			System.out.print("Number of Seats You Want to Book: ");
			int seats=sc.nextInt();
			t.book(source, destination, seats);
			break;
		}
		case 2:
		{
			System.out.println("Enter Your PNR number: ");
			int pnr=sc.nextInt();
			System.out.println("Enter number of Seate to Cancel: ");
			int seats=sc.nextInt();
			t.cancel(pnr, seats);
			break;
		}
		case 3:
			t.show_Availability();
			break;
		case 4:
			loop =false;
			System.out.println("Thank You!!");
    	}
	}
	}
}
