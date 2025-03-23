package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Project {
    private String nombre;
    private String descripcion;

    // CONSTRUCTORES

    public Project(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Project() {
        this.nombre = null;
        this.descripcion = null;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString
    @Override
    public String toString() {
        return  "Project" +
                "\nNombre" + nombre +
                "\nDescripcion='" + descripcion;
    }
}
