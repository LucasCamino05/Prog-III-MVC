package controller;


import exceptions.IsEmptyException;
import exceptions.EmptyException;
import exceptions.UserNotFound;
import model.Developer;
import model.DeveloperRepository;


public class DeveloperController {
    private DeveloperRepository repository;

    public DeveloperController(DeveloperRepository repo){
        this.repository = repo;
    }

    public void addDeveloper(String nombre, Integer edad, String DNI){
        try {
            validarVacio(nombre,DNI);
        }
        catch (EmptyException e){
            e.printStackTrace();
        }
        Developer developer = new Developer(nombre,edad,DNI);
        repository.guardarRepositorio(developer);
    }

    private void validarVacio(String name, String DNI) throws EmptyException {
        if (name.trim().isEmpty()) {
            throw new EmptyException("El nombre no puede estar vacio");
        }
        if (DNI.trim().isEmpty()) {
            throw new EmptyException("El DNI no puede estar vacio.");
        }
    }

    private void validarNombreVacio(String name) throws EmptyException {
        if (name.trim().isEmpty()) {
            throw new EmptyException("El nombre no puede estar vacio");
        }
    }

    public void showDevelopers(){
        try {
            repository.showDevelopers();
        }catch (IsEmptyException e){
            e.printStackTrace();
        }
    }

    public void modificarDeveloper(String DNI,String nombre){
        try{
            validarNombreVacio(nombre);
            repository.modifyDeveloper(DNI,nombre);
        }catch (EmptyException e){
            e.printStackTrace();
        }
        catch (UserNotFound e){
            e.printStackTrace();
        }
    }
    public void modificarDeveloper(String DNI,Integer edad){
        try {
            repository.modifyDeveloper(DNI, edad);
        }catch (UserNotFound e){
            e.printStackTrace();
        }
    }
    public void modificarDeveloper(String DNI,String nombre,Integer edad){
        try{
        repository.modifyDeveloper(DNI,nombre,edad);
        }catch (UserNotFound e){
            e.printStackTrace();
        }
    }



    public void removeController(String DNI){
        repository.removeRepository(DNI);
    }

}