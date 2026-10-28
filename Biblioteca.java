import java.util.ArrayList;
/**
 * Write a description of class Biblioteca here.
 * 
 * @author Almiron Jose, Gomez Diego, Almiron Franco
 * @version (a version number or a date)
 */
public class Biblioteca
{
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;
    
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros, ArrayList<Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(p_socios);
    }
    
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros, int p_dniSocio, String p_nombreSocio, String p_carrera, String p_area){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(new ArrayList<Socio>());
        /*
        if(p_carrera != "" && p_area != ""){
            System.out.println("No se puede cargar este socio.!!");
        }else if(p_carrera != "" && p_area == ""){
            this.nuevoSocioEstudiante(p_dniSocio, p_nombreSocio, p_carrera);
        }else if(p_carrera == "" && p_area != ""){
            this.nuevoSocioDocente(p_dniSocio, p_nombreSocio, p_area);
        }else if(p_carrera == "" && p_area == ""){
            System.out.println("No se puede cargar este socio.!!");
        }*/
    }
    
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(new ArrayList<Socio>());
    }
    
    public Biblioteca(String p_nombre, String p_titulo, int p_edicion, String p_editorial, int p_anio,  ArrayList<Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.setSocios(p_socios);
        this.nuevoLibro(p_titulo, p_edicion, p_editorial, p_anio);
    }
    
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }
    
    private void setSocios(ArrayList<Socio> p_socios){
        this.socios = p_socios;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }
    
    public ArrayList<Socio> getSocios(){
        return this.socios;
    }
    
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        Libro libro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.getLibros().add(libro);
    }
}