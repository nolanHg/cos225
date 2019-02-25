import java.time.*;


public class Car implements Comparable<Car>
{

	private String code;	//arrival ("A") or departure ("D")
	private String license;	//the license plate
	private int[] atime = new int [2];	//time of arrival
	private int[] dtime = new int [2];	//time of departure
	//private Boolean parked;			//was the car able to park successfully? if so, parked is true
	private String parkedstatus;			//F=park on the street; L = park in the lot; D = departing;
	private int moved;
	private double dtimeAbsolute;
	private double totaltimeAbsolute;
	private int [] totalTime = new int [2];
	private LocalTime arrival = LocalTime.of(12, 0);
	private LocalTime departure = LocalTime.of(1, 0);
	private double fees = 0;
	//public LocalTime arrival = new LocalTime(0, 0, 0, 0);
	public Car()
	{
		code = "A";				//arriving or departing? default: arriving
		license = "LICENSE";		//default license: "LICE NSE"
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
			return (license + " parked at " + arrival + "\n");
			
		}
		if (parkedstatus.equals("F"))
		{
			return (license + " was turned away at " + arrival + " - LOT IS FULL!\n");
		}
		else //parkedstatus = "D"
		{
			return (license + " left at " + departure + " paying ");
		}
	}
	
	

	@Override
	public int compareTo(Car c)
	{
		if(license.equals(c.getLicense()))
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static double fee (LocalTime a, LocalTime d)
	{
		double fee;
		double aHour = a.getHour();
		double aMinute = a.getMinute();
		double aTotal = aHour + (aMinute/60);
		double dHour = d.getHour();
		double dMinute = d.getMinute();
		double dTotal = dHour + (dMinute/60);

		double totalTime = Math.ceil(dTotal - aTotal);
		fee = totalTime*5;
		return fee;
	}
		
	
	
	public int getMoved() {
		return moved;
	}

	public void setMoved(int moved) {
		this.moved = moved;
	}

	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getLicense()
	{
		return license;
	}
	public void setLicense(String license)
	{
		this.license = license;
	}
	

	

	public String getParkedstatus() {
		return parkedstatus;
	}

	public void setParkedstatus(String parkedstatus) {
		this.parkedstatus = parkedstatus;
	}

	public int[] getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int[] totalTime) {
		this.totalTime = totalTime;
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}
}
