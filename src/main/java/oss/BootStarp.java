package oss;

import java.io.File;

public class BootStarp {
       
	 public static void main(String[] args) {
		AliOSS oss=AliOSS.Getinstance();
		File file=new File("aa.jpg");
		System.out.println(file.length());
		System.out.println(file.getAbsolutePath());
		String objectName="abc";
		String contenttype="";
		String getUploadURL = oss.GetUploadURL(objectName,contenttype);
		System.out.println(getUploadURL);   
	}
	 
}
