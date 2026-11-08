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
    /**
     * constructor para la clase Estudiante
     * @param p_dniSocio numero de DNI del socio
     * @param p_nombre nombre del socio
     * @param p_carrera carrera que cursa el estudiante
     */
    public Estudiante(int p_dniSocio, String p_nombre, String p_carrera) {
        super(p_dniSocio, p_nombre, 20);
        this.setCarrera(p_carrera);
    }

    //setters
    private void setCarrera(String p_carrera) {
        this.carrera = p_carrera;
    }

    //getters
    /**
     * @return carrera del estudiante
     */
    public String getCarrera() {
        return this.carrera;
    }

    //metodos
    /**
     * @return tipo de socio en texto
     */
    @Override
    public String soyDeLaClase() {
        return "Estudiante";
    }

    /**
     * evalua si el estudiante puede pedir un libro prestado
     * @return true si cumple con las condiciones para pedir
     */
    @Override
    public boolean puedePedir() {
        return super.puedePedir() && this.cantLibrosPrestados() <= 3;
    }
}
