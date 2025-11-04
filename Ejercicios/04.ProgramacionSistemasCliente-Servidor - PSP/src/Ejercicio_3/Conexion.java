package Ejercicio_3;

import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    private final int PUERTO = 1234;
    private final String HOST = "10.10.1.124";
    protected Socket sc;
    protected ServerSocket ss;


    public Conexion(String tipo){

        if(tipo.equalsIgnoreCase("servidor")){

            try{
                ss = new ServerSocket(PUERTO); //Creacion del socket del servidor
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else{
            try{
                sc = new Socket(HOST, PUERTO); //Creacion del socket del socket cliente
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }


    }

}

