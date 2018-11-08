package design.mode.bridge;
/*****
 * @author xiaoyu
 * 有魔法的剑
 * **/
public class MagicSword extends Sword implements MagicWepon{
    
	private Magic magic;
	@Override
	public void setMagic(Magic magic) {
	      this.magic=magic;
	}

	@Override
	public void callIn() {
		// TODO Auto-generated method stub
		super.callIn();
	}
	@Override
	public void fetchOut() {
		super.fetchOut();
	}@Override
	public void wield() {
		super.wield();
		magic.conjure();
	}

}
