package extract;

import static org.hamcrest.CoreMatchers.instanceOf;

/****
 * 点
 * 
 * ****/
public class Dot {
	/**
	 * a 表示横坐标位置
	 * ***/
	public double a;
	/****
	 * b 表示纵坐标区域
	 * ****/
	public double b;
	public Dot(double a,double b) {
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "Dot [a=" + a + ", b=" + b + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dot) {
			Dot dot=(Dot) obj;
			return this.a==dot.a&&this.b==dot.b;
		}
		return false;
	}
	
	
}
