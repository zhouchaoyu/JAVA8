package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JDK8_features  {
		String [] strArr={"xiaoyu","xiaowen","xiaoming","dai","yan"};
		private   List<String>  newList=Arrays.asList(strArr);
		@Test
		@Disabled
		public void Iterator(){
			//newList.forEach(n->System.out.println(n));     简单遍历
			
		}
		@Test
		void testStream (){
			 List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
			 // System.out.println( nums.stream().findFirst().get());    取值
			 //System.out.println(nums.stream().count());  计数
			 /*nums= nums.stream().filter((n)-> n!=null).collect(Collectors.toList());//过滤收集
			 nums=nums.stream().distinct().collect(Collectors.toList());//去重
*/			 nums.stream().limit(8).forEach(System.out::println);
			 //求和
			 
			 
		}
		
		
}
