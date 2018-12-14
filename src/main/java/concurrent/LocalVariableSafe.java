package concurrent;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalVariableSafe {
	private static final Logger log=LoggerFactory.getLogger(LocalVariableSafe.class);
	private final static int exeNum = 5000;// 鐎规矮绠熼幍褑顢戦弫锟�
	private final static int exeThreadNum = 50;// 閹笛嗩攽缁捐法鈻奸弫甯礄楠炶泛褰傚ù浣衡柤閹貉冨煑閿涳拷
	 final static Semaphore semaphore = new Semaphore(exeThreadNum);

	public static void main(String[] args) throws InterruptedException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss");
		ExecutorService service = Executors.newCachedThreadPool();// 閸掓稑缂撶痪璺ㄢ柤濮癸拷
		CountDownLatch downLatch=new CountDownLatch(exeNum);
		log.info("娴犺濮熷鎻掔磻婵绱�---"+dateFormat.format(System.currentTimeMillis()));
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
		log.info("娴犺濮熷鎻掔暚閹达拷----"+exeNum +"------閺冨爼妫块敍锟�"+dateFormat.format(System.currentTimeMillis()));
	}

	private static void LocalVariableSafeTest() throws InterruptedException {
		semaphore.acquire();
		int i=0;
		i++;
		if (i!=1) {
			log.info("闁挎瑨顕ら敍渚婄磼閿涗緤绱掗敍渚婄磼");
		}else {
			//log.info("鐏烇拷闁劌褰夐柌蹇庣瑝鐎涙ê婀痪璺ㄢ柤鐎瑰鍙忛梻顕�顣介敍渚婄磼閿涗緤绱掗敍锟�");
		}
		semaphore.release();
	}

}
