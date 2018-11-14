package ClassLoader;

import demo.ClassLoadBean;

public class ClassLoaderDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoadBean cla=ClassLoadBean.cLoadBean();
		System.out.println(String.class.getClassLoader());
		System.out.println(cla.getClass().getClassLoader());
		System.out.println(ClassLoaderDemo.class.getClassLoader());
		System.out.println(ClassLoaderDemo.class.hashCode());
		System.out.println(ClassLoaderDemo.class.getClassLoader().loadClass(ClassLoaderDemo.class.getName()).hashCode());
		
		
		
		
	}
	
	
	
	
	
	
}
