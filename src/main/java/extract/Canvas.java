package extract;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Canvas {
	private List<Line>  lines;

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}   
	
	public List<Dot> getDots(){
		List<Dot> dots=new ArrayList<>();
		if (lines!=null&&!lines.isEmpty()) {
			for (Iterator<Line> iterator = lines.iterator(); iterator.hasNext();) {
				Line line= (Line) iterator.next();
				
			}
		}
		return dots;
	}
	
	/*****
	 * 获取交点
	 * ****/
	public List<Dot> getDot(Line line) {
		if (lines!=null&&!lines.isEmpty()) {
			for (Iterator<Line> iterator = lines.iterator(); iterator.hasNext();) {
				Line lineA= (Line) iterator.next();
				if (lineA.isCross(line)) {
					
				}
				
			}
		}
		return null;
	}
}
