

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Circle extends Shape {
	
	public Circle(double radius)
	{
		length = radius;
		numberOfEdge = 0;
	}

	@Override
	synchronized public double computeArea() {
		return Math.PI * length * length;
	}

	@Override
	public String toString() {
		return "Circle with length of radius: " + length;
	}
}
