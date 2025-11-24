/*
 * Written by Alexa Adams
 */

public class LLQueue<T> implements QueueI<T>
{
	private static class Node<D>	//internal class
	{
		D data;
		Node<D> link;
		
		public Node()	//default
		{
			data = null;
			link = null;
		}
		
		public Node(D data)	//overloaded
		{
			this.data = data;
			this.link = null;
		}
	}
	
	private Node<T> head; //front of queue
	private Node<T> tail;	//back of queue
	
	public LLQueue()	//default
	{
		head = null;
		tail = null;
	}
	
	public void enqueue(T data)	//adds node to back of queue
	{
		Node<T> newNode = new Node<>(data);
		if(tail == null)	//empty queue
		{
			head = newNode;
			tail = newNode;
		}
		else
		{
			tail.link = newNode;
			tail = newNode;
		}
	}
	
	public T dequeue()	//removes first element of queue and returns the data
	{
		if(head == null)
			return null;
		
		T element = head.data;
		head = head.link;
		
		if(head == null)	//became empty queue
			tail = null;
		
		return element;
	}
	
	public T peek()	//returns data of the first element in the queue without removing it
	{
		if(head == null)
			return null;
		else
			return head.data;
	}
	
	public void print()	//prints the queue front to back
	{
		Node<T> current = head;
		while(current != null)
		{
			System.out.println(current.data);
			current = current.link;
		}
	}
}
