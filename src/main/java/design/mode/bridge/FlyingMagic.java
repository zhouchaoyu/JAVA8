package design.mode.bridge;
/**
 * @author xiaoyu
 * 飞行魔法
 * 
 * **/
public class FlyingMagic  implements Magic{

	@Override
	public void conjure() {
		System.out.println("施法成功--------飞行中");
	}

}
