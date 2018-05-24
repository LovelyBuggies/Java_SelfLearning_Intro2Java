

/**
 * This thread is the ReverseHello using recursive.
 */
public class ReverseHello extends Thread {

	private int index;
	private ReverseHello next;

	public ReverseHello(int index) {
		this.index = index;
	}

	@Override
	public void run() {
		if (index < 1) return;
		System.out.println(this);
		next = new ReverseHello(--index);
		next.start();
	}

	/**
	 * Turn class to String
	 * 
	 * @return the string of this thread
	 */
	public String toString() {
		return "Hello from Thread <" + index + ">!";
	}

	public static void main(String[] args) throws InterruptedException {
		ReverseHello test = new ReverseHello(50);
		test.start();
	}
}