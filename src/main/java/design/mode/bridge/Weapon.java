package design.mode.bridge;
/***
 * 武器接口    
 *     
 *      
 *      * ***/
public interface Weapon {
	   
	/**拿出武器**/
	void fetchOut();
	/**使用武器***/
	void wield();
	/** 收回武器**/
	void callIn(); 
    
	   
}
