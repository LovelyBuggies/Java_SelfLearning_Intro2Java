

/**
 * This thread finds the sum of a subsection of an array.
 */
public class SharedCounter extends Thread {

	private int count;

	public SharedCounter(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.count++;
		}
	}

	public int getCount() { return this.count; }

	/**
	 * Sum the elements of an array.
	 * 
	 * @param arr
	 *            array to sum
	 * @return sum of the array's elements
	 * @throws InterruptedException
	 *             shouldn't happen
	 */
	public static int increase() throws InterruptedException {

		int count = 0;

		// Create and start 10 threads.
		SharedCounter[] ts = new SharedCounter[10];

		for (int i = 0; i < 10; i++) {
			ts[i] = new SharedCounter(count);
			ts[i].start();
			ts[i].yield();
			ts[i].sleep(10);
			System.out.println("The " + i + "th thread counts to " + ts[i].getCount());
			count = ts[i].getCount();
		}

		return count;
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("The counter is " + increase());
	}
}