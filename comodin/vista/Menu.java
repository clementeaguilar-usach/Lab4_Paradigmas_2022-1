package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;

public class Menu {
    private Controlador controlador;

    public Menu() {
        this.controlador = new Controlador();
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void usarMenu() {
        Scanner myInput = new Scanner(System.in);
        Scanner paso1 = new Scanner(System.in);
        Scanner paso2 = new Scanner(System.in);
        Scanner paso3 = new Scanner(System.in);
        Scanner paso4 = new Scanner(System.in);
        System.out.println("### DOBBLE###"+
                "\n1. Crear juego"+
                "\n2. Registrar jugador"+
                "\n3. Jugar"+
                "\n4. Visualizar estado completo del juego"+
                "\n5. Salir");
        int respuesta = 0;
        try {
        respuesta = myInput.nextInt();
        } catch (Exception e) {
        System.out.println("Debes ingresar una opcion numerica");

        }
        if (respuesta == 1) {
            int cantidad = 0;
            int tamanio = 0;
            int modo = 0;
            int num_e = 0;
            System.out.println("Ingrese la cantidad de jugadores");
            try{
                cantidad = paso1.nextInt();
                try {
                    System.out.println("Ingrese el tamanio del mazo");
                    tamanio = paso2.nextInt();
                    try {
                        System.out.println("Ingrese el numero de elementos por carta");
                        num_e = paso3.nextInt();
                        try{
                            System.out.println("Ingrese el modo de juego"+
                                    "\n1. Modo 1"+
                                    "\n2. Modo 2");
                            modo = paso4.nextInt();
                            controlador.crear_juego(cantidad, tamanio, num_e, modo);
                            if(controlador.dobbleCheck() == false){
                                System.out.println("WARNING: El mazo generado no es apto para jugar Dobble!");
                            }
                        } catch (Exception e) {
                            System.out.println("Debes ingresar una opcion numerica 1");
                        }
                    } catch (Exception e) {
                        System.out.println("Debes ingresar una opcion numerica 2");
                    }
                } catch (Exception e) {
                    System.out.println("Debes ingresar una opcion numerica 3");
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar una opcion numerica 4");
            }
        }
        else if (respuesta == 2) {
            String nombre = "";
            System.out.println("Ingrese el nombre del jugador");
            try {
                nombre = myInput.next();
            } catch (Exception e) {
                System.out.println("Debes ingresar un jugador");
            }
            controlador.addplayer(nombre); // Metodo agregar jugador
        }
        else if (respuesta == 3) { // No terminar aun
            controlador.jugar(respuesta); // Metodo jugar
        }
        else if (respuesta == 4) { // No terminar aun
            controlador.visualizar_estado(respuesta); // Metodo jugar
        }    
        else if (respuesta == 5) {
            myInput.close();
            paso1.close();
            paso2.close();
            paso3.close();
            return;
        }
        else {
            System.out.println("Opcion no valida");
        }
        usarMenu();
    }
}