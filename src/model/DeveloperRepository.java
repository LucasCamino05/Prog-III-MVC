package model;

import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {
    List<Developer> developers = new ArrayList<>();

    public void guardarRepositorio(Developer o){
        try {
            if (developers.contains(o)) {
                throw new UserAlreadyCreated();
            }
            developers.add(o);
        }catch (UserAlreadyCreated e){
            e.printStackTrace();
        }
    }

    public void removeRepository(String DNi) throws UserNotFound{
        int index = findIndexById(DNi);
        if(index != -1){
            developers.remove(index);
        }
        throw new UserNotFound();
    }

    public void modifyDeveloper(String DNI,String nombre) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            developers.get(index).setNombre(nombre);
        }
        throw new UserNotFound();
    }

    public void modifyDeveloper(String DNI,Integer edad) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            developers.get(index).setEdad(edad);
        }
        throw new UserNotFound();
    }

    public void modifyDeveloper(String DNI,String nombre,Integer edad) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            developers.get(index).setNombre(nombre);
            developers.get(index).setEdad(edad);
        }
        throw new UserNotFound();
    }

    public void showDevelopers() throws IsEmptyException{
        if(developers.isEmpty()){
            throw new IsEmptyException();
        }
        else{
            for(Developer i : developers){
                System.out.println(i.toString());
            }
        }
    }

    // Busco el INDEX del DNI que quiero eliminar.
    public int findIndexById(String DNI){
        for (int i=0; i<developers.size(); i++){
            if(developers.get(i).getDNI().compareTo(DNI) == 0){
                return i;
            }
        }
        return -1;
    }
    public void buildNewProject(String projectName,String projectDescription, String DNI){
        int index = findIndexById(DNI);
        developers.get(index).setProject(projectName,projectDescription);
    }
}