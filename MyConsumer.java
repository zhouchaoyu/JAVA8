package JfinalConfig;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;


public class MyConsumer implements Consumer {
	
	private  Channel channel;
	public MyConsumer(Channel channel) {
		this.channel=channel;
	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		System.out.println("handleConsumeOk");
	}

	@Override
	public void handleCancelOk(String consumerTag) {
		System.out.println("handleCancelOk");
	}

	@Override
	public void handleCancel(String consumerTag) throws IOException {
		System.out.println("handleCancel");
	}

	@Override
	public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
			throws IOException {
			String message=new String(body, "UTF-8");
			System.out.println("消费者标记："+consumerTag+"---------------------"+"消费者已接收到消息了"+message);
			System.out.println("交换器："+envelope.getExchange()+"-----------------路由："+envelope.getRoutingKey()+"------------------------"+envelope.isRedeliver());
			channel.basicAck(envelope.getDeliveryTag(), false);
			
	}

	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub
		System.out.println("handleShutdownSignal");
	}

	@Override
	public void handleRecoverOk(String consumerTag) {
		// TODO Auto-generated method stub
		System.out.println("handleRecoverOk");
	}

}
