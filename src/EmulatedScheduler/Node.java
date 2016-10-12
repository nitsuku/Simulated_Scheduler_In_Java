package EmulatedScheduler;

/*
 * Class designed to hold a process
 * and a link to the next node
 * to be iterated through
 * 
 * @Author:  Nick Faccenda
 * @Version: 1.0
 * @Date:    10/10/2016
 * 
 */
public class Node {
	private Process process;
	private Node next;
	
	/*
	 * Default constructor
	 */
	public Node()
	{
		process = null;
		next = this;
	}
	
	/*
	 * Constructor
	 * @param Process process  process to
	 * 	be inserted in this node
	 */
	public Node(Process process)
	{
		this.process = process;
		this.next = null;
	}
	
	/*
	 * Constructor
	 * @param Process process  process to
	 * 	be inserted in this node
	 * @param Node next  
	 */
	public Node(Process process, Node next)
	{
		this.process = process;
		this.next = next;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public Process getProcess()
	{
		return process;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public void setProcess(Process process)
	{
		this.process = process;
	}
}
