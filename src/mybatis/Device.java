package mybatis;

public class Device {
	
	private int id;
	private String no;
	private String type;
	private String ip;
	private int prot;
	private byte state;
	private byte communication;//通信周期
	private boolean scope;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getProt() {
		return prot;
	}
	public void setProt(int prot) {
		this.prot = prot;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	public byte getCommunication() {
		return communication;
	}
	public void setCommunication(byte communication) {
		this.communication = communication;
	}
	public boolean isScope() {
		return scope;
	}
	public void setScope(boolean scope) {
		this.scope = scope;
	}
	@Override
	public String toString() {
		return "Device [id=" + id + ", no=" + no + ", type=" + type + ", ip=" + ip + ", prot=" + prot + ", state="
				+ state + ", communication=" + communication + ", scope=" + scope + "]";
	}
	
  
	
	
}
