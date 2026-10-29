import java.util.*;

/**
 * Representa un préstamo de biblioteca, el cual incluye las fechas de retiro y devolución,
 * así como la colección de libros asociados.
 * 
 * @author Lautaro Escalante
 * @version 28/10/2026
 */
public class Prestamo{
    private Calendar fechaRetiro;
    private Calendar fechaDevolucion;
    private ArrayList<Libro> listaLibro; 
    
    /**
     * Constructor para la clase Prestamo que inicializa las fechas de retiro y devolución,
     * y crea una lista de libros vacía.
     * 
     * @param p_fechaR Objeto Calendar que representa la fecha de retiro.
     * @param p_fechaDev Objeto Calendar que representa la fecha de devolución.
     */
    public Prestamo(Calendar p_fechaR,Calendar p_fechaDev){
        this.setFechaRetiro(p_fechaR);
        this.setFechaDevolucion(p_fechaDev);
        this.listaLibro= new ArrayList<>(); 
    }
    
    /**
     * Retorna la fecha de retiro del préstamo.
     * 
     * @return Objeto Calendar con la fecha de retiro.
     */
    public Calendar getFechaRetiro(){
        return this.fechaRetiro;
    }
    
    /**
     * Establece la fecha de retiro del préstamo.
     * 
     * @param p_fecha Objeto Calendar con la nueva fecha de retiro.
     */
    private void setFechaRetiro(Calendar p_fecha){
        this.fechaRetiro=p_fecha;
    }
    
    /**
     * Retorna la fecha de devolución del préstamo.
     * 
     * @return Objeto Calendar con la fecha de devolución.
     */
    public Calendar getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    
    /**
     * Establece la fecha de devolución del préstamo.
     * 
     * @param p_fechaDev Objeto Calendar con la nueva fecha de devolución.
     */
    private void setFechaDevolucion(Calendar p_fechaDev){
        this.fechaDevolucion=p_fechaDev;
    }
  
    /**
     * Retorna la lista de libros asociados al préstamo.
     * 
     * @return ArrayList de objetos Libro.
     */
    public ArrayList<Libro> getListaLibro(){
        return this.listaLibro;
    }
    
    /**
     * Establece la lista de libros del préstamo.
     * 
     * @param p_libros ArrayList de objetos Libro a asignar.
     */
    private void setListaLibro(ArrayList<Libro> p_libros){
        this.listaLibro=p_libros; 
    }
    
    //metodos 
    
    /**
     * Agrega un libro a la lista de libros del préstamo.
     * 
     * @param p_libro Objeto Libro a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    public boolean AgregarLibro(Libro p_libro){
        return this.getListaLibro().add(p_libro);
    }
    
    /**
     * Quita un libro de la lista de libros del préstamo.
     * 
     * @param p_libro Objeto Libro a quitar.
     * @return true si se removió correctamente, false en caso contrario.
     */
    public boolean QuitarLibro(Libro p_libro){
        return this.getListaLibro().remove(p_libro);
    }
    
     
    /**
     * Registra o actualiza la fecha de devolución del préstamo.
     * 
     * @param p_fecha Objeto Calendar que representa la fecha de devolución a registrar.
     */
    public void registrarFechaDevolucion(Calendar p_fecha){
        this.setFechaDevolucion(p_fecha);
    }
    
    /**
     * Verifica si el préstamo ha vencido respecto a una fecha dada.
     * 
     * @param p_fecha Objeto Calendar con la fecha contra la cual se evalúa el vencimiento.
     * @return true si la fecha supera el plazo límite, false en caso contrario.
     */
    public boolean vencio(Calendar p_fecha){
        Socio Aux;
        int diaTotal=this.getFechaRetiro().get(Calendar.DAY_OF_YEAR) + Aux.getDiasPrestamo();
        
        if(p_fecha.get(Calendar.DAY_OF_YEAR) > diaTotal ){
            return true;
        }
        
        return false;
    }
    
    /**
     * Retorna una representación en cadena de caracteres del préstamo,
     * mostrando las fechas, libro y socio asociados.
     * 
     * @return String con los datos formateados del préstamo.
     */
    public String toString(){
        int dia= this.getFechaRetiro().get(Calendar.DAY_OF_MONTH);
        int mes= this.getFechaRetiro().get(Calendar.MONTH)+1;
        int anio=this.getFechaRetiro().get(Calendar.YEAR);
        
        int diaDev=this.getFechaDevolucion().get(Calendar.DAY_OF_MONTH);
        int mesDev=this.getFechaDevolucion().get(Calendar.MONTH)+1;
        int anioDev=this.getFechaDevolucion().get(Calendar.YEAR);
        
        Libro libro;
        Socio socio;
        return "\nRetiro: " + anio + "/" + mes + "/" + dia +"/" +"-\tDevolucion:"+anioDev+"/"+mesDev+"/"+diaDev+"\nLibro:"+libro.getTitulo()+"\nSocio:"+socio.getNombre();
    }
    
    
}
