package design.mode.bridge;
/***
 * @author xiaoyu
 * 桥接设计模式： 将抽象（abstraction）与它的实现(implementation)解耦，使两者可以独立变化。
     我们有武器  weapon，魔法magic  两个事物，想要武器通过动态的传入魔法实现  动态的魔法功能；
     
 * **/
public class BootStarp {
    public static void main(String[] args) {
		MagicSword magicSword=new MagicSword();
		magicSword.setMagic(new FlyingMagic());
    	magicSword.fetchOut();
    	magicSword.wield();
    	magicSword.callIn();
    	
    	
	}     
	
}
