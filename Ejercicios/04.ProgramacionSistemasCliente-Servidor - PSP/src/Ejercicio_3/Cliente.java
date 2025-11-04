package Ejercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion {

    public Cliente() throws IOException {
        super("cliente");
    }

    public void empezar_Cliente() throws IOException {

        Scanner lector = new Scanner(System.in);

        try{
            //Variables
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            String mensaje = in.readUTF();
            String siguienteMensaje;
            while(true) {

                //Programa que escribe una frase para contar vocales
                System.out.println(mensaje);
                System.out.println("--Menu--");
                System.out.println("\n Escribe el siguiente mensaje para contar vocales: ");
                siguienteMensaje = lector.nextLine();

                //Si se escribe end of service se corta la conexion entre el cliente y el servidor
                if (siguienteMensaje.equalsIgnoreCase("end of service")) {

                    out.writeUTF(siguienteMensaje);
                    System.out.println("Cerrando conexion...");
                    break;
                }
            }
        }catch(Exception e){

            System.out.println("Error al conectar");
        }

    }
}