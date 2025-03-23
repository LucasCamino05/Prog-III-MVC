package controller;

import exceptions.IsEmptyException;
import exceptions.UserNotFound;
import exceptions.emptyException;
import exceptions.UserAlreadyCreated;
import model.Developer;
import model.DeveloperRepository;

import java.util.Scanner;

public class DeveloperController {
    private DeveloperRepository repository;

    public DeveloperController(DeveloperRepository repo){
        this.repository = repo;
    }

    public void addDeveloper(String nombre, Integer edad, String DNI) throws UserAlreadyCreated {
        validarNombreVacio(nombre);
        Developer developer = new Developer(nombre,edad,DNI);
        repository.guardarRepositorio(developer);
    }

    public void validarNombreVacio(String name){
        try {
            if (name.trim().isEmpty()) {
                throw new emptyException("El nombre no puede estar vacio");
            }
        }catch (emptyException e){
            e.printStackTrace();
        }
    }
    public void showDevelopers()throws IsEmptyException{
        repository.showDevelopers();
    }
    public void modificarDeveloper(Scanner input) throws UserNotFound {
        repository.modifyDeveloper(input);
    }
}