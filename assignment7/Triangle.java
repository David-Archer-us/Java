

public class Triangle extends Shape {

	public Triangle(double dLength) {
		length = dLength;
		numberOfEdge = 3;
	}

	@Override
	synchronized public double computeArea() {
		return (Math.sqrt(3) * length) / 4;
	}

	@Override
	public String toString() {
		return "Triangle with length of edge: " + length;
	}

}
