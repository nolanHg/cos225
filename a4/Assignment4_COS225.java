//Christian Doiron
//Assignment 4 - COS 225
import java.io.FileNotFoundException;
import java.util.Stack.*;
import java.io.FileReader;
import java.util.*;
import java.util.Stack;

public class Assignment4_COS225
{

	public static void main(String[] args) throws FileNotFoundException
	{
		//use ArrayStack class, which is LIFO, for parking lot
		//use queue list thing for, which is FIFO, for street parking
		System.out.println("Christian Doiron");
		System.out.println("Assignment 4 - COS 225\n\n");
		Scanner file = new Scanner (new FileReader ("lot.txt"));
		Stack<Car> carLotStack = new Stack<Car>();				//LIFO

		ArrayList<Car> carStreetList = new ArrayList<Car>();	//FIFO

		while (file.hasNextLine()) {

			String code = file.next();
			String lic = file.next();
			int hour = file.nextInt();
			int minute = file.nextInt();
			
			if (code == "A") {

				if (carLotStack.size()<5) {

					String parkedstatus = "L";
					Car c = new Car(code,lic,hour,minute);
					c.setParkedstatus(parkedstatus);
					System.out.println(c.toString());
					carLotStack.push(c);

				} else {
					String parkedstatus = "F";
					Car c = new Car(code,lic,hour,minute);
					c.setParkedstatus(parkedstatus);
					System.out.println(c.toString());
				}
			}

			if (code == "D") {

				Car c1 = new Car(code,lic,hour,minute);
				Car c2 = carLotStack.pop();		
				
				
				while (c1.compareTo(c2) == 0) {

					c2.setMoved(c2.getMoved()+1);

					carStreetList.add(c2);

					c2 = carLotStack.pop();

				}

				//everytime someone is popped off the stack (and they aren't leaving), 50 cents should be added to their bill
				double totalFee = c2.fee(c2.getArrival(), c2.getDeparture())+c2.getMoved()*.5;
			}
		}
	}
}
