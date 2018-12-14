package extract;

public class Test {
	
	public static void main(String[] args) {
		Dot dot1 = new Dot(0,0);
		Dot dot2 = new Dot(1,1);
		Dot dot3 = new Dot(1,0);
		Dot dot4 = new Dot(1,5);
		Line lineA = new Line(dot1,dot2);
		Line lineB = new Line(dot3,dot4);
		System.out.println(lineA.getCrosspoint(lineB));
	}
	
}
