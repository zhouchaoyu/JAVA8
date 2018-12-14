package common;

public class Teacher extends Persion{
	private String profession;
	public Teacher() {}
	public Teacher(String name, String idNo) {
		super(name, idNo);
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	@Override
	public void speak(String str) {
		System.out.println("鑱屼笟锛�    "+profession);
	}
	
}
