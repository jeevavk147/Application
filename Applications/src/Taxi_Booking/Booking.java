package Taxi_Booking;
import java.util.*;
public class Booking 
{
	int limit=4,id=1;
	ArrayList<Taxi> taxi=new ArrayList<Taxi>();
	ArrayList<Taxi> bookingHistory=new ArrayList<Taxi>();
    public void book(char pickUp_Location, char drop_Location, int pickUp_Time)
    {
    	if(taxi.size()<limit)
    	{
    		taxi.add(new Taxi());
    	}
    	int min=Integer.MAX_VALUE;
    	Taxi taxiready=null;
    	for(Taxi t:taxi)
    	{
    		if(t.currentTime<=pickUp_Time&&Math.abs(t.currenLocation-pickUp_Location)<min)
    		{
    		 	taxiready=t;
    		 	min=Math.abs(t.currenLocation-pickUp_Location);
    		}
    	}
    	if(taxiready!=null)
    	{
    		System.out.println("Taxi "+(taxi.indexOf(taxiready)+1) +" is Booked");
    		taxiready.set_customerId(id++);
    		taxiready.set_currentLocation(drop_Location);
    		taxiready.set_currentTime(pickUp_Time+Math.abs(taxiready.currenLocation-pickUp_Location));
    		bookingHistory.add(taxiready);
    	}
    }
    public void display()
    {
    	for(Taxi t:taxi)
    	{
    		System.out.println("Taxi "+(taxi.indexOf(t)+1)+"\n"+"Currnt Location: "+ t.currenLocation+"\n"+"CurrentTime: "+t.currentTime);
    	}
    }
}
