
class NumberFormatException extends Exception {
	public final char name;
	public NumberFormatException(char name) {
		super("NumberFormatException occurred.");
		this.name = name;
		System.out.println(name + " isn't a valid bin2Dec char.");
	}
}

/*
 * TryCatch Exception
 */
class bin2Dec {
	public static void main(String[] args) {
		String str = args[0];
		try {
			int n = str.length();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (str.charAt(i) != '0' && str.charAt(i) != '1') 
					throw new NumberFormatException(str.charAt(i));
				sum += (int)(str.charAt(i) - '0') * Math.pow(2, n - 1 - i);
			}
			System.out.println("bin2Dec: " + sum);
		}
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}

/*
 * ThrowsMethod
 */

class bin2Dec {
	public static void main(String[] args) throws NumberFormatException{
		String str = args[0];
		int n = str.length();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) != '0' && str.charAt(i) != '1') 
				throw new NumberFormatException(str.charAt(i));
			sum += (int)(str.charAt(i) - '0') * Math.pow(2, n - 1 - i);
		}
		System.out.println("bin2Dec: " + sum);
	}
}