package view;

import controller.DesignerController;
import exceptions.EmptyException;
import java.util.Scanner;

public class DesignerView {
    private final DesignerController controller;
    private final Scanner input;

    /* FUNCIONES PARA PEDIR DATOS */

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

    /* Funciones de designers */

    public DesignerView(DesignerController controller){
        this.controller = controller;
        this.input = new Scanner(System.in);
    }

    public void crearNuevoUsuario(){
        String nombre = enterNombre();
        Integer edad = enterEdad();
        String DNI = enterDNI();

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
            String nombre = enterNombre();
            controller.modifyDesigner(DNI, nombre);
        } else if (opcion == 2) {
            Integer edad = enterEdad();
            controller.modifyDesigner(DNI, edad);
        } else {
            String nombre = enterNombre();
            Integer edad = enterEdad();
            controller.modifyDesigner(DNI, nombre, edad);
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
