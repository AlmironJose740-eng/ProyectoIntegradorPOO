import java.util.ArrayList;

/**
 * Representa una clase abstracta Socio que almacena la información personal
 * y la gestión de préstamos de un socio de la biblioteca.
 * 
 * @author Lautaro Escalante
 * @version 30/10/2026 23:13
 */
public abstract class Socio{
   private int dniSocio;
   private String nombre;
   protected int diasPrestamo;
   private ArrayList <Prestamo> Prestamos ;
   
   /**
    * Constructor para la clase abstracta Socio que inicializa el DNI, nombre,
    * días de préstamo y crea una lista de préstamos vacía.
    * 
    * @param p_dni Número de DNI del socio.
    * @param p_nombre Nombre del socio.
    * @param p_dias Cantidad de días permitidos de préstamo.
    */
 public Socio(int p_dni,String p_nombre){
        this.setDniSocio(p_dni);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(0);
        this.setPrestamos(new ArrayList<Prestamo>());
   }
    public Socio(int p_dni,String p_nombre,int p_dias){
        this.setDniSocio(p_dni);
        this.setNombre(p_nombre);
        this.setDiasPrestamo(p_dias);
        this.setPrestamos(new ArrayList<Prestamo>());
   }

   
   
   /**
    * Retorna el DNI del socio.
    * 
    * @return int con el número de DNI.
    */
   public int getDniSocio(){
        return this.dniSocio;
   }
   
   /**
    * Establece el DNI del socio.
    * 
    * @param p_dni Nuevo número de DNI a asignar.
    */
   private void setDniSocio(int p_dni){
        this.dniSocio=p_dni;
   }
   
   /**
    * Retorna el nombre del socio.
    * 
    * @return String con el nombre.
    */
   public String getNombre(){
        return this.nombre;
   }
   
   /**
    * Establece el nombre del socio.
    * 
    * @param p_nombre Nuevo nombre a asignar.
    */
   private void setNombre(String p_nombre){
        this.nombre=p_nombre;
   }
   
   /**
    * Retorna los días de préstamo permitidos para el socio.
    * 
    * @return int con la cantidad de días.
    */
   public int getDiasPrestamo(){
        return this.diasPrestamo;
   }
   
   /**
    * Establece los días de préstamo para el socio.
    * 
    * @param p_dias Nueva cantidad de días de préstamo.
    */
   protected void setDiasPrestamo(int p_dias){
        this.diasPrestamo=p_dias;
   }
   
   /**
    * Retorna la lista de préstamos asociados al socio.
    * 
    * @return ArrayList de objetos Prestamo.
    */
   public ArrayList<Prestamo> getPrestamos(){
        return this.Prestamos; 
   }
   
   /**
    * Establece la lista de préstamos del socio.
    * 
    * @param p_prestamo ArrayList de objetos Prestamo a asignar.
    */
   private void setPrestamos(ArrayList <Prestamo> p_prestamo){
        this.Prestamos=p_prestamo; 
   }
   
   // metodos 
   
   /**
    * Agrega un préstamo a la lista de préstamos del socio.
    * 
    * @param p_prestamo Objeto Prestamo a agregar.
    * @return true si se agregó correctamente, false en caso contrario.
    */
   public boolean agregarPrestamo(Prestamo p_prestamo){
       if(this.getPrestamos().contains(p_prestamo)){
        return this.getPrestamos().add(p_prestamo);
       }
       return false ;
}
   
   /**
    * Quita un préstamo de la lista de préstamos del socio.
    * 
    * @param p_prestamo Objeto Prestamo a quitar.
    * @return true si se removió correctamente, false en caso contrario.
    */
   public boolean quitarPrestamo(Prestamo p_prestamo){
        if(this.getPrestamos().size() >= 1){
            if(this.getPrestamos().contains(p_prestamo)){
             return this.getPrestamos().remove(p_prestamo);
            }
       } 
       return false; 
   }
   
   /**
    * Calcula la cantidad total de libros que el socio tiene prestados
    * a través de todos sus préstamos activos o registrados.
    * 
    * @return int con el total de libros prestados.
    */
   public int cantLibrosPrestados(){
        
        int cantidad=0;
        
        for(Prestamo e: this.getPrestamos()){
            cantidad ++; 
        }
        
        return cantidad;
   }
   
   /**
    * Retorna una representación en cadena de caracteres del socio,
    * mostrando su DNI, nombre, tipo de clase y cantidad de libros prestados.
    * 
    * @return String con los datos formateados del socio.
    */
   public String  toString(){
        return "\nDNI: "+this.getDniSocio()+" || "+this.getNombre()+" Area "+this.soyDeLaClase()+"|| Libros Prestados: "+this.cantLibrosPrestados(); 
   }
   
   /**
    * Evalúa si el socio está habilitado para realizar un nuevo préstamo.
    * 
    * @return false por defecto, destinado a ser sobrescrito en las subclases.
    */
   public boolean puedePedir(){
        //aca pongo false dado que puedePedir es un metodo que es heredado a docente y estudiante por lo tanto cada sub clase 
        // la debe re escribir e implementar 
        return false;
   }
   
   /**
    * Método abstracto que retorna una cadena indicando el subtipo o clase concreta del socio.
    * 
    * @return String con el nombre o descripción de la subclase.
    */
   public abstract String soyDeLaClase(); 
   
}
