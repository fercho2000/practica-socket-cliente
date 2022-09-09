package cliente_socket;

import java.util.Objects;
import java.util.Scanner;

public class SolicitudesCliente {
    private static final String EXPRESION_REGULAR_SOLO_VALORES_NUMERICOS = "[0-9]+";
    private final ClienteSocket clienteSocket;

    public SolicitudesCliente() {
        this.clienteSocket = new ClienteSocket();
        this.clienteSocket.startConnection("127.0.0.1", 4444);
    }

    public void ingresarRegistro() {

        try {
            this.generarRegistro();

        } catch (Exception e) {
        }
    }

    private void generarRegistro() {
        Scanner lectura = new Scanner(System.in);
        String operacion;
        System.out.println("Ingresa 1 para almacenar datos o 2 para consultar una cuenta: ");
        operacion = lectura.nextLine();

        if (!Objects.equals(operacion, "1") && !Objects.equals(operacion, "2")) {
            System.out.println("El tipo de operacion ingresada no es valida...");
            return;
        }
        System.out.println("Ingrese El  número de Cuenta: ");
        String numeroCuenta = lectura.nextLine();
        validacionDatosSoloNumeros(numeroCuenta);
        if (operacion.equals("1")) {

            System.out.println("Ingrese el  valor para la cuenta: ");
            String valorCuenta = lectura.nextLine();
            validacionDatosSoloNumeros(valorCuenta);
            this.clienteSocket.sendMessage(operacion + "," + numeroCuenta + "," + valorCuenta);

        } else if (operacion.equals("2")) {
            clienteSocket.sendMessage(operacion + "," + numeroCuenta);
        }
    }

    void validacionDatosSoloNumeros(String valor) {
        try {
            Integer.valueOf(valor);

        } catch (NumberFormatException e) {
            // TODO: handle exception
            System.out.println("El valor  ingresado esta mal, debe ser númerico ...");
            throw new NumberFormatException();
        }

    }

}

