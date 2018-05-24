
class Counter extends Thread {
   
   	private int count;

   	public Counter(int count) {
   		this.count = count;
   	}

    public void increment() {
		  count++;
    }

    public int get() {
		  return count;
    }
}

public class CounterDemo extends Thread {

   	public static void main(String[] args) {
		  Counter uc1 = new Counter(0);
   		for (int i = 0; i < 1000000; i++) {
   			uc1.increment();
   	  }
      Counter uc2 = new Counter(uc1.get());
      for (int i = 0; i < 1000000; i++) {
        uc2.increment();
      }
   		System.out.println(uc2.get());
   	}
}
