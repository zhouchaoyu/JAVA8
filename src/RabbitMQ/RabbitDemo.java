package RabbitMQ;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

public class RabbitDemo {
	private String queueName = "AD_QUEUE";// 定义队列名称

	@Test
	void receive() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setUsername("remote_user");
		factory.setPassword("770265");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.basicQos(1);
		channel.basicConsume(queueName, new MyConsumer(channel));
		
		System.out.println(channel.getClass().getName());
		System.out.println("getChannelMax:" + connection.getChannelMax());
		System.out.println("consumerCount:" + channel.consumerCount(queueName));
		System.out.println("getChannelNumber" + channel.getChannelNumber());
		System.out.println("messageCount" + channel.messageCount(queueName));
		// channel.close();
		// connection.close();

	}

	@Test
	public void send() throws IOException, TimeoutException {
		final ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("127.0.0.1");
		factory.setUsername("remote_user");
		factory.setPassword("770265");
		factory.setPort(5672);
		factory.setVirtualHost("/");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(queueName, true, false, false, null);
		
		channel.basicPublish("", queueName, null, "bbitMQ 你们好啊。".getBytes());
		channel.close();
		connection.close();

	}
}
