
public class Rectangle extends Shape
{
	Point p1,p2;
	public Rectangle(Point p1, Point p2)
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	@Override
	public double area() 
	{
		return Math.abs(p1.getX()-p2.getX())*Math.abs(p1.getY() - p2.getY());
	}
	@Override
	public Point position() 
	{
		return new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2);
	}
	@Override
	public boolean equals(Shape s) 
	{
		if(!(s instanceof Rectangle))
			return false;
		Rectangle casted = (Rectangle)s;
		if(casted.getHeight() == getHeight() && casted.getWidth() == getWidth())
			return true;
		if(casted.getHeight() == getWidth() && casted.getWidth() == getHeight())
			return true;
		return false;
	}
	public double getWidth()
	{
		return Math.abs(p1.getX() - p2.getX());
	}
	public double getHeight()
	{
		return Math.abs(p1.getY()-p2.getY());
	}
}
