//package ass3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class In2cmServer2 {
	
	public static ServerSocket serverSocket = null;
	public static Socket socket = null;
	public static DataOutputStream dout = null;
	public static DataInputStream din = null;
	private static final int port = 29512; // IMPORTANT!: remember to change this!! its 20000 + the last 4 digits of your student number
	
	public static void main( String argv[] ) throws Exception{
		
		serverSocket = new ServerSocket(port);
		//System.out.println("waiting...");
		socket = serverSocket.accept();
		//System.out.println("connection accepted");
		
		dout = new DataOutputStream(socket.getOutputStream());
		din = new DataInputStream(socket.getInputStream());
		dout.flush();
		dout.writeUTF("Welcome");
		dout.flush();
		
		//System.out.println("reading from client");
		String in2cm = din.readUTF();
		
		double ans = Double.parseDouble(in2cm);
		ans = ans * 2.54;
		int digits = (int) (ans * 100);
		ans = digits / 100.0;
		
		dout.writeUTF(Double.toString(ans));
		dout.flush();
		
		String thankyou = din.readUTF();
		//System.out.println(thankyou);
		
		dout.writeUTF("Bye");
		dout.flush();
		
		//System.out.println("done sending");
		//System.out.println("closing connection");
		dout.close();
		socket.close();
		serverSocket.close();
	}
}
