package Railway_Ticket_Reservation;

public class Ticket 
{
	private int seats;
	private char source;
	private char destination;
	Ticket(char source, char destination, int seats)
	{
		this.seats=seats;
		this.source=source;
		this.destination=destination;
	}
	public void set_seats(int seats)
	{
		this.seats=seats;
	}
	public int get_seats()
	{
		return seats;
	}
	public void set_source(char source)
	{
		this.source=source;
	}
	public char get_source()
	{
		return source;
	}public void set_destination(char destination)
	{
		this.destination=destination;
	}
	public char get_destination()
	{
		return destination;
	}
	
}
