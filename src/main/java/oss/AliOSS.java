package oss;

import java.util.Date;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;

public class AliOSS {
	private OSSClient ossClient;//oss 客户�?
	private static AliOSS alioss;//Alioss  客户�?
	public static final String urlpath = "https://shoutwest-oil.oss-cn-hangzhou.aliyuncs.com/";
	private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
	private String accessKeyId = "LTAIZNKcPw7zGkBl";
	private String accessKeySecret = "WSdOl2MW9wjsRmhN8NLaBISOlcBpXa";
	@SuppressWarnings("deprecation")
	private AliOSS()
	{
		ossClient  = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}
	public static AliOSS Getinstance()
	{
		if(alioss==null)
		{  
			synchronized (AliOSS.class) {
				if (alioss==null) {
					alioss = new AliOSS();
					return alioss;		
				}
			}
		}
		return alioss;
		
	}
	public String GetUploadURL(String objectname, String contenttype)
	{
		Date now = new Date();
		Date expiration = new Date(now.getTime() + 86400000);
		GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest("shoutwest-oil", objectname, HttpMethod.PUT);
		request.setExpiration(expiration);
		request.setContentType(contenttype);
		String signedUrl = ossClient.generatePresignedUrl(request).toString();
		return signedUrl;
	}
	
	/**
	 * 	删除�?个oss的object
	 */
	public boolean deledeobject(String object_path) {
			ossClient.deleteObject("carplatform", object_path);
			return true;
	}
	
	


}