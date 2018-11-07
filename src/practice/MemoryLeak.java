package practice;

public class MemoryLeak {
	public class A {
		private B b;
        
		public B getB() {
			return b;
		}

		public void setB(B b) {
			this.b = b;
		}
        
	}

	public class B{
    	private A a;

		public A getA() {
			return a;
		}

		public void setA(A a) {
			this.a = a;
		}
    	
    }
	
	public static void main(String[] args) {
		MemoryLeak memoryLeak=new MemoryLeak();
		memoryLeak.execut();
	}
	
	private void execut() {
		 A a;
		 B b;
		while (true) {
			    a=new A();
			    b=new B();
				a.setB(b);
				//b.setA(a);
				b=null;
				System.out.println(a.getB().getClass().getName());
			
		}
	 
	
    }

}
