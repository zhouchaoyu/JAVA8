package common;

public class ClassLoadBean extends Object {
	static int field = 5;
	static {
		System.out.println("鎴戞槸闈欐�佸煙" + field);
	}

	static void method() {
		System.out.println("鎴戞槸闈欐�乵ethod" + field);
	}

	public ClassLoadBean() {
		System.out.println("鎴戞槸鏋勯�犲嚱鏁�");
	}

	public static ClassLoadBean cLoadBean() {
		return new ClassLoadBean();
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("鎴戝皢瑕佽鍥炴敹浜�");
		super.finalize();
	}

}
