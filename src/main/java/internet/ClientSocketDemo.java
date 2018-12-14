package internet;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketDemo {

	public static void main(String[] args) throws Exception {
		Socket socket=new Socket("127.0.0.1", 1234);
		OutputStream stream =socket.getOutputStream();
		Scanner scanner=new Scanner(System.in);
		String val = null;       // 记录输入的字符串
		        do{
		            System.out.print("请输入：");
		            val = scanner.next();       // 等待输入值
		            System.out.println("您输入的是："+val);
		            stream.write(val.getBytes());
		            stream.flush();
		        }while(!val.equals("#"));   // 如果输入的值不是#就继续输入
		        System.out.println("你输入了\"#\"，程序已经退出！");
		        scanner.close(); // 关闭资源
		        stream.close();
		        socket.close();
	}
	
}
