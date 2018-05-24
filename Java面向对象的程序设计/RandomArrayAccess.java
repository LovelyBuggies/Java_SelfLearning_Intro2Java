
class MyArrayIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
	public MyArrayIndexOutOfBoundsException() {
		super("MyArrayIndexOutOfBoundsException occurs.");
		System.out.println("MyArrayIndexOutOfBoundsException constructed.");
	}
	
}

class RandomArrayAccess {
	public static void main(String[] args) {
		int[] r = new int[100];
		for (int i = 0; i < 100; i++) {
			r[i] = (int)(100 * Math.random());
		}
		int index = Integer.parseInt(args[0]);
		try {
			if (index >= 0 && index < 100) {
				System.out.println("random[" + index + "] = " + r[index]);
			}
			else throw new MyArrayIndexOutOfBoundsException();
		}
		catch (MyArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}