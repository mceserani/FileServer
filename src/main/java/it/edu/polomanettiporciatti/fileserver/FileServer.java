package it.edu.polomanettiporciatti.fileserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
	
	private FileServer(){
	}

	/**
	 * 
	 * @param args Command line arguments
	 * @author Matteo Ceserani
	 * @version 1.0
	 */
    public static void main(String[] args){
       
		if(args.length != 1){
			System.out.println("Usage: java FileServer <port>");
			System.exit(1);
		}

		int port = -1;
		
		try{
			port = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			System.out.println("Error: port must be an integer");
			System.exit(2);
		}

		if (port < 0 || port > 65535){
			System.out.println("Error: port must be in the range 0-65535");
			System.exit(3);
		}

		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		FileServerProtocol protocol = null;

		try{
			serverSocket = new ServerSocket(port);
			while(true){
				clientSocket = serverSocket.accept();
				protocol = new FileServerProtocol(clientSocket);
				protocol.start();
			}
		}catch(IOException e){
			System.out.println("Error: " + e.getMessage());
			System.exit(4);
		}
		
    }

}