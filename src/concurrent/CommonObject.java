package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonObject {
	private Lock lock = new ReentrantLock();
	public static CommonObject commonObject;
	Condition key=lock.newCondition();
	public synchronized static CommonObject newInstance() {
		if (commonObject == null) {
			commonObject = new CommonObject();
		}
		return commonObject;
	}

	private CommonObject() {
	}

	public volatile Integer flag = 0;

	public void print(Thread thread, final Object object) {
		lock.lock();
		try {
			key.await(3000,TimeUnit.MILLISECONDS);
			
		} catch (InterruptedException e) {
			System.out.println("中断异常！------------------------");
			e.printStackTrace();
		}
		try {
			System.out.println("线程ID：" + thread.getId() + "             线程名称：" + thread.getName()
					+ "              并发访问对象：" + object.toString() + "           外部参数："
					+ flag++);
		} finally {
			lock.unlock();
		}

	}

}
