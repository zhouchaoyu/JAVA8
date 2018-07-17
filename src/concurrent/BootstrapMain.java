package concurrent;
/**
 * 并发编程入口类
 * **/
public class BootstrapMain {
	public static void main(String[] args) {
		ThreadFactory factory=new ThreadFactory();
		factory.start();
	}
}
