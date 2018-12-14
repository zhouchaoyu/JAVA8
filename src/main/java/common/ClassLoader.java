package common;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClassLoader {
	
	public static void main(String[] args) {
	    PriorityQueue<Integer>  queue=new PriorityQueue<>(
	    		new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}

			
		});
	    
	    queue.add(1);
	    queue.add(2);
	    queue.add(3);
	    queue.add(2);
	    queue.add(-1);
	    System.out.println("size"+queue.toString());
	    while (!queue.isEmpty()) {
	    	  System.out.println(queue.poll()+"-------" +queue.size());  
			
		}
	    System.out.println(queue.poll());
		System.out.println('a'+'b');
	}
}
