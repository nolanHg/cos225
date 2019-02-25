//COS255
//Assignment 04
//2019-02-22
//Christian Doiron	

package assignment04_2;

public interface Stack<T> {
	public void push (T element);		// POST: add element to top of stack
	public T pop ( );					// PRE: stack is not empty
										// POST: remove top element and return 
	public T peek ( );					// PRE: stack is not empty
										// POST: return top element 
	public boolean isEmpty( );			// POST: return true if stack is empty, else false
	public int size ( );				// POST: return number of elements in stack
}
