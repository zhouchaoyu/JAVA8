package design.mode.bridge;
/**
 * @author xiaoyu
 * 剑 
 * */
public class Sword  implements Weapon{

	@Override
	public void fetchOut() {
		System.out.println("拔出剑");
	}

	@Override
	public void wield() {
	      System.out.println("挥舞剑");
	}

	@Override
	public void callIn() {
		System.out.println("收回剑");
	}
	 
}
