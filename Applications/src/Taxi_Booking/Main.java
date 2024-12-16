package Taxi_Booking;
import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Booking b=new Booking();
		Scanner sc=new Scanner(System.in);
		boolean loop=true;
		while(loop)
		{
			System.out.println("1. Book Taxi \n2. View Details \n3. Exit");
			int a=sc.nextInt();
		switch(a)
		{
		case 1:
			System.out.print("PickUp Location: ");
			char p=Character.toUpperCase(sc.next().charAt(0));
			System.out.print("Drop Location: ");
			char d=Character.toUpperCase(sc.next().charAt(0));
			System.out.print("PickUp Time: ");
			int t=sc.nextInt();
			b.book(p, d, t);
			break;
		case 2:
			b.display();
			break;
		case 3:
			System.out.println("Thank You!!");
			loop=false;
			break;
		}
		}
	}
}
