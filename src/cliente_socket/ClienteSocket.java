package cliente_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket {

    private Socket clientSocket;
    private PrintWriter salidaCliente;
    private BufferedReader entradaServidor;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            salidaCliente = new PrintWriter(clientSocket.getOutputStream(), true);
            entradaServidor = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Error inicializando la conexión... " + e);
        }

    }

    public String sendMessage(String msg) {
        try {
            salidaCliente.println(msg);
            return entradaServidor.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public void stopConnection() {
        try {
            entradaServidor.close();
            salidaCliente.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error cerrando la conexión... " + e);
        }

    }
}