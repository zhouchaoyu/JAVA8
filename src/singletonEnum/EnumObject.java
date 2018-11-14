package singletonEnum;

public enum EnumObject {
	instance01;
	private EnumObject() {
		System.out.println("我打印了");
	}

	public static void main(String[] args) {
    }
}
