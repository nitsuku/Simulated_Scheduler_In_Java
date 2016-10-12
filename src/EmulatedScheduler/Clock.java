package EmulatedScheduler;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;


/*
 * Clock class to store Nodes that will
 * be used as a circular linked list.
 * Has a Node named head that shows the first item in
 * the 'queue'
 * Has a Node named tail that shows the last item in
 * the 'queue'
 * Has an int named elements that tells you how many
 * items are in the 'queue'
 * 
 * @Author:  Nick Faccenda
 * @Version: 1.0
 * @Date:    10/10/2016
 */
public class Clock<Process> implements Queue<Process> {

	private Node head;
	private Node tail;
	private int elements;

	/*
	 * Default Constructor
	 */
	public Clock()
	{
		
		head = null;
		tail = null;
		elements = 0;
	}
	
	/*
	 * @Param Object arg0 a process to be added to the end
	 * of the Clock
	 */
	@Override
	public boolean offer(Process arg0) {
		elements++;
		Node toAdd = new Node((EmulatedScheduler.Process) arg0);
		if(head == null)//if list is empty
		{
			head = toAdd;
			tail = toAdd;
			head.setNext(tail);
			tail.setNext(head);
		}
		else
		{
			tail.setNext(toAdd);
			tail = tail.getNext();
			tail.setNext(head);
		}
		return true;
	}

	/*
	 * 
	 * Removes the head Node,
	 * sets the second node as the new head
	 * reassigns the tail's next to be the
	 * new head.
	 * 
	 * @Returns process removed or null if list was empty
	 */
	public Process remove() {
		if(elements > 1)
		{
			Node temp = head;
			head = head.getNext();
			tail.setNext(head);
			elements--;
			//System.out.println(elements);
			return (Process) temp.getProcess();
		}
		else // list is now empty
		{
			tail = null;
			head = null;
			elements = 0;
			return null;
		}
	}

	@Override
	public boolean removeAll(Collection arg0) {
		this.head = null;
		elements = 0;
		return true;
		
	}

	@Override
	public boolean add(Object arg0) {
		elements++;
		if(head == null)
		{
			head = (Node) arg0;
		}
		else
		{
			tail.setNext((Node) arg0);
			tail = tail.getNext();
			tail.setNext(head);
		}
		return true;
	}

	/*
	 * @returns head
	 */
	public Node getHead()
	{
		return head;
	}

	/*
	 * @returns tail
	 */
	public Node getTail()
	{
		return tail;
	}
	/*
	 * looks at head to see if list is
	 * 	empty or not
	 * @returns false if not empty
	 * @returns true if empty
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	/*
	 * returns how many elements are in the 
	 * collection
	 * @return int elements
	 */
	public int getElements()
	{
		return elements;
	}

	@Override
	public Process element() {
		return (Process) head.getProcess();
	}

	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
	/*
	 * 
	 * Not a used process
	 */
	@Override
	public boolean remove(Object arg0) {
		if(elements > 1)
		{
			head = head.getNext();
			tail.setNext(head);
			elements--;
			System.out.println(elements);
			return true;
		}
		else
		{
			tail = null;
			head = null;
			elements = 0;
			System.out.println("ele reset to 0");
			return true;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return elements;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Process peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Process poll() {
		// TODO Auto-generated method stub
		return null;
	}

}
