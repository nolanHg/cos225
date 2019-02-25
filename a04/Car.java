//COS255
//Assignment 04
//2019-02-22
//Christian Doiron

package assignment04_2;

import java.time.LocalTime;


public class Car implements Comparable<Car>
{

	private String code;				//arrival ("A") or departure ("D")
	private String license;				//the license plate
	private int[] atime = new int [2];	//time of arrival
	private int[] dtime = new int [2];	//time of departure
	private String parkedstatus;		//F=park on the street; L = park in the lot; D = departing;
	private int moved;
	private LocalTime arrival;
	private LocalTime departure;

	//public LocalTime arrival = new LocalTime(0, 0, 0, 0);
	public Car()
	{
		code = "A";				//arriving or departing? default: arriving
		license = "LICENSE";	//default license: "LICE NSE"
		atime [0] = 6;
		atime [1] = 0;			//sets the default time to 6:00
		parkedstatus = "L";
		moved = 0;
	}
	
	public Car (String code, String license, int hour, int minute)
	{
		this.code = code;
		if (code.equals("A"))
		{
			this.license = license;
			arrival = LocalTime.of(hour, minute);
		}
		if (code.equals("D"))
		{
			this.license=license;
			departure = LocalTime.of(hour, minute);
			this.parkedstatus="D";
		}
	}
	
	@Override
	public String toString()
	{
		if (parkedstatus.equals("L"))
		{
			return (license + " parked at " + arrival + "\n\n");
			
		}
		if (parkedstatus.equals("F"))
		{
			return (license + " was turned away at " + arrival + " - LOT IS FULL!\n\n");
		}
		else //parkedstatus = "D"
		{
			return license + " left at " + departure + " paying " + String.format("$%.2f", fee()) + "\n\n";
		}
	}

	@Override
	public int compareTo(Car c)
	{
		if(license.equals(c.getLicense())) {

			return 1;

		} else {

			return 0;
		}
	}
	
	public double fee()
	{
		double fee;

		int aHour = arrival.getHour();
		int aMinute = arrival.getMinute();
		double aTotal = aHour + (aMinute / 60.0);

		int dHour = departure.getHour(); 
		int dMinute = departure.getMinute();
		double dTotal = dHour + (dMinute / 60.0);

		//System.out.println("Arrival: " + Double.toString(aTotal));
		//System.out.println("Departure: " + Double.toString(dTotal));

		double totalTime = Math.ceil(dTotal - aTotal);

		fee = totalTime * 5 + moved * 0.50;
		return fee;
	}
		
	public int getMoved() {
		return moved;
	}

	public void setMoved(int moved) {
		this.moved = moved;
	}

	public void setParkedstatus(String parkedstatus) {
		this.parkedstatus = parkedstatus;
	}
	
	public LocalTime getArrival() {
		return arrival;
	}

	public LocalTime getDeparture() {
		return departure;
	}	
	
	public String getLicense() {
		return license;
	}
	
	public void setDeparture(LocalTime d) {
		departure = d;
	}
}
