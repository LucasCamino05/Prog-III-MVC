package model;

import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperRepository {
    List<Developer> developers = new ArrayList<>();

    public void guardarRepositorio(Developer o) throws UserAlreadyCreated{
        if(developers.contains(o)){
            throw new UserAlreadyCreated();
        }
        developers.add(o);
    }

    public void remove(int id) throws UserNotFound{
        int index = findIndexById(id);
        developers.remove(index);
    }
    public void remove(Developer o){
        developers.remove(o);
    }

    public int modifyDeveloper(Scanner input) throws UserNotFound{
        Integer value = input.nextInt();
        input.nextLine();

        for(Developer i: developers){
            if(i.getId() == value){
                i.setEdad(modifyEdad(input));
                input.nextLine();
                i.setNombre(modifyName(input));
                return 1;
            }
        }
        throw new UserNotFound();
    }
    public void showDevelopers() throws IsEmptyException {
        if(developers.isEmpty()){
            throw new IsEmptyException();
        }
        for(Developer i : developers){
            System.out.println(i.toString());
        }
    }

    public String modifyName(Scanner input){
        System.out.println("Ingrese el nuevo nombre: ");
        return input.nextLine();
    }
    public int modifyEdad(Scanner input){
        System.out.println("Ingrese la Edad: ");
        int value = input.nextInt();
        return value;
    }

    public int findIndexById(int id){
        for (int i=0; i<developers.size(); i++){
            if(developers.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}