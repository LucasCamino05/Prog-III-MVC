package view;

import controller.DesignerController;
import exceptions.EmptyException;


import java.util.Scanner;

public class DesignerView {
    private DesignerController controller;
    private Scanner input;

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
            String DNI = enterDNI();
            controller.removeDesigner(DNI);
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
    public void modificarDesigner(int opcion){
        System.out.println("Ingrese el DNI: ");
        String DNI = enterDNI();

        if (opcion == 1) {
            String nombre = enterName();
            controller.modifyDesigner(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterAge();
            controller.modifyDesigner(DNI, edad);
        } else {
            String nombre = enterName();
            Integer edad = enterAge();
            controller.modifyDesigner(DNI, nombre, edad);
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
