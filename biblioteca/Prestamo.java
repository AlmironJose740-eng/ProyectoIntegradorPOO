package biblioteca;

import java.util.Calendar;

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
    private Socio libroSocio; 
    private Libro libros;
    
    /**
     * Constructor para la clase Prestamo que inicializa las fechas de retiro y devolución,
     * y crea una lista de libros vacía.
     * 
     * @param p_fechaR Objeto Calendar que representa la fecha de retiro.
     * @param p_fechaDev Objeto Calendar que representa la fecha de devolución.
     */
    
    
  
    public Prestamo(Socio p_socio,Calendar p_Retiro, Libro p_libro){
        this.setFechaDevolucion(null);
        this.setSocio(p_socio); 
        this.setFechaRetiro(p_Retiro);
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
        
     Calendar fechaVencimiento = Calendar.getInstance(); 
     fechaVencimiento.setTime(this.getFechaRetiro().getTime());
     fechaVencimiento.add(Calendar.DAY_OF_MONTH,this.getSocio().getDiasPrestamo());
    //true = vencio, false= no vencio 
     return p_fecha.after(fechaVencimiento);  
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
        
        String RtaDevolucion= "No devuelto"; 
         if(this.getFechaDevolucion() != null ){
        int diaDev=this.getFechaDevolucion().get(Calendar.DAY_OF_MONTH);
        int mesDev=this.getFechaDevolucion().get(Calendar.MONTH)+1;
        int anioDev=this.getFechaDevolucion().get(Calendar.YEAR);
        
        RtaDevolucion = diaDev+"/"+mesDev+"/"+anioDev;
       }
        
        
        
        
        return "\nRetiro: " + anio + "/" + mes + "/" + dia +"-\tDevolucion:"+RtaDevolucion+"\nLibro:"+this.getLibro().getTitulo()+"\nSocio:"+getSocio().getNombre();
    }
}
