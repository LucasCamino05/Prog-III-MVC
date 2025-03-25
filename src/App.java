import exceptions.OpcionIncorrecta;
import view.DesignerView;
import view.DeveloperView;
import java.util.Scanner;

public class App {

    public static void __init(DeveloperView developerView, DesignerView designerView) {
        Scanner input = new Scanner(System.in);

        int opcion = 0;
        do {
            try {
                opcion = Menu(input);
                switch (opcion) {
                    case 1:  // Añadir usuario
                        opcion = subMenu(input);
                        switch (opcion) {
                            case 1:
                                developerView.crearNuevoUsuario();
                                break;
                            case 2:
                                designerView.crearNuevoUsuario();
                                break;
                        }
                        break;
                    case 2: //  Mostrar listados
                        opcion = subMenu(input);
                        switch (opcion) {
                            case 1:
                                developerView.mostrarDevelopers();
                                break;
                            case 2:
                                designerView.mostrarDesigners();
                                break;
                        }

                        break;
                    case 3:
                        System.out.println("\n----- Developers -----");
                        developerView.mostrarDevelopers();

                        System.out.println("\n----- Designers -----");
                        designerView.mostrarDesigners();
                        break;
                    case 4:
                        opcion = subMenu(input);
                        switch (opcion) {
                            case 1:
                                developerView.modificarDeveloper(subMenuModificar(input));
                                break;
                            case 2:
                                designerView.modificarDesigner(subMenuModificar(input));
                                break;
                        }
                        break;
                    case 5:
                        opcion = subMenu(input);
                        switch (opcion) {
                            case 1:
                                developerView.removeUser();
                                break;
                            case 2:
                                designerView.removeUser();
                                break;
                        }
                        break;
                    case 6:
                        opcion = subMenu(input);
                        switch (opcion){
                            case 1:
                                developerView.buildNewProject();
                                break;
                            case 2:
                                designerView.buildNewProject();
                                break;
                        }
                        break;
                }
            } catch (OpcionIncorrecta e) {
                e.printStackTrace();
            }
        } while (opcion != 10);
    }

    public static int Menu(Scanner input) throws OpcionIncorrecta {
        System.out.println("----- Bienvenido -----");
        System.out.println("1 - Agregar nuevo usuario.");
        System.out.println("2 - Mostrar lista.");
        System.out.println("3 - Mostrar ambas listas.");
        System.out.println("4 - Modificar un usuario.");
        System.out.println("5 - Eliminar un usuario.");
        System.out.println("6 - Agregar proyecto.");

        System.out.println("10 - Salir.");
        int opcion = input.nextInt();
        if (opcion <= 10 && opcion >= 1) {
            input.nextLine();
            return opcion;
        }
        throw new OpcionIncorrecta("Valor incorrecto intente nuevamente.");
    }

    // Menu para elegir si designer o developer.
    public static int subMenu(Scanner input) throws OpcionIncorrecta {
        System.out.println("----- Que desea añadir -----");
        System.out.println("1 - Developer.");
        System.out.println("2 - Designer.");
        int opcion = input.nextInt();

        if (opcion <= 2 && opcion >= 1) {
            input.nextLine();
            return opcion;
        }
        throw new OpcionIncorrecta("Valor incorrecto intente nuevamente.");
    }

    // Menu para opciones de cambio de designer o developer.
    public static int subMenuModificar(Scanner input) throws OpcionIncorrecta {
        System.out.println("----- Que desea añadir -----");
        System.out.println("1 - Nombre.");
        System.out.println("2 - Edad.");
        System.out.println("3 - Nombre y Edad.");
        int opcion = input.nextInt();
        if (opcion <= 3 && opcion >= 1) {
            input.nextLine(); // nextInt no consume la siguiente linea.
            return opcion;
        }
        throw new OpcionIncorrecta("Valor incorrecto intente nuevamente.");
    }
}
