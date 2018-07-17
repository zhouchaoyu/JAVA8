package practice;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Arrays;
import java.util.Date;

public class PersionProxyFactory {

	private PersionSetter  proxyPersion;// 代理类

	public void getProxy() {
		proxyPersion = (PersionSetter) Proxy.newProxyInstance(this.getClass().getClassLoader(),Persion.class.getInterfaces(),new InvocationHandler() {
			Persion persion=new Persion();//目标对象
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				method.invoke(persion, args);
				FileOutputStream outputStream=new FileOutputStream(new File("./res/proxy.txt"));
				SimpleDateFormat format=new SimpleDateFormat("yyyy 年  MM 月 dd  日   HH:mm:ss");
				String date=format.format(new Date());
				date="时间：  "+date+ "   方法名： "+method.getName()+"       参数："+Arrays.toString(args);
				outputStream.write(date.getBytes());
				outputStream.flush();
				outputStream.close();
				return null;
			}
		});
	}
	public PersionSetter getPersion() {
		getProxy();
		return proxyPersion;
	}
}
