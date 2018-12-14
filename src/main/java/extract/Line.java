package extract;

import static java.lang.Math.*;

/*****
 *     线
 * *****/
public class Line {
	public Dot startDot;
	public Dot endDot;
	
	public Line(Dot startDot, Dot endDot) {
		super();
		this.startDot = startDot;
		this.endDot = endDot;
	}

	
	/****
	 * 是否相交
	 * ****/
	public boolean isCross(Line line) {
		if (min(this.startDot.a,this.endDot.a)<=max(line.startDot.a,line.endDot.a)
			&& min(line.startDot.b,line.endDot.b)<= max(this.startDot.b,this.endDot.b)
			&& min(line.endDot.a,line.startDot.a)<= max(this.startDot.a,this.endDot.a)
			&& min(this.startDot.b,this.endDot.b)<= max(line.startDot.b,line.endDot.b))
		{
			return true;
		}
		
		return false;
	}
	
	/***
	 * 得到相交点
	 * ***/
	public Dot getCrosspoint(Line line) {
		if (this.isCross(line)) {
			double a = ((this.startDot.a - this.endDot.a) * (line.startDot.a * line.endDot.b - line.endDot.a * line.startDot.b) - (line.startDot.a - line.endDot.a) * (this.startDot.a * this.endDot.b - this.endDot.a * this.startDot.b))  
				    / ((line.startDot.a - line.endDot.a) * (this.startDot.b - this.endDot.b) - (this.startDot.a - this.endDot.a) * (line.startDot.b - line.endDot.b));  
				  
				double b = ((this.startDot.b - this.endDot.b) * (line.startDot.a * line.endDot.b - line.endDot.a * line.startDot.b) - (this.startDot.a * this.endDot.b - this.endDot.a * this.startDot.b) * (line.startDot.b - line.endDot.b))  
				    / ((this.startDot.b - this.endDot.b) * (line.startDot.a - line.endDot.a) - (this.startDot.a - this.endDot.a) * (line.startDot.b - line.endDot.b)); 
			return new Dot(a, b);
		}
		return null;
	}
	@Override
	public String toString() {
		return "Line [startDot=" + startDot + ", endDot=" + endDot + "]";
	}
	
	
	
}
