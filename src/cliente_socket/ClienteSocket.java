package cliente_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//        Elabore un programa socket cliente que solicite capture por consola, el número de
//        cuenta y un valor en tipo de dato String,arme un mensaje por concatenación de
//        cadenas de caracteres en la variable mensaje y envíela al programa socket servidor,
//        el cual debe recibir el mensaje,extraer las subcadenas cuenta y valor y convertirlas
//        a valores numéricos,así podrá ingresar al archivo y grabar los datos separados por
//        comas.Si pudo grabar,el socket server debe enviar un mensaje al cliente diciendo
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

    public void sendMessage(String msg) {
        try {
            salidaCliente.println(msg);
            String respuesta = entradaServidor.readLine();
            System.out.println("Respuest Servidor ----> " + respuesta);
        } catch (Exception e) {
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