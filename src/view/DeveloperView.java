package view;

import controller.DeveloperController;
import exceptions.IsEmptyException;
import exceptions.UserNotFound;
import exceptions.emptyException;
import exceptions.UserAlreadyCreated;

import java.util.Scanner;

public class DeveloperView {
    private DeveloperController controlador;
    private final Scanner input;

    public DeveloperView(DeveloperController controler){
        this.controlador = controler;
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

        controlador.addDeveloper(nombre,edad,DNI);
    }
    public void mostrarDevelopers() throws IsEmptyException {
        controlador.showDevelopers();
    }
    public void modificarDeveloper(Scanner input) throws UserNotFound {
        controlador.modificarDeveloper(input);
    }
}