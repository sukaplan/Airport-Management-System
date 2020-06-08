package stack;

import java.util.ArrayList;
import java.util.List;

import management.Passenger.Baggage;

public class Stack implements IStack {
	private List<Baggage> contents;

	public Stack() {
		contents = new ArrayList<Baggage>();
	}

	@Override
	public Object peek() throws StackEmpty {

		if (isEmpty())
			throw new StackEmpty();

		return contents.get(contents.size() - 1);
	}

	@Override
	public Object pop() throws StackEmpty {

		if (isEmpty())
			throw new StackEmpty();

		Object retVal = contents.get(contents.size() - 1);

		contents.remove(contents.size() - 1);

		return retVal;
	}

	@Override
	public void push(Object item) {
		contents.add((Baggage)item);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return contents.size() == 0;
	}

	@Override
	public String toString() {
		int size = contents.size();

		String retString = "<" + size + "><top: ";

		for (int i = size - 1; i > 0; i--) {
			retString += contents.get(i) + ", ";
		}

		if (isEmpty())
			retString += contents.get(0);

		return retString;
	}

}
