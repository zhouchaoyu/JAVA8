package demo;

public class ClassLoader {
	
	public static void main(String[] args) {
		ClassLoadBean cLoadBean=ClassLoadBean.cLoadBean();
		 System.out.println("我是静态字段："+cLoadBean);
		 //System.out.println(ClassLoader.class.getClassLoader());
		
	}
}
