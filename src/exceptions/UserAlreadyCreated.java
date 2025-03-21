package exceptions;

public class UserAlreadyCreated extends Exception {
    public UserAlreadyCreated() {
        super("El usuario ya existe en el sistema.");
    }
}
