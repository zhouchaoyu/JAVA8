package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerSocketDemo {
	private static final Logger log=LoggerFactory.getLogger(ServerSocketDemo.class);
	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket(1234);
		log.debug("socket 濮濓絽婀幒銉ュ綀娣団剝浼�");
		Socket socket = serverSocket.accept();
		InputStream stream=null;
		
		log.info("soket闁剧偓甯存穱鈩冧紖閿涳拷"+socket.isConnected());
		while(!socket.isConnected()) {
		stream = socket.getInputStream();
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		while((line=reader.readLine())!=null) {
			builder.append(line);
		}
		System.out.println("閺堝秴濮熼崳銊ュ嚒閺�璺哄煂閿涳拷"+builder.toString());
		}
		if (stream!=null ) {
			stream.close();
		}
		socket.close();
		serverSocket.close();
	}
}
