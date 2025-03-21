package model;

public class Designer extends Trabajador{
    private Integer id_Designer;

    // CONSTRUCTORES

    public Designer(String nombre, Integer edad,String DNI) {
        super(nombre,edad,DNI);
    }

    // toString Override
    @Override
    public String toString() {
        return "Designer" +
                "\n" + super.toString();
    }
}
