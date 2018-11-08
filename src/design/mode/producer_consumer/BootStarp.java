package design.mode.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 启动类
 * @author Administrator
 * ***/
public class BootStarp {
     
	 public static void main(String[] args) {
		  ExecutorService service =Executors.newFixedThreadPool(2);
		  
		  Consumer consumer=new Consumer();
		  Producer producer=new Producer();
		  consumer.setQueue(producer.getQueue());
		  service.execute(consumer);
		  service.execute(producer);
	 }
	
	
}
