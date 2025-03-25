package view;

import controller.DesignerController;
import exceptions.EmptyException;
import java.util.Scanner;

public class DesignerView {
    private final DesignerController controller;
    private final Scanner input;

    public DesignerView(DesignerController controller){
        this.controller = controller;
        this.input = new Scanner(System.in);
    }

    public void crearNuevoUsuario(){
        System.out.println("Ingrese el nombre del nuevo usuario: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese la edad: ");
        Integer edad = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese el DNI del usuario: ");
        String DNI = input.nextLine();

        controller.addDesigner(nombre,edad,DNI);
    }
    public void mostrarDesigners(){
        controller.showDesigners();
    }
    public void removeUser(){
        try {
            String DNI = enterString();
            controller.removeDesigner(DNI);
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
    public void modificarDesigner(int opcion){
        System.out.println("Ingrese el DNI: ");
        String DNI = enterString();

        if (opcion == 1) {
            String nombre = enterString();
            controller.modifyDesigner(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterInt();
            controller.modifyDesigner(DNI, edad);
        } else {
            String nombre = enterString();
            Integer edad = enterInt();
            controller.modifyDesigner(DNI, nombre, edad);
        }
    }

    public String enterString(){
        System.out.println("Ingrese un texto: ");
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
            String projectName = input.nextLine();
            String projectDescription = input.nextLine();
            String DNI = input.nextLine();
            controller.buildNewProject(projectName,projectDescription,DNI);
        }catch(EmptyException e){
            e.printStackTrace();
        }
    }

}
