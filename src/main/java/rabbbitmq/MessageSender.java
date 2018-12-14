package rabbbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.imageio.ImageTypeSpecifier;

import org.junit.jupiter.api.Test;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;



public class MessageSender {
	private String queueName="AD_QUEUE";//瀹氫箟闃熷垪鍚嶇О
	@Test
	public  void send() throws IOException, TimeoutException {
		final  ConnectionFactory factory=new ConnectionFactory();
		
		factory.setHost("127.0.0.1");
		factory.setUsername("remote_user");
		factory.setPassword("770265");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare(queueName, true, false, true, null);
		channel.basicPublish("", queueName, null,"Redis+RabbitMQ 浣犱滑濂藉晩銆�".getBytes());
		channel.close();
		connection.close();
		
	}
	
}
