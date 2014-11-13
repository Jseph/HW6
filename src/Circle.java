
public class Circle extends Shape 
{
	Point p;
	double r;
	public Circle(Point p, double r)
	{
		this.p = p;
		this.r = r;
	}
	@Override
	public double area() 
	{
		return Math.PI*Math.pow(r, 2);
	}
	@Override
	public Point position() 
	{
		return p;
	}
	@Override
	public boolean equals(Shape s) 
	{
		if(!(s instanceof Circle))
			return false;
		Circle casted = (Circle) s;
		return casted.r == r;
	}
}
