

public class Rectangle extends Shape {
	private double length2;
	
	public Rectangle(double length1, double length2)
	{
		length = length1;
		this.length2 = length2;
		numberOfEdge = 4;
	}
	
	public void setLength2(double length)
	{
		length2 = length;
	}
	public double getLength2()
	{
		return length2;
	}

	@Override
	synchronized public double computeArea() {
		return length * length2;
	}

	@Override
	public String toString() {
		return "Rectangle with two edges: " + length + ", " + length2;
	}

}
