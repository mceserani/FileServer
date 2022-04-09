package it.edu.polomanettiporciatti.fileserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class FileServerProtocol extends Thread{

    private Socket clientSocket;
    private DataOutputStream out;
    private DataInputStream in;

    public FileServerProtocol(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.in = new DataInputStream(clientSocket.getInputStream());
        this.out = new DataOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run() {

        // Receive filename from client
        String fileName = null;
        try {
            fileName = in.readUTF();
        } catch (IOException e) {
            // Close the socket and exit
            try {
                clientSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return;
        }

        // Check if the file exists
        File file = new File(fileName);
        if (file.exists()) {
            // If exists send error message
            // and close the socket
            try {
                out.writeUTF("KO");
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // Else, if the file does not exist, send OK

        // Receives the file from the client
        // and write it to the file system
        

        // Close the socket
    
    }

}
