/*
 * Written by Alexa Adams
 */

public interface QueueI<T> 	//blueprint for LLQueue class
{
	//add an element to the end of the queue
	void enqueue(T data);
	//removes and returns the element at the front of the queue, returns null if empty
	T dequeue();
	//return the element at the front of the queue without removing it, returns null if empty
	T peek();
	//prints the elements in the queue
	void print();
}
