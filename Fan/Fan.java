
class Fan {
	// three constants
	private final int SLOW = 1;
	private final int MEDIUM = 2;
	private final int FAST = 3;

	// properties
	private int speed;
	private boolean on;
	private double radius;
	private String color;

	// constructor
	public Fan() {
		setSpeed(SLOW);
		setOn(false);
		setRadius(5.0);
		setColor("blue");
	}

	// methods
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public boolean getOn() {
		return this.on;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	// to string
	public String toString() {
		String re;
		if (on) {
			re = "Speed: " + Integer.toString(speed) + "\n";
			re += "Radius: " + Double.toString(radius) + "\n";
			re += "Color: " + color + "\n";
			return re;
		}
		else {
			return "Fan is off.";
		}
	}

	public static void main(String[] args) {
		Fan Dell = new Fan();
		Dell.setOn(true);
		Dell.setSpeed(3);
		Dell.setRadius(10.0);
		Dell.setColor("yellow");

		Fan Green = new Fan();
		Green.setSpeed(2);

		StdOut.println();
		StdOut.println(Dell.toString());
		StdOut.println(Green.toString());
	}
}