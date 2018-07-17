package demo;

import java.awt.print.Printable;

public class OuterClass {
	    public void display(){
	        System.out.println("OuterClass...");
	    }
	    
	    interface innerInterface{
		    default void print() {
			    System.out.println("我是内部接口");
		    }
	    }
	    public class InnerClass implements innerInterface{
	        public OuterClass getOuterClass(){
	            return OuterClass.this;
	        }
	    }
	    
	    public static void main(String[] args) {
	        OuterClass outerClass = new OuterClass();
	        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
	        innerClass.getOuterClass().display();
	        innerClass.print();
	    }
	}
