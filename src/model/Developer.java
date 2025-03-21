package model;

public class Developer extends Trabajador{
    // CONSTRUCTORES
    public Developer(String nombre, Integer edad,String DNI) {
        super(nombre,edad,DNI);
    }

    // toString Override

    @Override
    public String toString() {
        return "Developer" +
                "\n" + super.toString();
    }
}
