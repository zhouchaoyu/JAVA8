package design.mode.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*****
 * 
 * 
 * @author Administrator
 * 生产者
 *
 */
public class Producer implements Runnable{
    
	//生产要求   
	private BlockingQueue<? super Product>  queue=new LinkedBlockingQueue<Product>();
	
	@Override
	public void run() {
		
		while(true) {
			try {
				 process();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
    /**
     * 生产
     * @throws InterruptedException 
     * **/
	private void process() throws InterruptedException{
		synchronized (queue) {
	    	if (queue.size()==10) {
				   queue.wait();//等待其他线程消费
			}
	    	Product product=new Product();
		    queue.add(product);
			System.out.println("          生产了  "+product.toString()+"                 产品剩余："+queue.size());
			queue.notify();//唤醒其他线程消费
		}
	}
	
	
	public BlockingQueue<? super Product>  getQueue(){
		return queue;
	}
}
