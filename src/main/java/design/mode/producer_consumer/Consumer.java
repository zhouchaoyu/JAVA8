package design.mode.producer_consumer;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 */

public class Consumer implements Runnable {

	private BlockingQueue<? super Product> queue;

	@Override
	public void run() {
		while (true) {
			try {
				consume();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void consume() throws InterruptedException {
		if (queue == null) {
			throw new RuntimeException("消费队列不能为空！！！");
		}
		synchronized (queue) {
			if (queue.size() == 0) {
				queue.wait();
			}
			Product product = (Product) queue.remove();
			System.out.println("消费了       " + product.toString());
			queue.notify();
		}

	}

	public void setQueue(BlockingQueue<? super Product> queue) {
		this.queue = queue;
	}

}
