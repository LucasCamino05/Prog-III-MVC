package controller;

import exceptions.IsEmptyException;
import exceptions.UserNotFound;
import exceptions.emptyException;
import exceptions.UserAlreadyCreated;
import model.Designer;
import model.DesignerRepository;

import java.util.Scanner;

public class DesignerController {

    private DesignerRepository repository;

    public DesignerController(DesignerRepository repo){
        this.repository = repo;
    }

    public void addDesigner(String nombre,Integer edad, String DNI) throws emptyException, UserAlreadyCreated {
        validarNombreVacio(nombre);
        Designer designer = new Designer(nombre,edad,DNI);
        repository.guardarRepositorio(designer);
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
    public void showDesigners() throws IsEmptyException {
        repository.showDesigners();
    }
    public void modificarDesigners(Scanner input) throws UserNotFound{
        repository.modifyDeveloper(input);
    }
}
