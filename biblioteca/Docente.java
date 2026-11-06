package biblioteca;  
import java.util.Calendar;

/**
 * Representa a un socio de tipo Docente en el sistema de la biblioteca.
 * @author Gonzalo Uriel Castillo
 * @version 1.0
 */
public class Docente extends Socio {
    
    //atributos privados
    private String area;

    //constructor
    public Docente(int p_dniSocio, String p_nombre, String p_area) {
        super(p_dniSocio, p_nombre, 5);
        this.setArea(p_area);
    }

    //setters
    private void setArea(String p_area) {
        this.area = p_area;
    }

    //getters
    public String getArea() {
        return this.area;
    }

    //metodos
    public void cambiarDiasDePrestamo(int p_dias) {
        this.setDiasPrestamo(this.getDiasPrestamo() + p_dias);
    }

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

    @Override
    public String soyDeLaClase() {
        return "Docente";
    }

    @Override
    public boolean puedePedir() {
        return super.puedePedir();
    }
}
