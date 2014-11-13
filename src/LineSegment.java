import java.awt.geom.Point2D;


public class LineSegment extends Shape 
{
	Point p1;
	Point p2;
	
	public LineSegment(Point p1, Point p2) 
	{
		this.p1 = p1;
		this.p2 = p2;
	}
	

	@Override
	public double area() 
	{
		return 0;
	}

	@Override
	public Point position() 
	{
		return new Point((p1.getX()+p2.getX())/2,(p1.getY()+p2.getY())/2);
	}
	public double length()
	{
		return Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2)+Math.pow(p1.getY()-p2.getY(), 2));
	}

	@Override
	public boolean equals(Shape s) {
		if(!(s instanceof LineSegment))
			return false;
		LineSegment casted = (LineSegment) s;
		return casted.length() == length();
	}
	public double cross(LineSegment s)
	{
		double x1 = p2.getX() - p1.getX();
		double y1 = p2.getY() - p1.getY();
		double x2 = s.p2.getX() - s.p1.getX();
		double y2 = s.p2.getY() - s.p1.getY();
		return x1*y2 - x2*y1;
	}
	public String toString()
	{
		return "l ("+p1+","+p2+")";
	}
	public Point getIntersection(LineSegment l)
	{
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		double x3 = l.p1.getX();
		double y3 = l.p1.getY();
		double x4 = l.p2.getX();
		double y4 = l.p2.getY();
		double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
	    if (d == 0) return null;//They are parallel
	    double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
	    double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;
	    //Check if point is on both lines
	    if((xi-x1)*(x2-x1)+(yi-y1)*(y2-y1)<0)
	    	return null;
	    if((x2-xi)*(x2-x1)+(y2-yi)*(y2-y1)<0)
	    	return null;
	    if((xi-x3)*(x4-x3)+(yi-y3)*(y4-y3)<0)
	    	return null;
	    if((x4-xi)*(x4-x3)+(y4-yi)*(y4-y3)<0)
	    	return null;
	    return new Point(xi,yi);
	}
}
