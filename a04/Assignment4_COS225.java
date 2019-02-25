//COS255
//Assignment 04
//2019-02-22
//Christian Doiron

package assignment04_2;

import java.io.FileNotFoundException;
import java.util.Stack.*;
import java.io.FileReader;
import java.util.*;
import java.util.Stack;
import java.time.*;
import java.text.*;

public class Assignment4_COS225 {

	public static void main(String[] args) throws FileNotFoundException
	{
		//use ArrayStack class, which is LIFO, for parking lot
		//use queue list thing, which is FIFO, for street parking
		System.out.println("Christian Doiron");
		System.out.println("Assignment 4 - COS 225\n\n");
		Scanner file = new Scanner (new FileReader ("lot.txt"));
		Stack<Car> carLotStack = new Stack<Car>();				//LIFO
		int nCarsMoved = 0;
		
		double sumIncome = 0;
		double sumMeterFees = 0;
		
		DecimalFormat df = new DecimalFormat("$0.00");

		ArrayList<Car> carStreetList = new ArrayList<Car>();	//FIFO

		while (file.hasNextLine()) {
			
		try {		
			String code = file.next();
			String lic = file.next(); // VP, Manager, Clerk, etc.
			int hour = file.nextInt();
			int minute = file.nextInt();
			
			if (code.equals("A")) {

				if (carLotStack.size() < 5) { 

					Car c = new Car(code,lic,hour,minute);
					c.setParkedstatus("L");

					System.out.println(c.toString());
					carLotStack.push(c); // Put a new car in the lot if there is space

				} else {

					Car c = new Car(code,lic,hour,minute);
					c.setParkedstatus("F");
					System.out.println(c.toString());
				}
			}

			if (code.equals("D")) {		//if code = D

				Car c1 = carLotStack.pop();
				Car c2 = new Car(code, lic, hour, minute);
				
				while(c2.compareTo(c1) == 0) {		
					//while the car at the entrace to the lot is NOT the same car that wants to leave

					c1.setMoved(c1.getMoved() + 1);
					carStreetList.add(c1);
					c1 = carLotStack.pop();
					nCarsMoved++;
				}

				c1.setParkedstatus("D");
				c1.setDeparture(LocalTime.of(hour, minute));

				
				for (int i = 0; i < nCarsMoved; i++) {
					carLotStack.push(carStreetList.get(i));	
				}	
		//................................................................................		
				carStreetList.clear();

				//everytime someone is popped off the stack (and they aren't leaving), 
				//50 cents should be added to their bill
				nCarsMoved = 0;
				double f = fee(c1.getArrival(), c1.getDeparture());
				sumIncome += f;
				double m = c1.getMoved() * 0.50;
				sumMeterFees += m;
				System.out.println(c1.getLicense() + " left at " + c1.getDeparture() + " paying " + df.format(f) + "\n\n");
			}
			
		} catch (NoSuchElementException e) {
			break;
		}			

		
		}	
			System.out.println("\n\nDay's Income: " + df.format(sumIncome));
			System.out.println("Days' Meter Fees: " + df.format(sumMeterFees));	
	}
	
	public static double fee(LocalTime a, LocalTime d)
	{
		double fee;
		int aHour = a.getHour();
		int aMinute = a.getMinute();
		double aTotal = aHour + (aMinute / 60.0);
		
		int dHour = d.getHour();
		int dMinute = d.getMinute();		
		double dTotal = dHour + (dMinute / 60.0);
		
		double totalTime = Math.ceil(dTotal - aTotal);
		
		fee = totalTime * 5;
		
		return fee;
	}
}
