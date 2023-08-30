package test.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * <pre>
 * Socket 클라이언트 프로그램 제작
 * @author 김대현
 * 1. Socket 생성
 * 1-1. Socket client = new S(127.0.0.1, 5555); 
 *        (127.0.0.1 ->localhost)
 * 2. connect() : 필요요소(ip, port), 1번단계에서 내부적으로 수행
 * 3. 1번의 객체에서 InputStream/OutputStream을 얻어옴.
 * 3-1. In in = client.getI; Out out = client.getOut
 * 4. input-> read(), output-> write()
 * 4-1. in.read();  out.write();
 * 5. close() < 소켓
 * 5-1. client.close();
 * </pre>
 */
public class TestSocketClient {

	private static Socket client;
	private static BufferedReader in;
	private static PrintWriter out;

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		 System.out.println("Client started...");
		 client = new Socket("127.0.0.1", 5555); 
		 System.out.println("Connected OK!");
			try {
				out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 (new ClientThread(client, in, out)).start();
		 Scanner userIn = new Scanner(System.in);
		 String data = "";
		 while (true) {
			 System.out.print("입력>");
			 data = userIn.next();	
			 out.println(data);
			 out.flush();
			 System.out.println("send :: " + data);
		}
	}

}

class ClientThread extends Thread
{	Socket client;
	BufferedReader in;
	PrintWriter out;
	public ClientThread(Socket client, BufferedReader in, PrintWriter out) {
		this.client = client;
		this.in = in;
		this.out = out;
	}
	public void run()
	{
		 int i = 0;String data = null;
		while(true)
		{	
			try {
				System.out.println(Thread.currentThread() + " :: running...");
				data = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	System.out.println("read data = " + i);
			if(data.equals("exit"))	close();
		}
		
	}
	private void close() {
		try {
			in.close();
			out.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}