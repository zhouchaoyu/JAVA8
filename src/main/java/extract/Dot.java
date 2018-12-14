package extract;

import static org.hamcrest.CoreMatchers.instanceOf;

/****
 * ��
 * 
 * ****/
public class Dot {
	/**
	 * a ��ʾ������λ��
	 * ***/
	public double a;
	/****
	 * b ��ʾ����������
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
