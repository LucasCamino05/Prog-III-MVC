package view;

import controller.DeveloperController;
import exceptions.EmptyException;
import exceptions.UserNotFound;

import java.util.Scanner;

public class DeveloperView {
    private DeveloperController controlador;
    private final Scanner input;

    public DeveloperView(DeveloperController controler){
        this.controlador = controler;
        this.input = new Scanner(System.in);
    }
    public void crearNuevoUsuario(){
        String nombre = enterName();
        Integer edad = enterAge();
        String DNI = enterDNI();

        controlador.addDeveloper(nombre,edad,DNI);
    }
    public void removeUser(){
        try {
            String DNI = enterDNI();
            controlador.removeController(DNI);
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
    public void mostrarDevelopers(){
        controlador.showDevelopers();
    }

    public void modificarDeveloper(int opcion){
        System.out.println("Ingrese el DNI: ");
        String DNI = enterDNI();

        if (opcion == 1) {
            String nombre = enterName();
            controlador.modificarDeveloper(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterAge();
            controlador.modificarDeveloper(DNI, edad);
        } else {
            String nombre = enterName();
            Integer edad = enterAge();
            controlador.modificarDeveloper(DNI, nombre, edad);
        }
    }

    public String enterName(){
        System.out.println("Ingrese el nuevo nombre: ");
        return input.nextLine();
    }

    public String enterDNI(){
        System.out.println("Ingrese el DNI del usuario: ");
        return input.nextLine();
    }

    public int enterAge(){
        System.out.println("Ingrese la Edad: ");
        int value = input.nextInt();
        input.nextLine();

        return value;
    }
}