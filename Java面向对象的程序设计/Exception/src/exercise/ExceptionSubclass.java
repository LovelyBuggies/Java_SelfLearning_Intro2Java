package exercise;

import java.util.Random;

public class ExceptionSubclass {
	public static void main(String args[]) {
		a();
	}
	static void a() { 
		try {
			b();
		}
	catch (Exception e) {
		e.printStackTrace();
		}
	}

	static void b() throws ExceptionA { 
		try {
			c();
		}
	catch (ExceptionB e) {
		e.printStackTrace();
		}
	}
	static void c() throws ExceptionA, ExceptionB { 
		Random random = new Random();
		int i = random.nextInt(); 
		if (i % 2 == 0) {
			throw new ExceptionA("We have a problem");
		}
		else {
			throw new ExceptionB("We have a big problem");
		}
	}	
}