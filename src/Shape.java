
public abstract class Shape implements Comparable<Shape>
{
	public abstract double area();
	public abstract Point position();
	public abstract boolean equals(Shape s);
	public int compareTo(Shape s)
	{
		return (area()>s.area())?1:(area()==s.area())?0:-1;
	}
}
