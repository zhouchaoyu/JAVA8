package singletonEnum;

public class ADCacheManager {
	private  static  ADCacheManager instance;
	private ADCacheManager() {}
	private  enum Factory {
		Instacnce;
		private Factory() {
			if (instance==null) {
				instance=new ADCacheManager();
			}
		}
		ADCacheManager getADCacheManager() {
			return instance;
		}
	}
	
	public static  ADCacheManager getADCacheManager() {
		return Factory.Instacnce.getADCacheManager();
	}
	
	
}