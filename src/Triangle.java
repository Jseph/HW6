import java.util.Arrays;

public class Triangle extends Shape
{
	Point p1, p2, p3;
	public Triangle(Point p1, Point p2, Point p3)
	{
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	public boolean equals(Shape s)
	{
		if(! (s instanceof Triangle))
			return false;
		Triangle casted = (Triangle) s;
		LineSegment[] l1 = getSides();
		LineSegment[] l2 = casted.getSides();
		for(int rot = 0; rot < 3; rot++)
			for(int dir=-1; dir<2; dir++)
			{
				if(dir==0)
					continue;
				if(l1[0].equals(l2[(3+rot*dir)%3]))
					if(l1[1].equals(l2[(4+rot*dir)%3]))
						if(l1[2].equals(l2[(5+rot*dir)%3]))
							if(l1[0].cross(l1[1])==l2[(3+rot*dir)%3].cross(l2[(4+rot*dir)%3]))
								return true;
			}
		return false;
	}
	private LineSegment[] getSides()
	{
			return new LineSegment[]{new LineSegment(p1, p2), new LineSegment(p2, p3), new LineSegment(p3, p1)};
	}

	@Override
	public double area() 
	{
		LineSegment[] l = getSides();
		return 1.0/2*Math.abs(l[0].cross(l[1]));
	}

	@Override
	public Point position() 
	{
		LineSegment[] l = getSides();
		LineSegment l1 = new LineSegment(p1, l[1].position());
		LineSegment l2 = new LineSegment(p2, l[2].position());
		return l1.getIntersection(l2);
	}
	
	public String toString()
	{
		return "t ("+p1+","+p2+","+p3+")";
	}
}
