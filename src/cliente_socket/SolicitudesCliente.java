package cliente_socket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SolicitudesCliente {
    public SolicitudesCliente() {

    }

    public void ingresarRegistro() {
        ClienteSocket clienteSocket = new ClienteSocket();
        clienteSocket.startConnection("127.0.0.1", 4444);

        Map<String, String> cuentaMap = new HashMap<>();
        Scanner lectura = new Scanner(System.in);
        String operacion;
        do {
            System.out.println("Ingresa 1 para almacenar datos o 2 para terminar: ");
            operacion = lectura.nextLine();
            if (operacion.equalsIgnoreCase("1")) {
                System.out.println("Ingrese El  número de Cuenta: ");
                String numero = lectura.nextLine();
                System.out.println("Ingrese El  Valor: ");
                String valor = lectura.nextLine();
                cuentaMap.put("numero", numero);
                cuentaMap.put("valor", valor);
                System.out.println("map " + cuentaMap);
                clienteSocket.sendMessage(numero.concat(",").concat(valor));
            }
        } while (!operacion.equalsIgnoreCase("2"));
//        String inputLine;
//        while ((inputLine = in.readLine()) != null) {
//            if (".".equals(inputLine)) {
//                System.out.println("acabar...");
//                break;
//            }
//            System.out.println("entra este valor "+inputLine);
//            System.out.println(inputLine);
//        }

        //TODO anterior implementacion

//        System.out.println("Ingrese El  número de Cuenta: ");
//        String numero = lectura.nextLine();
//        System.out.println("Ingrese El  Valor: ");
//        String valor = lectura.nextLine();
//        cuentaMap.put("numero", numero);
//        cuentaMap.put("valor", valor);
//        System.out.println("map " + cuentaMap);
//        return cuentaMap;
    }

}

