
public class Main 
{
	public static void main(String[] args)
	{
		Triangle t1 = new Triangle(new Point(0,0), new Point(1,0), new Point(0,1));
		System.out.println(t1);
		System.out.println(t1.area());
		System.out.println(t1.position());
		Triangle t2 = new Triangle(new Point(0,0), new Point(1,0), new Point(100,20));
		System.out.println(t2.equals(t1));
		System.out.println(t2.equals(t2));
		Triangle t3 = new Triangle(new Point(1,1), new Point(2,1), new Point(1,2));
		System.out.println(t1.equals(t3));
		Triangle t4 = new Triangle(new Point(-1,0), new Point(0,0), new Point(0,1));
		System.out.println(t1.equals(t4));
		Triangle t5 = new Triangle(new Point(0,0), new Point(0,1), new Point(600,0));
		Triangle t6 = new Triangle(new Point(0,0), new Point(0,-1), new Point(600,0));
		System.out.println(t5.equals(t6));
	}
}
