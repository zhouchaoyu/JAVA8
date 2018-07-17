package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ServerSocketDemo {
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1234);
		log.debug("socket 正在接受信息");
		Socket socket = serverSocket.accept();
		InputStream stream=null;
		
		log.info("soket链接信息："+socket.isConnected());
		while(!socket.isConnected()) {
		stream = socket.getInputStream();
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		while((line=reader.readLine())!=null) {
			builder.append(line);
		}
		System.out.println("服务器已收到："+builder.toString());
		}
		if (stream!=null ) {
			stream.close();
		}
		socket.close();
		serverSocket.close();
	}
}
