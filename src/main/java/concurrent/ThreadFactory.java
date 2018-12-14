package concurrent;

import java.util.Collections;

public class ThreadFactory {
	public void start() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					CommonObject commonObject = CommonObject.newInstance();
					commonObject.print(Thread.currentThread(), commonObject);
				}
			}).start();
			
		}
	}
}
