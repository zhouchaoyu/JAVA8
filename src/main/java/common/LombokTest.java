package common;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public class LombokTest {
	private String parmId="鎴戞槸鍙傛暟";
	private String string="鎴戞槸鍙傛暟浜�";
	public static void main(String[] args) {
		log.error("lombook run");
		LombokTest test = new LombokTest();
		log.error(test.getParmId());
		log.error(test.toString());
		//log.info(test.getName(null));
		
		System.out.println(test.equals(null));
	}
	
	//鎴愬憳鏂规硶鍙傛暟鍔犱笂@NonNull娉ㄨВ
	public String getName(@NonNull String str){
	    return str;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Object) {
			return true;
		}
		return false;
	}
}
