package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Developer extends Trabajador{
    private Project project;


    // CONSTRUCTORES
    public Developer(String nombre, Integer edad,String DNI) {
        super(nombre,edad,DNI);
        this.project = new Project();
    }

    // GETTER Y SETTER

    public String getProject() {
        return project.toString();
    }

    public void setProject(String projectName, String projectDescription) {
        this.project.setDescripcion(projectDescription);
        this.project.setNombre(projectName);
    }

    // toString Override

    @Override
    public String toString() {
        return "Developer" +
                "\n" + super.toString() +
                "\n" + this.getProject();
    }
}
