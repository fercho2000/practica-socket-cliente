package cliente_socket;

import java.io.IOException;

public class Main {
    private static int port;

    public static void main(String[] args) throws IOException {
//        ClienteSocket clienteSocket = new ClienteSocket();
//        clienteSocket.startConnection("127.0.0.1", 4444);
        SolicitudesCliente solicitudesCliente = new SolicitudesCliente();

        solicitudesCliente.ingresarRegistro();

//        System.out.println("mensaje  " + mensaje);
//
//
//        clienteSocket.sendMessage(mensaje);

        //clienteSocket.stopConnection();
    }
}
