package stream;

import java.util.HashMap;

/**
 * 
 *  java  浣嶈繍绠�
 *  
 * **/
public class BitOperation {

		public static void main(String[] args) {
			// 1銆佸乏绉�( << )
			// 0000 0000 0000 0000 0000 0000 0000 0101 鐒跺悗宸︾Щ2浣嶅悗锛屼綆浣嶈ˉ0锛�//
			// 0000 0000 0000 0000 0000 0000 0001 0100 鎹㈢畻鎴�10杩涘埗涓�20
			System.out.println(5 << 2);// 杩愯缁撴灉鏄�20
	 
			// 2銆佸彸绉�( >> ) 楂樹綅琛ョ鍙蜂綅
			// 0000 0000 0000 0000 0000 0000 0000 0101 鐒跺悗鍙崇Щ2浣嶏紝楂樹綅琛�0锛�
			// 0000 0000 0000 0000 0000 0000 0000 0001
			System.out.println(5 >> 2);// 杩愯缁撴灉鏄�1
	 
			// 3銆佹棤绗﹀彿鍙崇Щ( >>> ) 楂樹綅琛�0
			// 渚嬪 -5鎹㈢畻鎴愪簩杩涘埗鍚庝负锛�0101 鍙栧弽鍔�1涓�1011
			// 1111 1111 1111 1111 1111 1111 1111 1011
			// 鎴戜滑鍒嗗埆瀵�5杩涜鍙崇Щ3浣嶃�� -5杩涜鍙崇Щ3浣嶅拰鏃犵鍙峰彸绉�3浣嶏細
			System.out.println(5 >> 3);// 缁撴灉鏄�0
			System.out.println(-5 >> 3);// 缁撴灉鏄�-1
			System.out.println(-5 >>> 3);// 缁撴灉鏄�536870911
	 
			// 4銆佷綅涓�( & )
			// 浣嶄笌锛氱涓�涓搷浣滄暟鐨勭殑绗琻浣嶄簬绗簩涓搷浣滄暟鐨勭n浣嶅鏋滈兘鏄�1锛岄偅涔堢粨鏋滅殑绗琻涓轰篃涓�1锛屽惁鍒欎负0
			System.out.println(5 & 3);// 缁撴灉涓�1
			System.out.println(4 & 1);// 缁撴灉涓�0
	 
			// 5銆佷綅鎴�( | )
			// 绗竴涓搷浣滄暟鐨勭殑绗琻浣嶄簬绗簩涓搷浣滄暟鐨勭n浣� 鍙鏈変竴涓槸1锛岄偅涔堢粨鏋滅殑绗琻涓轰篃涓�1锛屽惁鍒欎负0
			System.out.println(5 | 3);// 缁撴灉涓�7
	 
			// 6銆佷綅寮傛垨( ^ )
			// 绗竴涓搷浣滄暟鐨勭殑绗琻浣嶄簬绗簩涓搷浣滄暟鐨勭n浣� 鐩稿弽锛岄偅涔堢粨鏋滅殑绗琻涓轰篃涓�1锛屽惁鍒欎负0
			 System.out.println(5 ^ 3);//缁撴灉涓�6 
	 
			// 7銆佷綅闈�( ~ )
			// 鎿嶄綔鏁扮殑绗琻浣嶄负1锛岄偅涔堢粨鏋滅殑绗琻浣嶄负0锛屽弽涔嬨��
			System.out.println(~5);// 缁撴灉涓�-6 
			
			
			
		

		}

}
