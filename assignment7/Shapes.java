

import java.util.ArrayList;
import java.util.Iterator;

public class Shapes 
{
	ArrayList<? super Shape> shapeList;
	
	public Shapes()
	{
		shapeList = new ArrayList<>();
	}
	
	public int getSize()
	{
		return shapeList.size();
	}
	public void add(Shape s)
	{
		shapeList.add(s);
	}
	public void remove(Shape s)
	{
		shapeList.remove(s);
	}
	public Shape getElement(int index)
	{
		return (Shape) shapeList.get(index);
	}
	
	public void compute()
	{
		for (Object s: shapeList)
		{
			new Thread() 
			{
				public void run() 
				{
					Shape sh = (Shape)s;
					String result = sh.toString();
					result += " Area: " + (Math.round(sh.computeArea() * 10)) / 10.0;
					System.out.println(result);
				}
			}.start();	
		}
	}
	
	
	
	public Shape max()
	{
		Shape s = new Shape() {
			@Override
			public double computeArea() {
				return 0;
			}
			@Override
			public String toString() {
				return null;
			}};
			
		double areaBiggest = 0;
		for (Object ob: shapeList)
		{
			double area = ((Shape)ob).computeArea();
			if (area > areaBiggest)
			{
				areaBiggest = area;
				s = (Shape)ob;
			}
		}
		return s;
	}
	
	public Shape min()
	{
		Shape s = new Shape() {
			@Override
			public double computeArea() {
				return 0;
			}
			@Override
			public String toString() {
				return null;
			}};
			
		double areaSmallest = 999999999999.0;
		for (Object ob: shapeList)
		{
			double area = ((Shape)ob).computeArea();
			if (area < areaSmallest)
			{
				areaSmallest = area;
				s = (Shape)ob;
			}
		}
		return s;
	}

}
