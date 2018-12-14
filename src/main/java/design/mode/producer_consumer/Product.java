package design.mode.producer_consumer;
/**
 * 
 * 产品
 * @author Administrator
 * **/
public class Product {
    private static int id=0;//产品序列号
    private int no;//产品实例编号
    public Product() {
		 no=this.id++;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "产品------"+no;
	}
	
}
