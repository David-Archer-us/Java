
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ShapeTest {

	public static void main(String[] args) {
		Shapes shapes = new Shapes();
		Triangle t1 = new Triangle(3);
		Triangle t2 = new Triangle(4);
		Circle c1 = new Circle(5);
		Circle c2 = new Circle(6);
		Rectangle r1 = new Rectangle(7, 8);
		Rectangle r2 = new Rectangle(9, 10);
		Hexagon h1 = new Hexagon(11);
		Hexagon h2 = new Hexagon(12);
		shapes.add(t1);
		shapes.add(t2);
		shapes.add(c1);
		shapes.add(c2);
		shapes.add(r1);
		shapes.add(r2);
		shapes.add(h1);
		shapes.add(h2);
		
		shapes.compute();
		
		System.out.println("Max: " + shapes.max().toString());
		System.out.println("Min: " + shapes.min().toString());
		
		for (int i = 0; i < shapes.getSize(); i++)
		{
			String fileName = "obj" + (i+1) + ".ser";
			shapes.getElement(i).serialize(fileName);
		}
		
		try
		{
			FileInputStream fi = new FileInputStream("obj3.ser");
			ObjectInputStream oi = new ObjectInputStream(fi);
			Shape s = (Shape)oi.readObject();
			oi.close();
			fi.close();
			System.out.println("An example of deserialization: " + s.toString());
		}
		catch (IOException | ClassNotFoundException e)
		{
			System.out.println(e);
		}
		
	}

}
