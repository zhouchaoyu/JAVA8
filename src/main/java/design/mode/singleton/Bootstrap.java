package design.mode.singleton;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bootstrap {
	private static final Logger log=LoggerFactory.getLogger(Bootstrap.class);
	private final static int exeNum = 5000;// 瀹氫箟鎵ц鏁�
	private final static int exeThreadNum = 50;// 鎵ц绾跨▼鏁帮紙骞跺彂娴佺▼鎺у埗锛�
	 final static Semaphore semaphore = new Semaphore(exeThreadNum);

	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");
		ExecutorService service = Executors.newCachedThreadPool();// 鍒涘缓绾跨▼姹�
		CountDownLatch downLatch=new CountDownLatch(exeNum);
		log.info("浠诲姟宸插紑濮嬶細---"+dateFormat.format(System.currentTimeMillis()));
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
		log.info("浠诲姟宸插畬鎴�----"+exeNum +"------鏃堕棿锛�"+dateFormat.format(System.currentTimeMillis()));
		service.shutdown();
	}

	private static void LocalVariableSafeTest() throws InterruptedException {
		semaphore.acquire();
		ADCacheManager.getADCacheManager();
		semaphore.release();
	}
}