package biblioteca;  
import java.util.Calendar;

/**
 * representa a un socio de tipo Docente en el sistema de la biblioteca
 * @author Gonzalo Uriel Castillo
 * @version 1
 */
public class Docente extends Socio {
    
    //atributos privados
    private String area;

    //constructor
    /**
     * constructor para la clase Docente
     * @param p_dniSocio numero de DNI del socio
     * @param p_nombre nombre del socio
     * @param p_area area docente a la que pertenece
     */
    public Docente(int p_dniSocio, String p_nombre, String p_area) {
        super(p_dniSocio, p_nombre, 5);
        this.setArea(p_area);
    }

    //setters
    private void setArea(String p_area) {
        this.area = p_area;
    }

    //getters
    /**
     * @return area del docente
     */
    public String getArea() {
        return this.area;
    }

    //metodos
    /**
     * cambia los dias de prestamo permitidos para el docente
     * @param p_dias dias adicionales a sumar
     */
    public void cambiarDiasDePrestamo(int p_dias) {
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }

    /**
     * evalua si el docente es responsable comprobando que no tenga prestamos vencidos
     * @return true si es responsable
     */
    public boolean esResponsable() {
        Calendar hoy = Calendar.getInstance();
        for (Prestamo p : this.getPrestamos()) {
            Calendar fechaEvaluar;
            
            if (p.getFechaDevolucion() == null) {
                fechaEvaluar = hoy;
            } else {
                fechaEvaluar = p.getFechaDevolucion();
            }

            if (p.vencido(fechaEvaluar)) {
                return false;
            }
        }
        
        return true;
    }

    /**
     * @return tipo de socio en texto
     */
    @Override
    public String soyDeLaClase() {
        return "Docente";
    }

    /**
     * evalua si el docente puede pedir un libro prestado
     * @return true si cumple con las condiciones para pedir
     */
    @Override
    public boolean puedePedir() {
        return super.puedePedir();
    }
}
