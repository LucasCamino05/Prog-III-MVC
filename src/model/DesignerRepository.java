package model;

import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DesignerRepository {
    List<Designer> designers = new ArrayList<>();

    public void guardarRepositorio(Designer o) throws UserAlreadyCreated {
        if(designers.contains(o)){
            throw new UserAlreadyCreated();
        }
        designers.add(o);
    }

    public void remove(int id) throws UserNotFound{
        int index = findIndexById(id);
        designers.remove(index);
    }
    public void remove(Designer o){
        designers.remove(o);
    }

    public int modifyDeveloper(Integer value) throws UserNotFound{
        Scanner input = new Scanner(System.in);
        for(Designer i: designers){
            if(i.getId() == value){
                i.setEdad(modifyEdad(input));
                input.nextLine();
                i.setNombre(modifyName(input));
                return 1;
            }
        }
        input.close();
        throw new UserNotFound();
    }
    public void showDesigners() throws IsEmptyException {
        if(designers.isEmpty()){
            throw new IsEmptyException();
        }
        for(Designer i : designers){
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
        for (int i=0; i<designers.size(); i++){
            if(designers.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
