import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import exceptions.emptyException;
import view.DesignerView;
import view.DeveloperView;

import java.util.Scanner;

public class App {

    public static void __init(DeveloperView developerView, DesignerView designerView) throws IsEmptyException, UserAlreadyCreated, emptyException, UserNotFound {
        Scanner input = new Scanner(System.in);
        int salir;
        int opcion;
        do{
            opcion = Menu(input);
            switch (opcion){
                case 1:
                    developerView.crearNuevoUsuario();
                    break;
                case 2:
                    designerView.crearNuevoUsuario();
                    break;
                case 3:
                    developerView.mostrarDevelopers();
                    break;
                case 4:
                    designerView.mostrarDesigners();
                    break;
                case 5:
                    System.out.println("\n----- Developers -----");
                    developerView.mostrarDevelopers();
                    System.out.println("\n----- Designers -----");
                    designerView.mostrarDesigners();
                    break;
                case 6:
                    developerView.modificarDeveloper(input);
                    break;
                case 7:
                    designerView.modificarDesigner(input);
                    break;
            }
            System.out.println("Desea continuar? Si(1) - No(0)");
            salir = input.nextInt();
            input.nextLine();

        }while(salir != 0);
    }

    public static int Menu(Scanner input){

        System.out.println("----- Bienvenido -----");
        System.out.println("1 - Agregar Developer.");
        System.out.println("2 - Agregar Designer.");
        System.out.println("3 - Mostrar Developer.");
        System.out.println("4 - Mostrar Designer.");
        System.out.println("5 - Mostrar ambas listas.");
        System.out.println("6 - Modificar un Developer.");
        System.out.println("7 - Modificar un Designer.");

        int opcion = input.nextInt();
        input.nextLine();

        return opcion;
    }
}
