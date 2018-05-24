
class UnsafeCounter extends Thread {
   
   	private int count;

   	public UnsafeCounter(int count) {
   		this.count = count;
   	}

    public void increment() {
		count++;
    }

    public int get() {
		return count;
    }
}

public class UnsafeCounterDemo extends Thread {

   	public static void main(String[] args) {
		UnsafeCounter uc = new UnsafeCounter(0);
		UnsafeCounter uc_rf = uc;
   		for (int i = 0; i < 1000000; i++) {
   			uc.increment();
   			uc_rf.increment();
   		}
   		System.out.println(uc.get());
   	}
}
