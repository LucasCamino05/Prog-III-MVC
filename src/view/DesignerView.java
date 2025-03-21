package view;

import controller.DesignerController;
import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import exceptions.emptyException;

import java.util.Scanner;

public class DesignerView {
    private DesignerController controller;
    private Scanner input;

    public DesignerView(DesignerController controller){
        this.controller = controller;
        this.input = new Scanner(System.in);
    }
    public void crearNuevoUsuario() throws emptyException, UserAlreadyCreated {
        System.out.println("Ingrese el nombre del nuevo usuario: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese la edad: ");
        Integer edad = input.nextInt();
        input.nextLine();

        System.out.println("Ingrese el DNI del usuario: ");
        String DNI = input.nextLine();

        controller.addDesigner(nombre,edad,DNI);
    }
    public void mostrarDesigners() throws IsEmptyException {
        controller.showDesigners();
    }
    public void modificarDesigner(Scanner input) throws UserNotFound {
        controller.modificarDesigners(input);
    }
}
