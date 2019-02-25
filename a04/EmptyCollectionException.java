//COS255
//Assignment 04
//2019-02-22
//Christian Doiron

package assignment04_2;



@SuppressWarnings ("serial")
public class EmptyCollectionException extends RuntimeException {
	
		public EmptyCollectionException ( )
		{	
			super ("The collection is empty.");	
		}
}

