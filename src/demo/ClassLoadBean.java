package demo;

public class ClassLoadBean extends Object {
	static int field = 5;
	static {
		System.out.println("我是静态域" + field);
	}

	static void method() {
		System.out.println("我是静态method" + field);
	}

	public ClassLoadBean() {
		System.out.println("我是构造函数");
	}

	public static ClassLoadBean cLoadBean() {
		return new ClassLoadBean();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("我将要被回收了");
		super.finalize();
	}

}
