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
        String respuestaServer = null;
        // do {
        try {
            System.out.println("Ingresa 1 para almacenar datos o 2 para consultar una cuenta: ");
            operacion = lectura.nextLine();
            System.out.println("Ingrese El  número de Cuenta: ");
            String numero = lectura.nextLine();
            if (operacion.equals("1")) {

                System.out.println("Ingrese El  Valor: ");
                String valor = lectura.nextLine();
                cuentaMap.put("numero", numero);
                cuentaMap.put("valor", valor);

                respuestaServer = clienteSocket.sendMessage(numero.concat(",").concat(valor));
                Thread.sleep(2000);
            } else if (operacion.equals("2")) {
                //TODO consultar cuenta
            }
        } catch (Exception e) {

        }
        //} while (Objects.requireNonNull(respuestaServer).length() > 0);
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

