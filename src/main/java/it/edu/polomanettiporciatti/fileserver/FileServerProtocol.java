package it.edu.polomanettiporciatti.fileserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

        File file = null;
        DataOutputStream fileOut = null;
        String fileName = null;

        // Receive filename from client
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

        try {

            // Check if the file exists
            file = new File(fileName);
            if (file.exists()) {
                // If exists send error message
                // and close the socket  
                out.writeUTF("KO");
                clientSocket.close();
                return;
            }

            // Else, if the file does not exist, send OK
            out.writeUTF("OK");

            // Receives the binary file from the client
            // and write it to the file system
            fileOut = new DataOutputStream(new FileOutputStream(file.getPath()));
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                fileOut.write(buffer, 0, bytesRead);
            }
           
            // Close the socket
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }

}
