package Railway_Ticket_Reservation;
import java.util.*;
import java.util.concurrent.*;
public class Ticket_Booking 
{
	int pnr=0;
	Map<Integer,Ticket> bookedticketlist=new HashMap<Integer,Ticket>();
	ConcurrentMap<Integer,Ticket> waitingticketlist=new ConcurrentHashMap<Integer,Ticket>();
	Map<Integer,Ticket> cancelledticketlist=new HashMap<Integer,Ticket>();
	int[] availableSeats= {8,8,8,8,8};
	int[] availableSeats_Waitinglist= {2,2,2,2,2};
	public void book(char source, char destination, int seats)
	{
		if(checkAvailability(source,destination,seats))
			{
			pnr++;
			System.out.println("Your Ticket is Booked and Your PNR is "+pnr);
			decreaseSeats(source,destination,seats);
			bookedticketlist.put(pnr, new Ticket(source,destination,seats));
			}
		else
		{
			if(checkwaitinglist(source,destination,seats))
			{
				pnr++;
				System.out.println("Your Ticket is in Wainting List and Your PNR is "+pnr);
				decreaseSeatsWaitingList(source,destination,seats);
				waitingticketlist.put(pnr, new Ticket(source,destination,seats));
			}
			else
			{
			System.out.println("Number of seats You Entered is Not Available");
			}
		}
	}
	private void decreaseSeats(char source, char destination, int seats)
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
			availableSeats[i]-=seats;
		}
		
	}
	private void decreaseSeatsWaitingList(char source, char destination, int seats) 
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
			availableSeats_Waitinglist[i]-=seats;
		}
	}
	private boolean checkAvailability(char source, char destination, int seats) 
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
			if(availableSeats[i]<seats)
				return false;
		}
		return true;
	}
	private boolean checkwaitinglist(char source, char destination, int seats) 
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
			if(availableSeats_Waitinglist[i]<seats)
				return false;
		}
		return true;
	}
	public void cancel(int pnr,int seats)
	{
		if(bookedticketlist.containsKey(pnr))
		{
			Ticket t=bookedticketlist.get(pnr);
			if(seats==t.get_seats())
			{	
			System.out.println("PNR "+pnr+" is Cancelled with "+seats+" Seats");
			increase_SeatsAvailability(t.get_source(),t.get_destination(),seats);
			cancelledticketlist.put(pnr, t);
			bookedticketlist.remove(pnr);
			check_WaitingList();
			}
			else if(seats<t.get_seats())
			{	
			System.out.println("PNR "+pnr+" is Partially Cancelled with "+seats+" Seats");
			increase_SeatsAvailability(t.get_source(),t.get_destination(),seats);
			t.set_seats(t.get_seats()-seats);
			check_WaitingList();
			}
			else
			{
				System.out.println("Enter Valid Seats");
			}
		}
		else if(waitingticketlist.containsKey(pnr))
		{
			Ticket t=waitingticketlist.get(pnr);
			if(seats==t.get_seats())
			{
			System.out.println("PNR "+pnr+" is Cancelled with "+seats+" Seats in Waiting List");
			increase_SeatsAvailability_Waiting(t.get_source(),t.get_destination(),seats);
			cancelledticketlist.put(pnr, t);
			waitingticketlist.remove(pnr);
			}
			else if(seats<t.get_seats())
			{
			System.out.println("PNR "+pnr+" is Partially Cancelled with "+seats+" Seats in Waiting List");
			t.set_seats(t.get_seats()-seats);
			increase_SeatsAvailability_Waiting(t.get_source(),t.get_destination(),seats);
			}
			else
			{
				System.out.println("Enter Valid Seats");
			}
		}
		else
		{
			System.out.println("Enter Valid PNR Number");
		}
		
	}
	private void check_WaitingList() 
	{	
	 for(int t:waitingticketlist.keySet())
	 {
		 if(checkAvailability(waitingticketlist.get(t).get_source(),waitingticketlist.get(t).get_destination(),waitingticketlist.get(t).get_seats()))
		{
		  bookedticketlist.put(t,waitingticketlist.get(t) );
		  decreaseSeats(waitingticketlist.get(t).get_source(),waitingticketlist.get(t).get_destination(),waitingticketlist.get(t).get_seats());
		  increase_SeatsAvailability_Waiting(waitingticketlist.get(t).get_source(),waitingticketlist.get(t).get_destination(),waitingticketlist.get(t).get_seats());
		  waitingticketlist.remove(t);
		} 
	 }
	}
	private void increase_SeatsAvailability(char source, char destination, int seats) 
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
		 availableSeats[i]+=seats;	
		}
	}
	private void increase_SeatsAvailability_Waiting(char source, char destination, int seats) 
	{
		for(int i=source-'A';i<destination-'A';i++)
		{
		 availableSeats_Waitinglist[i]+=seats;	
		}
	}
	public void show_Availability()
	{
		System.out.println("Seat Details: \n");
		System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8\n");
		for(char c='A';c<='E';c++)
		{
			System.out.print(c);
			int seatsbooked=8-availableSeats[c-'A'];
			for(int i=0;i<seatsbooked;i++)
			{
				System.out.print("\tB");
			}
			for(int i=seatsbooked;i<seatsbooked+availableSeats[c-'A'];i++)
			{
				System.out.print("\tA");
			}
			System.out.println("\n");
		}
		System.out.println("Booked Tickets PNR: ");
	    for(int i:bookedticketlist.keySet())
	    {
	    	System.out.print(i+" ");
	    }
	    System.out.println();
	  
	    System.out.print("Waiting Tickets PNR: ");
	    for(int i:waitingticketlist.keySet())
	    {
	    	System.out.print(i+" ");
	    }
	    System.out.println();
	    System.out.print("Cancelled Tickets PNR: ");
	    for(int i:cancelledticketlist.keySet())
	    {
	    	System.out.print(i+" ");
	    }
	    System.out.println();
		
	}
}
