package common;

import com.aliyun.oss.common.utils.StringUtils;
import com.beust.jcommander.Strings;

public class StringPractice {
	public static String url="https://shoutwest-oil.oss-cn-hangzhou.aliyuncs.com/timg%20%282%29.jpg";
	public static final String urlpath = "https://shoutwest-oil.oss-cn-hangzhou.aliyuncs.com/";
	public static void main(String[] args) {
		System.out.println(url.replace(urlpath,""));
		String filePath = url.substring(url.indexOf(urlpath)+1,url.length());
		System.out.println(filePath);
		
	}
	
}
