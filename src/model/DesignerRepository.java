package model;

import exceptions.IsEmptyException;
import exceptions.UserAlreadyCreated;
import exceptions.UserNotFound;
import java.util.ArrayList;
import java.util.List;

public class DesignerRepository {
    List<Designer> designers = new ArrayList<>();

    public void guardarRepositorio(Designer o){
        try {
            if (designers.contains(o)) {
                throw new UserAlreadyCreated();
            }
            designers.add(o);
        }catch (UserAlreadyCreated e){
            e.printStackTrace();
        }
    }

    public void showDesigners(){
        try {
            if (designers.isEmpty()) {
                throw new IsEmptyException();
            }
            for (Designer i : designers) {
                System.out.println(i.toString());
            }
        }catch (IsEmptyException e){
            e.printStackTrace();
        }
    }

    public void removeDesigner(String DNI) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            designers.remove(index);
        }
        throw new UserNotFound();
    }
    public void modifyDesigner(String DNI,String nombre) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            designers.get(index).setNombre(nombre);
        }
        throw new UserNotFound();
    }

    public void modifyDesigner(String DNI,Integer edad) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            designers.get(index).setEdad(edad);
        }
        throw new UserNotFound();
    }

    public void modifyDesigner(String DNI,String nombre,Integer edad) throws UserNotFound{
        int index = findIndexById(DNI);
        if(index != -1){
            designers.get(index).setNombre(nombre);
            designers.get(index).setEdad(edad);
        }
        throw new UserNotFound();
    }
    // Busco el INDEX del DNI que quiero eliminar.
    public int findIndexById(String DNI){
        for (int i=0; i<designers.size(); i++){
            if(designers.get(i).getDNI().compareTo(DNI) == 0){
                return i;
            }
        }
        return -1;
    }

    public void buildNewProject(String projectName,String projectDescription, String DNI){
        int index = findIndexById(DNI);
        designers.get(index).setProject(projectName,projectDescription);
    }
}
