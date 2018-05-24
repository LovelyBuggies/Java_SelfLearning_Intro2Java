
class Circle2D {
	private double x, y, radius;
	
	public double getX() { return x; }
	public double getY() { return y; }
	public double getRadius() { return radius; }

	public Circle2D() {
		x = 0.0;
		y = 0.0;
		radius = 1.0;
	}
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public double getArea() { return Math.PI * radius * radius; }
	public double getPerimeter() { return Math.PI * 2.0 * radius; }
	public boolean contains(double x, double y) {
		return (x * x + y * y) < (radius * radius);
	}
	private double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	public boolean contains(Circle2D other) {
		double d = dist(other.getX(), other.getY(), this.getX(), this.getY());
		return (d + other.getRadius()) < this.getRadius();
	}
	public boolean disjoint(Circle2D other) {
		double d = dist(other.getX(), other.getY(), this.getX(), this.getY());
		return d > (other.getRadius() + this.getRadius());
	}
	public boolean overlaps(Circle2D other) {
		return !(this.disjoint(other) || this.contains(other));
	}

	public static void main(String[] args) {
		System.out.println("*********** Circle2D ************");
		Circle2D c1 = new Circle2D(2, 2, 5.5);
		System.out.println("Area: " + c1.getArea());
		System.out.println("Perimeter: " + c1.getPerimeter());
		System.out.println("Contains(3, 3) : " + c1.contains(3.0, 3.0));
		System.out.println("Contains(4, 5, 10.5) : " + c1.contains(new Circle2D(4, 5, 10.5)));
		System.out.println("Overlaps(3, 5, 2.3) : " + c1.overlaps(new Circle2D(3, 5, 2.3)));
		System.out.println("*********************************");
	}
}