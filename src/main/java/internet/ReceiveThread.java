package internet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;
public class ReceiveThread extends Thread {

	    private ServerSocket server;
	    private ChatWindow window;

	    public ReceiveThread(ChatWindow window) {
	        this.window = window;
	        try {
	            server = new ServerSocket(0);
	            window.setLocalPort(server.getLocalPort());
	            start();
	        } catch (IOException e) {
	        	window.printError("连接出错");
	        }
	    }

	    @Override
	    public void run() {
	        // TODO Auto-generated method stub
	        while(true){
	            Socket socket=null;
	            OutputStreamWriter writer = null;
	            try {
	                socket = server.accept();
	                writer= new OutputStreamWriter(socket.getOutputStream());
		            writer.write("Received");
		            writer.flush();
	                InputStreamReader reader = new InputStreamReader(socket.getInputStream());
	                int c;
	                StringBuilder sb = new StringBuilder();
	                while((c = reader.read()) != -1){
	                	System.out.println(c);
	                	sb.append((char)c);
	                }
	                
		            window.setReceive(sb.toString());
	             } catch (IOException e) {
	            	System.out.println("线程将接受到的数据写入对话框出错");
	            }finally {
	            	if (writer!=null) {
	            		try {
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	            	if (socket!=null&&!socket.isClosed()) {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
	            	
	            	
	            }
	        }
	    }
	}