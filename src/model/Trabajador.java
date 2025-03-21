package model;

import interfaces.iTrabajar;

public class Trabajador implements iTrabajar {
    private static int ID = 0;
    private int id;
    private String nombre;
    private Integer edad;
    private String DNI;
    // CONSTRUCTORES
    public Trabajador(String nombre, Integer edad,String DNI) {
        this.id = ID++ ;
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }
    public Trabajador() {
        this.id = ID++ ;
        nombre = null;
        edad = null;
    }

    // GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    // toSTring Override

    @Override
    public String toString() {
        return  "Nombre: " + nombre + '\n' +
                "Edad:" + edad + '\n' +
                "DNI: "+DNI;
    }

    @Override
    public void trabajando() {
        System.out.println("Trabajando como un exclavo");
    }

    @Override
    public void descansando() {
        System.out.println("Me merezco un descancito we");
    }
}
