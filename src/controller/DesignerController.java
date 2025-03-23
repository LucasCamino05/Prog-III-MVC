package controller;

import exceptions.EmptyException;
import model.Designer;
import model.DesignerRepository;

import java.util.Scanner;

public class DesignerController {

    private DesignerRepository repository;

    public DesignerController(DesignerRepository repo){
        this.repository = repo;
    }

    public void addDesigner(String nombre,Integer edad, String DNI){
        validarNombreVacio(nombre);
        Designer designer = new Designer(nombre,edad,DNI);
        repository.guardarRepositorio(designer);
    }

    public void validarNombreVacio(String name){
        try {
            if (name.trim().isEmpty()) {
                throw new EmptyException("El nombre no puede estar vacio");
            }
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
    public void showDesigners(){
        repository.showDesigners();
    }
    public void modifyDesigner(Scanner input,String DNI){
        repository.modifyDesigner(input,DNI);
    }
}
