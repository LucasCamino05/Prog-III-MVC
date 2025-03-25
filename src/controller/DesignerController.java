package controller;

import exceptions.EmptyException;
import exceptions.UserNotFound;
import model.Designer;
import model.DesignerRepository;

public class DesignerController {

    private DesignerRepository repository;

    public DesignerController(DesignerRepository repo){
        this.repository = repo;
    }

    public void addDesigner(String nombre,Integer edad, String DNI){
        try {
            validarVacio(nombre);
            Designer designer = new Designer(nombre, edad, DNI);
            repository.guardarRepositorio(designer);
        } catch (EmptyException e) {
            e.printStackTrace();
        }
    }

    private void validarVacio(String name) throws EmptyException {
        if (name.trim().isEmpty()) {
            throw new EmptyException("Este campo no puede estar vacio");
        }
    }

    public void showDesigners(){
        repository.showDesigners();
    }

    public void removeDesigner(String DNI){
        try{
            validarVacio(DNI);
            repository.removeDesigner(DNI);
        }catch (UserNotFound e){
            e.printStackTrace();
        }
        catch (EmptyException e) {
            e.printStackTrace();
        }
    }

    public void modifyDesigner(String DNI,String nombre){
        try{
            validarVacio(nombre);
            repository.modifyDesigner(DNI,nombre);
        }catch (EmptyException e){
            e.printStackTrace();
        }
        catch (UserNotFound e){
            e.printStackTrace();
        }
    }
    public void modifyDesigner(String DNI,Integer edad){
        try {
            repository.modifyDesigner(DNI, edad);
        }catch (UserNotFound e){
            e.printStackTrace();
        }
    }
    public void modifyDesigner(String DNI,String nombre,Integer edad){
        try{
            validarVacio(nombre);
            repository.modifyDesigner(DNI,nombre,edad);
        }catch (UserNotFound e){
            e.printStackTrace();
        }
        catch (EmptyException e){
            e.printStackTrace();
        }
    }

}
