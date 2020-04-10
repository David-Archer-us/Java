

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Math;

public abstract class Shape implements Serializable {
	
	protected double length;
	protected int numberOfEdge;
	
	public void setLength(double dLengthOfEdge)
	{
		length = dLengthOfEdge;
	}
	public void setNumberOfEdge(int iNumberOfEdge)
	{
		numberOfEdge = iNumberOfEdge;
	}
	public double getLengthOfEdge()
	{
		return length;
	}
	public int getNumberOfEdge()
	{
		return numberOfEdge;
	}
	
	public void serialize(String fileName)
	{
		try
		{
			FileOutputStream so = new FileOutputStream(fileName);
			ObjectOutputStream oo = new ObjectOutputStream(so);
			oo.writeObject(this);
			oo.close();
			so.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public abstract double computeArea();
	public abstract String toString();

}
