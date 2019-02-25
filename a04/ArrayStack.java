//COS255
//Assignment 04
//2019-02-22
//Christian Doiron
package assignment04_2;

public class ArrayStack<T> implements Stack<T> {

	private int capacity;							// capacity of array
	private int top;								// top of stack 
	private T[ ] stack;								// array of items
	
	@SuppressWarnings("unchecked")
	public ArrayStack ( )							// POST: empty stack of capacity 10
	{
		capacity = 10;
		top = 0;
		stack = (T [ ]) new Object [capacity];		// new array of indicated type
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack (int cap)						// POST: array of use capacity
	{	capacity = cap;
		top = 0;
		stack = (T [ ]) (new Object [capacity]); 	
	}
	
	public void push (T element)					// POST: item is added to top of stack
	{	if (top == capacity)
			resize();								// resize underlying array as needed
		stack[top] = element;
		top++;
	}
	
	@SuppressWarnings("unchecked")
	private void resize()							// POST: resize array by doubling capacity
	{	T [ ] temp = (T[ ]) new Object [capacity*2];
		for (int k = 0; k < capacity; k++)			// copy elements from old array to new array
			temp[k] = stack[k];
		capacity = capacity * 2;					// double capacity
		stack = temp;								// assign stack reference to new bigger array
	}
	
	public T peek ( ) throws EmptyCollectionException	// POST: return top item
	{	if (isEmpty())
			throw new EmptyCollectionException ( );		// throw exception on empty stack
		return stack[top-1];
	}
	
	public T pop ( ) throws EmptyCollectionException	// POST: return and remove top item
	{	if (isEmpty())
				throw new EmptyCollectionException ( );	// throw exception on empty stack
		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}
	
	public boolean isEmpty ( )						// POST: return true if empty
	{	return top == 0;  }
		
	public int size( )								// POST: return number of items	
	{	return top;   }
}


