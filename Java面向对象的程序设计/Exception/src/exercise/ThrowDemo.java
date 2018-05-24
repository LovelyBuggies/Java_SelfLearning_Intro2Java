package exercise;

public class ThrowDemo {
	 public static void main(String args[]){
		 try {
			 System.out.println("Before a"); 
			 a();
			 System.out.println("After a");
		 }
		 catch (ArithmeticException e) { 
			 System.out.println("main: " + e);
		 }
		 finally {
			 System.out.println("main: finally");
		 }
	 }
	public static void a() { 
		try {
			System.out.println("Before b"); 
			b();
			System.out.println("After b");
		}
		catch (ArithmeticException e) { 
			System.out.println("a: " + e);
		}
		finally {
			System.out.println("a: finally");
		}
	}
	public static void b() { 
		try {
			System.out.println("Before c");
			c();
		}
		catch (ArithmeticException e) { 
			System.out.println("b: " + e);
		}
		finally {
			System.out.println("b: finally");
		}
	}
	public static void c() { 
		try {
			System.out.println("Before d");
			d();
			System.out.println("After d");
		}
		catch (ArithmeticException e) { 
			System.out.println("c: " + e); throw e;
		}
		finally {
			System.out.println("c: finally");
		}
	}
	public static void d() {
		try {
			int i = 1; 
			int j = 0;
			System.out.println("Before division");
			System.out.println(i / j); 
			System.out.println("After division");
		}
		catch (ArithmeticException e) {
			System.out.println("d: " + e);
			throw e;
		}
		finally {
			System.out.println("d: finally");
		}
	}
}
