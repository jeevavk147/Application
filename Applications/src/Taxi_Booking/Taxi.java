package Taxi_Booking;
public class Taxi
{
	int customerId;
	char currenLocation='A';
	int currentTime;
	public void set_currentLocation(char currentLocation)
	{
		this.currenLocation=currentLocation;
	}
	public char get_currentLocation()
	{
		return currenLocation;
	}
	public void set_currentTime(int currentTime)
	{
		this.currentTime=currentTime;
	}
	public int get_currentTime()
	{
		return currentTime;
	}
	public void set_customerId(int customerId)
	{
		this.customerId=customerId;
	}
	public int get_customerId()
	{
		return customerId;
	}
}
