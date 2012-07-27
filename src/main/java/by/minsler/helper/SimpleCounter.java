package by.minsler.helper;

public class SimpleCounter {

	private int count;

	public synchronized int getCount() {
		count++;
		return count;
	}

}
