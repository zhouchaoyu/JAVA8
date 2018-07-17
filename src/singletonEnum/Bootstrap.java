package singletonEnum;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.java.Log;
@Log
public class Bootstrap {
	private final static int exeNum = 5000;// 定义执行数
	private final static int exeThreadNum = 50;// 执行线程数（并发流程控制）
	 final static Semaphore semaphore = new Semaphore(exeThreadNum);

	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");
		ExecutorService service = Executors.newCachedThreadPool();// 创建线程池
		CountDownLatch downLatch=new CountDownLatch(exeNum);
		log.info("任务已开始：---"+dateFormat.format(System.currentTimeMillis()));
		for (int i = 0; i < exeNum; i++) {
			service.execute(() -> {
				try {
					LocalVariableSafeTest();
				} catch (Exception e) {
					e.printStackTrace();
				}
				downLatch.countDown();
			});
		}
		downLatch.await();
		log.info("任务已完成----"+exeNum +"------时间："+dateFormat.format(System.currentTimeMillis()));
		service.shutdown();
	}

	private static void LocalVariableSafeTest() throws InterruptedException {
		semaphore.acquire();
		ADCacheManager.getADCacheManager();
		semaphore.release();
	}
}