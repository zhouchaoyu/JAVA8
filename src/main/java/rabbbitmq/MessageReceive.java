package rabbbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

public class MessageReceive {
	private String queueName="AD_QUEUE";//瀹氫箟闃熷垪鍚嶇О
	@Test
	void receive() throws IOException, TimeoutException {
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setUsername("remote_user");
		factory.setPassword("770265");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		Connection  connection=factory.newConnection();
		
		Channel channel=connection.createChannel();
		//channel.basicQos(1);
		if (channel.messageCount(queueName)>0) {
			GetResponse response=channel.basicGet(queueName, false);
			String message=new String(response.getBody(), "UTF-8");
			System.out.println("娑堣垂鑰呭凡鎺ユ敹鍒版秷鎭簡"+message);
			channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
		}else {
			System.out.println("娌℃湁娑堟伅浜�");
		}
		channel.close();
		connection.close();
		
	}
}
