package view;

import controller.DeveloperController;
import exceptions.EmptyException;
import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController controller;
    private final Scanner input;

    public DeveloperView(DeveloperController controler){
        this.controller = controler;
        this.input = new Scanner(System.in);
    }
    public void crearNuevoUsuario(){
        String nombre = enterString();
        Integer edad = enterInt();
        String DNI = enterString();

        controller.addDeveloper(nombre,edad,DNI);
    }
    public void removeUser(){
        try {
            String DNI = enterString();
            controller.removeDeveloper(DNI);
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
    public void mostrarDevelopers(){
        controller.showDevelopers();
    }

    public void modificarDeveloper(int opcion){
        System.out.println("Ingrese el DNI: ");
        String DNI = enterString();

        if (opcion == 1) {
            String nombre = enterString();
            controller.modificarDeveloper(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterInt();
            controller.modificarDeveloper(DNI, edad);
        } else {
            String nombre = enterString();
            Integer edad = enterInt();
            controller.modificarDeveloper(DNI, nombre, edad);
        }
    }

    public String enterString(){
        System.out.println("Ingrese: ");
        return input.nextLine();
    }

    public int enterInt(){
        System.out.println("Ingrese un entero: ");
        int value = input.nextInt();
        input.nextLine();

        return value;
    }

    public void buildNewProject(){
        try {
            String projectName = enterString();
            String projectDescription = enterString();
            String DNI = enterString();
            controller.buildNewProject(projectName,projectDescription,DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }
}