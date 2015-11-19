
import java.awt.Point;


public class LinkedList
{
    private Node head; // Reference to first node in list
    private Node tail; // Reference to last node in list
    private int listCount;
    
    // No-arg constructor
    public LinkedList( )
    {
        head = tail = null;
    }
    
    // Copy constructor
    public LinkedList( LinkedList copy )
    {
        Node copyptr = copy.head;
   
        if ( copyptr != null )
        {
            head = tail = new Node( (Point) copyptr.getData(), null );
            copyptr = copyptr.getNext();
            while ( copyptr != null )
            {
                tail.setNext( new Node( (Point) copyptr.getData(), null ) );
                tail = tail.getNext();
                copyptr = copyptr.getNext();
            }
        }
        else
            head = tail = null;
    } // end copy constuctor

    
    // Inserts a node at the front of the list
    // The data is given, and the node is created 
    // in this method
    public void insertFront( Point newData )
    {
        if ( isEmpty() )
            head = tail = new Node( newData, null );
        else
        {
            Node newNode = new Node( newData, null );
       
            newNode.setNext( head );
            head = newNode;
            // shorter version: 
            // head = new Node( newData, head );
        }
    } // End method insertFront
    

    
    // Returns true if list is empty, false otherwise
    public boolean isEmpty( )
    {
        return ( head == null );
    }
    
    // Returns the head reference
    public Node getHead( )
    {
        return head;
    }
    
    // Returns the tail reference
    public Node getTail( )
    {
        return tail;
    }
    
    // Inserts a node at the back of the list
    // The data is given, and the node is created 
    // in this method
    public void insertBack( Point newData )
    {
        if ( isEmpty() )
            head = tail = new Node( newData, null );
        else
        {
            Node newNode = new Node( newData, null );
       
            tail.setNext( newNode );
            tail = newNode;
        }
    } // end method insertBack
    
    // Removes the node from the front of the list
    // and returns the data from that node
    public Object removeFront( )
    {
        Object returnData;
   
        if ( isEmpty() )
            return null;
   
        returnData = head.getData();

        if ( head == tail ) // Removing the last node in the list
            head = tail = null;
        else
            head = head.getNext();
   
        return returnData;
    } // end method removeFront
    
    // Removes the node from the back of the list
    // and returns the data from that node
    	public Point get(int index)
	// post: returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
                                        Point temp = new Point(current.getX(), current.getY());
		return temp;
	}

    public Object removeBack( )
    {
        Object returnData;
   
        if ( isEmpty() )
            return null;
   
        returnData = tail.getData();
   
        if ( head == tail ) // Removing last node in the list
            head = tail = null;
        else
        {
            Node previous = head;
       
            // After the while loop, previous will point to the 
            // next to last node (which will become the new tail)
            while ( previous.getNext() != tail )
                previous = previous.getNext();
      
            tail = previous;
            tail.setNext( null );
        }
   
        return returnData;
    } // End method removeBack
    
    // Empties the list
    public void clear()
    {
        head = tail = null;
    } // end method clear
    
    // Returns a string representation of this list in the form:
    // head --> data --> data --> ... --> data --> null
    public String toString()
    {
        String str = "";
        Node current;
   
        current = head;
        str += "head --> ";
   
        while ( current != null )
        {
            str += (current.getData()).toString() + " --> ";
            current = current.getNext();
        }
   
        str += "null";
   
        return str;
    } // End method toString

 
    public int size( )
    {
        int count = 0;
        Node position = head;
        while (position != null)
        {
            count++;
            position = position.getNext();
        }
        return count;
    }

    public boolean contains(Object target)
    {
        return (find(target) != null);
    }

    /**
     Finds the first node containing the target item, and returns a
     reference to that node. If target is not in the list, null is returned.
    */
    private Node find(Object target)
    {
        Node position = head;
        Object dataAtPosition;
        while (position != null)
        {
            dataAtPosition = position.getData();
            if (target.equals(dataAtPosition))
                return position;
            position = position.getNext();
        }
        return null; //target was not found
    }


    public boolean equals(Object otherList)
    {
        if (otherList == null)
            return false;
        else if (getClass( ) != otherList.getClass( ))
            return false;
        else if (size( ) != ((LinkedList)otherList).size( ))
            return false;
        else
            return compareLists((LinkedList)otherList);
    }

    //Precondition: size( ) == otherList.size( ).
    //Returns true if node by node, objects are equal.
    private boolean compareLists(LinkedList otherList)
    {
        boolean match = true;//so far
        Node position = head;
        Node otherPosition = otherList.head;

        while (match && position != null)
        {
              if (!position.getData().equals(otherPosition.getData()) )
              match = false;
              position = position.getNext();
              otherPosition = otherPosition.getNext();
        }
        return match;
    }
    public boolean remove(int index)
	// post: removes the element at the specified position in this list.
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}




    
} // End class LinkedList
   
