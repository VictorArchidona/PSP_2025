package Ejercicio_1;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Cliente cli = new Cliente(); //Se crea el cliente

        System.out.println("Iniciando cliente\n");
        cli.empezar_Cliente(); //Se inicia el cliente

    }
}