package controller;

import exceptions.IsEmptyException;
import exceptions.emptyException;
import exceptions.UserAlreadyCreated;
import model.Developer;
import model.DeveloperRepository;

public class DeveloperController {
    private DeveloperRepository repository;

    public DeveloperController(DeveloperRepository repo){
        this.repository = repo;
    }

    public void addDeveloper(String nombre, Integer edad, String DNI) throws emptyException,UserAlreadyCreated {
        validarDeveloperData(nombre);
        Developer developer = new Developer(nombre,edad,DNI);
        repository.guardarRepositorio(developer);
    }

    public void validarDeveloperData(String name) throws emptyException {
        if(name.trim().isEmpty()){
            throw new emptyException("El nombre no puede estar vacio");
        }
    }
    public void showDevelopers()throws IsEmptyException{
        repository.showDevelopers();
    }
    public void modificarDeveloper(){
        repository.modifyDeveloper();
    }
}