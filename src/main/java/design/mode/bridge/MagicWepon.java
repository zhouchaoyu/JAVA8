package design.mode.bridge;

/**
 * @author xiaoyu 桥接 魔法与武器接口   桥接接口
 ***/
public interface MagicWepon extends Weapon {

	void setMagic(Magic magic);

}
