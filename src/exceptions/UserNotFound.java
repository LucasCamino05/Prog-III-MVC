package exceptions;

public class UserNotFound extends Exception{
    public UserNotFound (){
        super("El usuario que buscas no esta loco.");
    }
}
