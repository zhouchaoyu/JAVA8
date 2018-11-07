package Stream;

import java.util.Date;

public class Persion {

	private String   name;
	private Sex   sex;
	private String no;
	private Date brithyDay;
	
	public Persion(String name, Sex sex, String no, Date brithyDay) {
		super();
		this.name = name;
		this.sex = sex;
		this.no = no;
		this.brithyDay = brithyDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Date getBrithyDay() {
		return brithyDay;
	}
	public void setBrithyDay(Date brithyDay) {
		this.brithyDay = brithyDay;
	}
	@Override
	public String toString() {
		return "Persion [name=" + name + ", sex=" + sex + ", no=" + no + ", brithyDay=" + brithyDay + "]";
	}
	
	
}
