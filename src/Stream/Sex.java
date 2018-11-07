package Stream;

public enum Sex {
     man, //男人
     woman;//女人
	@Override
	public String toString() {
		if (this.equals(man)) {
			return "男";
		}
		return "女";
	}
	public static Sex paserToSex(String string) {
		if (string.trim().equals("男")) {
			return man;
		}
		if (string.trim().equals("女")) {
			return woman;
		}
		throw new RuntimeException("解析失败！！");
	}
}
