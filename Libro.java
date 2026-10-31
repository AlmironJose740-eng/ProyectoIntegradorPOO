import java.util.*;
/**
 * Representa un libro de la biblioteca, almacenando sus datos
 * y el historial de préstamos realizados.
 *
 * @author Valentin Aguirre
 * @version 1.0
 */
public class Libro {
    private String titulo;
    private int edicion;
    private String editorial;
    private int anio;
    private ArrayList<Prestamo> prestamos;

    /**
     * Constructor que inicializa los datos del libro y crea una lista
     * de préstamos vacía.
     *
     * @param p_titulo Título del libro.
     * @param p_edicion Edición del libro.
     * @param p_editorial Editorial que publicó el libro.
     * @param p_anio Año de publicación del libro.
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(new ArrayList<Prestamo>());
    }

    /**
     * Constructor que inicializa los datos del libro junto con una lista
     * de préstamos recibida como parámetro.
     *
     * @param p_titulo Título del libro.
     * @param p_edicion Edición del libro.
     * @param p_editorial Editorial que publicó el libro.
     * @param p_anio Año de publicación del libro.
     * @param p_prestamos Lista de préstamos del libro.
     */
    public Libro(String p_titulo, int p_edicion, String p_editorial, int p_anio, ArrayList<Prestamo> p_prestamos) {
        this.setTitulo(p_titulo);
        this.setEdicion(p_edicion);
        this.setEditorial(p_editorial);
        this.setAnio(p_anio);
        this.setPrestamos(p_prestamos);
    }

    private void setTitulo(String p_titulo) {
        this.titulo = p_titulo;
    }

    private void setEdicion(int p_edicion) {
        this.edicion = p_edicion;
    }

    private void setEditorial(String p_editorial) {
        this.editorial = p_editorial;
    }

    private void setAnio(int p_anio) {
        this.anio = p_anio;
    }

    private void setPrestamos(ArrayList<Prestamo> p_prestamos) {
        this.prestamos = p_prestamos;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getEdicion() {
        return this.edicion;
    }

    public String getEditorial() {
        return this.editorial;
    }

    public int getAnio() {
        return this.anio;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return this.prestamos;
    }
    
    public boolean agregarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().add(p_prestamo);
    }
    
    public boolean quitarPrestamo(Prestamo p_prestamo){
        return this.getPrestamos().remove(p_prestamo);
    }

    /**
     * Verifica si el libro se encuentra actualmente prestado,
     * consultando si el último préstamo tiene fecha de devolución.
     *
     * @return true si el libro está prestado o false si está disponible.
     */
    public boolean prestado() {
        //consulta el ultimo libro prestamo registrado
        if (this.ultimoPrestamo() == null) {
            return false; //el libro nunca fue prestado
        } else { //existe almenos un prestamo registrado
            if (this.ultimoPrestamo().getFechaDevolucion() == null) { //si la fecha es null entonces no registro la devolucion del libro
                return true; //si el libro esta prestado
            } else {
                return false; //si no es null significa que el libro ya fue devuelto asi que esta disponible
            }
        }
    }

    /**
     * Obtiene el último préstamo registrado del libro.
     * Si no existen préstamos, devuelve null.
     *
     * @return El último préstamo registrado o null si no hay préstamos.
     */
    public Prestamo ultimoPrestamo() {
        //verifica si la lista de prestamos esta vacia
        if (this.getPrestamos().isEmpty()) {
            return null;
        } else {
            return this.getPrestamos().get(this.getPrestamos().size() - 1);
        }
    }

    /**
     * Retorna una representación en cadena de caracteres del libro,
     * mostrando su título.
     *
     * @return String con el título del libro.
     */
    public String toString() {
        return "Titulo: " + this.getTitulo();
    }
}