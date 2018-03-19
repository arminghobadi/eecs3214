package ass3;

import java.io.*;
import java.net.*;

public class In2cmServer {
	public static void main( String argv[]) throws Exception{
		String clientSentence;
		String capitalizedSentence;
		
		ServerSocket welcomeSocket = new ServerSocket(29512);
		
		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			clientSentence = inFromClient.readLine();
			
			capitalizedSentence = clientSentence.toUpperCase();
			
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
