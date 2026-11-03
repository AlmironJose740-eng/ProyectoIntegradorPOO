import java.util.Calendar;
import java.util.GregorianCalendar;  
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
    //private ArrayList<Libro> Libro; 
    private Socio libroSocio; 
    private Libro libros;
    
    /**
     * Constructor para la clase Prestamo que inicializa las fechas de retiro y devolución,
     * y crea una lista de libros vacía.
     * 
     * @param p_fechaR Objeto Calendar que representa la fecha de retiro.
     * @param p_fechaDev Objeto Calendar que representa la fecha de devolución.
     */
    
    
    //
    // socio 
    //constructor general 
    /*public Prestamo(Calendar p_fechaR,Calendar p_fechaDev){
        this.setFechaRetiro(p_fechaR);
        this.setFechaDevolucion(p_fechaDev);
        this.setLibros(new ArrayList<Libro>()); 
    }
    
    //constructor para pedir un libro solo se  registra la fecha de retiro
    
    //constructor recibe una lista de libros
    public Prestamo(Calendar p_fechaR, ArrayList<Libro> p_listaLibro){
        this.setFechaRetiro(null);
        this.setLibros(p_listaLibro); 
    }
    */
    //constructor que recibe la fecha de devolucionb de un libro y lo asienta en socio
    
    //constructor recibe un objeto libro 
    public Prestamo(Socio p_socio,Calendar p_fechaDev, Libro p_libro){
        this.setFechaDevolucion(null);
        this.setSocio(p_socio); 
        // this.setListaLibro(new ArrayList<Libro>()); 
         this.setLibro(p_libro);
    }
    
   
    public Libro getLibro(){
        return this.libros;
    }
    private void setLibro(Libro p_libros){
        this.libros=p_libros; 
    }
    
    
    
    public Socio getSocio(){
        return this.libroSocio;
    }
    private void setSocio(Socio p_socio){
        this.libroSocio=p_socio;
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
   /* public ArrayList<Libro> getLibros(){
        return this.Libro;
    }
    
    /**
     * Establece la lista de libros del préstamo.
     * 
     * @param p_libros ArrayList de objetos Libro a asignar.
     */
    /*private void setLibros(ArrayList<Libro> p_libros){
        this.Libro=p_libros; 
    }*/
    
    //metodos 
    
    /*/**
     * Agrega un libro a la lista de libros del préstamo.
     * 
     * @param p_libro Objeto Libro a agregar.
     * @return true si se agregó correctamente, false en caso contrario.
     */
    /*public boolean AgregarLibro(Libro p_libro){
        return this.getLibros().add(p_libro);
    }/*
    
    /**
     * Quita un libro de la lista de libros del préstamo.
     * 
     * @param p_libro Objeto Libro a quitar.
     * @return true si se removió correctamente, false en caso contrario.
     */
    /*public boolean QuitarLibro(Libro p_libro){
        if(this.getLibros().size() >= 1 && this.getLibros().contains(p_libro)){
            
                return this.getLibros().remove(p_libro);
     
        }else{
            return false ; 
        }
    
    }*/
    
     
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
    public boolean vencido(Calendar p_fecha){
        
        int diaTotal=this.getFechaRetiro().get(Calendar.DAY_OF_YEAR) + getSocio().getDiasPrestamo();
        
        if(p_fecha.get(Calendar.DAY_OF_YEAR) > diaTotal ){
            return true;
        }else {
            return false; 
        }
        
        
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
        
        //si tiene un libro
        /*String nombreLibro="";
        if(! this.getListaLibro().isEmpty() && this.getListaLibro().size() >= 0){
            nombreLibro=this.getListaLibro().get(0).getTitulo();
        }else{
            nombreLibro=" Sin libro";
        }
        */
         
       
       /*String LibroPrestado="";
       if(this.getLibro().isEmpty() ){
           LibroPrestado="\n ->no posee ningun libro\n"; 
       }else{
       for(Libro e: this.getLibro()){
           LibroPrestado +="\n ->"+e.getTitulo();
       }
      }
      */
        
        return "\nRetiro: " + anio + "/" + mes + "/" + dia +"/" +"-\tDevolucion:"+anioDev+"/"+mesDev+"/"+diaDev+"\nLibro:"+this.getLibro().getTitulo()+"\nSocio:"+getSocio().getNombre();
    }
    
    
}
