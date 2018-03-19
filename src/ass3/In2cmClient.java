//package ass3;

import java.io.*;
import java.net.*;

public class In2cmClient {
	
	public static Socket socket = null;
	public static DataInputStream din = null;
    public static DataOutputStream dout = null;
    private static final String IP = "localhost";
    private static final int port = 29512; // IMPORTANT!: remember to change this!! its 20000 + the last 4 digits of your student number
    
	public static void main(String args[]) throws Exception {
		
		System.out.println(args[0]);
		if (args.length != 1) {
			throw new IllegalArgumentException("Usage: In2cmClient <a number in inches to convert to cm>");
		}
		socket = new Socket(IP,port);
		
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        String welcomeMsg = din.readUTF();
		//System.out.println(welcomeMsg);
		//System.out.println("connection established");
		
		//System.out.println("sending the number");
		dout.writeUTF(args[0]);
		dout.flush();
	
		String in2cm = din.readUTF();
		//System.out.println(in2cm);
		dout.writeUTF("Thanks");
		dout.flush();
		String goodbyeMsg = din.readUTF();
		//System.out.println(goodbyeMsg);
		//System.out.println("closing connectiong");
		
		din.close();
		dout.close();
		socket.close();
	}
}
