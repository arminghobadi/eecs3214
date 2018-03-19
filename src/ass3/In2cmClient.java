package ass3;

import java.io.*;
import java.net.*;

public class In2cmClient {
	
	public static Socket socket = null;
	public static DataInputStream dataInputStream = null;
    public static DataOutputStream dataOutputStream = null;
    private static final String IP = "35.197.28.71";
    private static final int port = 29512; // IMPORTANT!: remember to change this!! its 20000 + the last 4 digits of your student number
	
	public static void main(String argv[]) throws Exception {
		String sentence = null;
		String modified;
		
		//first arg is inch
		//send it to server
		//server calculates to 2 decimal points
		// client sends thanks
		// server sends bye and close connection
		
		if (argv.length != 2) {
			throw new IllegalArgumentException("Usage: In2cmClient <a number in inches to convert to cm>");
		}
		
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		Socket clientSocket = new Socket("localhost",29512);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader InFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//sentence = inFromUser.readLine();
		
		outToServer.writeBytes(sentence);
		
		modified = InFromServer.readLine();
		
		System.out.println("from server:" + modified);
		
		clientSocket.close();
	}
}
