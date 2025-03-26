package view;

import controller.DeveloperController;
import exceptions.EmptyException;
import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController controller;
    private final Scanner input;

    /* FUNCIONES PARA PEDIR DATOS *!*/
    public String enterNombre(){
        System.out.println("Ingrese Nombre: ");
        return input.nextLine();
    }

    public String enterDNI(){
        System.out.println("Ingrese DNI: ");
        return input.nextLine();
    }

    public String enterString(){
        System.out.println("Ingrese: ");
        return input.nextLine();
    }

    public int enterEdad(){
        System.out.println("Ingrese Edad: ");
        int value = input.nextInt();
        input.nextLine();

        return value;
    }

    /* Funciones de developers */

    public DeveloperView(DeveloperController controler){
        this.controller = controler;
        this.input = new Scanner(System.in);
    }
    public void crearNuevoUsuario(){
        String nombre = enterNombre();
        Integer edad = enterEdad();
        String DNI = enterDNI();

        controller.addDeveloper(nombre,edad,DNI);
    }

    public void removeUser(){
        try {
            String DNI = enterNombre();
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
        String DNI = enterDNI();

        if (opcion == 1) {
            String nombre = enterNombre();
            controller.modificarDeveloper(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterEdad();
            controller.modificarDeveloper(DNI, edad);
        } else {
            String nombre = enterNombre();
            Integer edad = enterEdad();
            controller.modificarDeveloper(DNI, nombre, edad);
        }
    }

    /* Funciones de proyecto */

    public void buildNewProject(){
        try {
            String projectName = enterNombre();
            String projectDescription = enterString();
            String DNI = enterDNI();
            controller.buildNewProject(projectName,projectDescription,DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }

    public void modifyProjectView(){
        try{
            String projectName = enterNombre();
            String projectDescription = enterString();
            String DNI = enterDNI();
            controller.modifyProjectController(projectName, projectDescription,DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }

    public void showProjectView(){
        try{
            String DNI = enterDNI();
            controller.showProjectController(DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }
    public void eliminarProjectView(){
        try{
            String DNI = enterDNI();
            controller.eliminarProjectController(DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }
}