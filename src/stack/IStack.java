package stack;

public interface IStack {

	Object peek() throws StackEmpty;

	Object pop() throws StackEmpty;

	void push(Object item);

	boolean isEmpty();
	
}