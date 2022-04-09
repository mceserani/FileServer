package it.edu.polomanettiporciatti.fileserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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

        // Qui ci va il codice del protocollo
        // Ricevo il nome di un file dal client
        // Verifico se il file esiste
        // Se esiste ripondo "KO" e termino
        // Se non esiste rispondo "OK" e attendo che il client mi invii il file
        // Salvo il file nella directory in cui mi trovo
        // Al termine chiudo la connessione
    
    }

}
