package vista;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;

public class Menu {
    
    private Controlador controlador;
    static public boolean flag = false;
    static public int flag2;

    /**
     * Lista de strings con los elementos a utilizar para la creacion de mazos.
     * Puede ser modificado y cambiado para testear otros elementos en la
     * generacion de mazos.
     */
    public ArrayList<String> elements1 = new ArrayList<>(
                        Arrays.asList("-", "Leon", "Conejo", "Leopardo", "Oso", "Aguila", "Serpiente",
                              "Zorro", "Loro", "Puma", "Tigre", "Escorpion", "Capibara",
                              "Jaguar", "Avestruz", "Jirafa", "Elefante", "Rinoceronte", "Ballena",
                              "Mono", "Chimpance", "Gorila", "Nandu", "Pudu", "Alce",
                              "Hipopotamo", "Coyote", "Venado", "Antilope", "Tucan", "Caballo",
                              "Pinguino", "imOp"));

    /**
     * Menu inicializa el controlador.
     */
    public Menu() {
        this.controlador = new Controlador();
        flag2 = 1;
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * usarMenu imprime un menu por linea de comando y define variables
     * para recibir inputs entregados por el usuario. Llama metodos con
     * el controlador para los distintos input.
     * 
     * Opcion 1: llama al metodo crear_juego del controlador
     * Opcion 2: llama al metodo addplayer del controlador
     * Opcion 3: llama al metodo jugar del controlador
     * Opcion 4: llama al metodo visualizar_estado del controlador
     */
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
            int maxC = 0;
            int modo = 0;
            int numE = 0;
            System.out.println("Ingrese la cantidad de jugadores");
            try{
                cantidad = paso1.nextInt();
                try {
                    System.out.println("Ingrese el tamano del mazo de juego");
                    maxC = paso2.nextInt();
                    try {
                        System.out.println("Ingrese el numero de elementos por carta");
                        numE = paso3.nextInt();
                        try{
                            System.out.println("Ingrese el numero del modo de juego"+
                                    "\n1. Modo 1 (Stack)"+
                                    "\n2. Modo 2");
                            modo = paso4.nextInt();
                            this.controlador = new Controlador();
                            flag2 = 1;
                            controlador.crear_juego(cantidad, maxC, numE, modo, elements1);
                            flag = true;
                            if(controlador.dobbleCheck() == false){
                                System.out.println("WARNING: El mazo generado no es apto para jugar Dobble!");
                            }
                        } catch (Exception e) {
                            System.out.println("No se pudo crear el mazo. Intenta otra vez.");
                        }
                    } catch (Exception e) {
                        System.out.println("Debes ingresar una opcion numerica para los elementos por carta.");
                    }
                } catch (Exception e) {
                    System.out.println("Debes ingresar una maximo valido de cartas para el mazo.");
                }
            } catch (Exception e) {
                System.out.println("Debes ingresar una cantidad de jugadores valida.");
            }
        }
        else if (respuesta == 2) {
            if(flag == true){
                String nombre = "";
                System.out.println("Ingrese el nombre del jugador");
                try {
                    nombre = myInput.next();
                } catch (Exception e) {
                    System.out.println("Debes ingresar un jugador");
                }
                controlador.addplayer(nombre); // Metodo agregar jugador
            }
            else {
                System.out.println("Debe crear un juego primero!");
            }
        }
        else if (respuesta == 3) {
            if(flag == true){
                if(flag2 == 1){
                    if(controlador.deckSize() >= 2){
                        controlador.DosCartasAlTablero();
                        controlador.sacar2Cartas();
                        controlador.tablero();
                        controlador.visualizar_JugadorActual();
                        System.out.println("Ingrese el Elemento repetido (o escriba PASO para pasar su turno):\n");
                        String input;
                        try {
                            input = paso1.nextLine();
                            flag2 = controlador.jugar(input);
                            if(controlador.deckSize() < 2 && (flag2 == 1)){
                                System.out.println("Juego finalizado! Los ganadores son: "+controlador.ganadores()+"\n");
                            }
                        }
                        catch (Exception e) {
                            System.out.println("Input incorrecto");
                        }
                    }
                    else{
                        System.out.println("Juego finalizado! Los ganadores son: "+controlador.ganadores()+"\n");
                        System.out.println("Debe crear un nuevo juego!\n");
                    }
                }
                else if(flag2 == 0 || flag2 == 3){
                    controlador.tablero();
                    controlador.visualizar_JugadorActual();
                    System.out.println("Ingrese el Elemento repetido (o escriba PASO para pasar su turno):\n");
                    String input;
                    try{
                        input = paso1.nextLine();
                        flag2 = controlador.jugar(input);
                    }
                    catch (Exception e) {
                        System.out.println("Input incorrecto");
                    }
                }
                else{
                    System.out.println("El juego ha finalizado! Debe crear un nuevo juego!\n");
                    System.out.println("Los ganadores son: "+controlador.ganadores()+"\n");
                }
            }
            else{
                System.out.println("Debe crear un juego primero!");
            }
        }
        else if (respuesta == 4) {
            if(flag == true){
                controlador.visualizar_estado();
            }
            else{
                System.out.println("Debe crear un juego primero!");
            }
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