//package ass3;

import java.io.*;
import java.net.*;

public class In2cmServer {
	
	public static ServerSocket serverSocket = null;
	public static Socket socket = null;
	public static BufferedReader bufferedReader = null;
	public static DataOutputStream dataOutputStream = null;
	private static final int port = 29512; // IMPORTANT!: remember to change this!! its 20000 + the last 4 digits of your student number
	
	public static void main( String argv[] ) throws Exception{
		
		serverSocket = new ServerSocket(port);
		System.out.println("waiting...");
		
		
		//ServerSocket welcomeSocket = new ServerSocket(29512);
		
		while (true) {
			//Socket connectionSocket = welcomeSocket.accept();
			System.out.println("still waiting....");
			socket = serverSocket.accept();
			System.out.println("connection accepted");
			
			//a welcome msg
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			System.out.println("1");
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			//DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			System.out.println("2");
			//System.out.println(bufferedReader.readLine());
			dataOutputStream.writeBytes("Welcome");
			dataOutputStream.flush();
			System.out.println("3");
			
			String in2cm = bufferedReader.readLine();
			System.out.println("reading from client");
			
			dataOutputStream.writeBytes("yayy!");
			
			String thankyou = bufferedReader.readLine();
			
			System.out.println("done sending");
			
			if (!thankyou.equals("Thanks")) {
				System.out.println("something went wrong");
			}
			
			System.out.println("closing connection");
			
			dataOutputStream.close();
			bufferedReader.close();
			socket.close();
			serverSocket.close();
			//clientSentence = inFromClient.readLine();
			
			//capitalizedSentence = clientSentence.toUpperCase();
			
			//outToClient.writeBytes(capitalizedSentence);
		}
	}
}
