

public class Hexagon extends Shape {
	
	public Hexagon(double dLength)
	{
		length = dLength;
		numberOfEdge = 8;
	}

	@Override
	synchronized public double computeArea() {
		return (3 * Math.sqrt(3) * length * length) / 2;
	}

	@Override
	public String toString() {
		return "Hexagon with length of edge: " + length;
	}

}
