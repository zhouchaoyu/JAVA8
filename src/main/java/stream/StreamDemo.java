package stream;

import java.util.Properties;

public class StreamDemo {
	 float a ;
	
	
	
	public final static void main(String[] args) {

		Properties prop = System.getProperties();
        Object object=new Object();
        Object object2=new Object();
        Object objectArray[] =new Object [5];
        Object objecttoArray[][] =new Object [5][10];
		System.out.println(object.getClass().getName());
		System.out.println(object2.getClass().getName());
		
		System.out.println(object.getClass()==object2.getClass());
		System.out.println(objectArray.getClass().getName());
		System.out.println(objecttoArray.getClass().getName());
		Class iintt=int.class;
		StreamDemo streamDemo = new StreamDemo();
		System.out.println(streamDemo.a+1);
		System.out.println(int.class.getName());
		System.out.println(Integer.class.getName());
		System.out.println(int.class==Integer.class);
		System.out.println(short.class.getName());
		System.out.println(void.class.getName());
		prop.keySet().stream().forEach((e) -> {
			System.out.println(e + "------" + prop.get(e));
		});

	}

}
