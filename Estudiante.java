package biblioteca; 

/**
 * representa a un socio de tipo Estudiante en el sistema de la biblioteca
 * @author Gonzalo Uriel Castillo
 * @version 1
 */ 

public class Estudiante extends Socio {
    
    //atributos privados
    private String carrera;

    //constructor
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        super(p_dniSocio, p_nombre, 20);
        this.setCarrera(p_carrera);
    }

    //setters
    private void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
    }

    //getters
    public String getCarrera() {
        return this.carrera;
    }

    //metodos
    @Override
    public String soyDeLaClase() {
        return "Estudiante";
    }

    @Override
    public boolean puedePedir() {
        return super.puedePedir() && this.cantLibrosPrestados() <= 3;
    }
}
