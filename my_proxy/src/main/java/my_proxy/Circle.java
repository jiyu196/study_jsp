package my_proxy;

public class Circle {
	double r;

	public Circle(double r) {
		super();
		this.r = r;
	}

	Circle area() {
		System.out.println(3.14 * r * r);
		return this;
	}
	
	Circle round() {
		System.out.println(3.14 * r * 2);
		return this;
	}
	Circle setR(double r) {
		this.r = r;
		return this;
	}
	
}
