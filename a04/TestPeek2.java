import java.util.*;

import chapter19.ArrayStack;
import chapter19.*;

public class TestPeek2 {

	public TestPeek2()
	{
	}
	public static void main(String[ ] args)
	{
		ArrayStack<Integer>	istack = new ArrayStack<>();
		ArrayStack<String> sstack = new ArrayStack<>();
		ArrayStack<Double> dstack = new ArrayStack<>();
		
		istack.push(10);		istack.push(20);
		sstack.push("red");	sstack.push("blue");		 sstack.push("yellow");
		dstack.push(1.5);
		
		Integer i = (int)(peek2(istack));
		if (i == null)
		{
			System.out.println("Integer stack does not contain at least 2");
		}
		else
		{
			System.out.println("Integer stack second item is " + i);
		}
		
		String s = (String)(peek2(sstack));
		if (s == null)
		{
			System.out.println("String stack does not contain at least 2");
		}
		else
		{
			System.out.println("String stack second item is " + s);
		}
		
		Double d = (Double)(peek2(dstack));
		if (d == null)
		{
			System.out.println("Double stack does not contain at least 2");
		}
		else
		{
			System.out.println("Double stack second item is " + d);
		}
		System.out.println();
	}
	//or use overloading
	
	// you can name a two methods the same thing, ie, you can have 3 methods all called "peek2", each of which works with a different class (Integer, String, and Double). This is fine, but you need to define the method for *every* valid class that method could be used with. 
	
	
	
	//public static Double max (ArrayStack<? extends Number> stack)
	/*public Integer peek2(ArrayStack<Integer> stack)
	{
		int x = 0;
		return x;
	}*/
	
	
	
	public static <T> Object peek2 (ArrayStack<T> stack) //throws EmptyCollectionException
	{
		T x = null;
		try
		{
			T temp = stack.pop();
			x = stack.peek();
			stack.push(temp);
		}
		catch (EmptyCollectionException e)
		{
			x = null;
		}
		return x;
	}
	
	public int test (int x)
	{
		int y =0;
		return y;
	}
	
	
	
}
