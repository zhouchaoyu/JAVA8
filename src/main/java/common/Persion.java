package common;
 
public   class Persion implements Speakable, PersionSetter{
	private String name;
	private String sex;
	private Integer age;
	private String idNo;
	
	public Persion(){
		
	}
	public Persion(String name, String idNo) {
		super();
		this.name = name;
		this.idNo = idNo;
	}
	private Boolean isMerried;
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see practice.PersionSetter#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	/* (non-Javadoc)
	 * @see practice.PersionSetter#setSex(java.lang.String)
	 */
	@Override
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}
	
	/* (non-Javadoc)
	 * @see practice.PersionSetter#setAge(java.lang.Integer)
	 */
	@Override
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getIdNo() {
		return idNo;
	}
	/* (non-Javadoc)
	 * @see practice.PersionSetter#setIdNo(java.lang.String)
	 */
	@Override
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public boolean isMerried() {
		return isMerried;
	}
	/* (non-Javadoc)
	 * @see practice.PersionSetter#setMerried(boolean)
	 */
	@Override
	public void setMerried(boolean isMerried) {
		this.isMerried = isMerried;
	}
	@Override
	public void speak(String str) {
		// TODO Auto-generated method stub
		
	}


}
