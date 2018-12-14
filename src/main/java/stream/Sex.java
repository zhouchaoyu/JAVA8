package stream;

public enum Sex {
     man, //鐢蜂汉
     woman;//濂充汉
	@Override
	public String toString() {
		if (this.equals(man)) {
			return "鐢�";
		}
		return "濂�";
	}
	public static Sex paserToSex(String string) {
		if (string.trim().equals("鐢�")) {
			return man;
		}
		if (string.trim().equals("濂�")) {
			return woman;
		}
		throw new RuntimeException("瑙ｆ瀽澶辫触锛侊紒");
	}
}
