//package ass3;

import java.io.*;
import java.net.*;

public class In2cmClient {
	
	public static Socket socket = null;
	public static DataInputStream dataInputStream = null;
    public static DataOutputStream dataOutputStream = null;
    public static BufferedReader bufferedReader = null;
    private static final String IP = "localhost";
    private static final int port = 29512; // IMPORTANT!: remember to change this!! its 20000 + the last 4 digits of your student number
	public static boolean openConnection = true;
    
	public static void main(String args[]) throws Exception {
		
		//first arg is inch
		//send it to server
		//server calculates to 2 decimal points
		// client sends thanks
		// server sends bye and close connection
		System.out.println(args[0]);
		if (args.length != 1) {
			//throw new IllegalArgumentException("Usage: In2cmClient <a number in inches to convert to cm>");
		}
		
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		//Socket clientSocket = new Socket("localhost",29512);
		
		
		//DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		//BufferedReader InFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		socket = new Socket(IP,port);
		
		System.out.println("connecting...");
		
		
        dataInputStream = new DataInputStream(socket.getInputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		while(openConnection) {
			//dataInputStream.readLine();
			System.out.println("4");
			
			//dataOutputStream.writeBytes("hey");
			//bufferedReader.wait(1000);
			String welcomeMsg = bufferedReader.readLine();
			System.out.println("connection established");
			if (!welcomeMsg.equals("Welcome")) {
				System.out.println("something is wrong");
			}
			System.out.println("sending the number");
			dataOutputStream.writeBytes(args[0]);
			String result = bufferedReader.readLine();
			System.out.println(result);
			dataOutputStream.writeBytes("Thanks");
			System.out.println("closing connectiong");
			
			dataInputStream.close();
			dataOutputStream.close();
			bufferedReader.close();
			socket.close();
			openConnection = false;
			
		}
	}
}
