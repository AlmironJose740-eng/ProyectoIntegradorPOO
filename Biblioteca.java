import java.util.ArrayList;
import java.util.Calendar;
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

    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.setSocios(new ArrayList<Socio>());
    }

    public Biblioteca(String p_nombre,Libro p_libro,Socio p_socio){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        if(p_socio.soyDeLaClase().equalsIgnoreCase("Estudiante")){
            this.nuevoSocioEstudiante(p_socio);
        }else{
            this.nuevoSocioDocente(p_socio);
        }
        this.setSocios(new ArrayList<Socio>());
        this.nuevoLibro(p_libro);
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

    public void nuevoSocioEstudiante(int p_dniSocio,String p_nombre,String p_carrera){
        Socio socio= new Estudiante(p_dniSocio,p_nombre,p_carrera);
        this.getSocios().add(socio);
    }

    public void nuevoSocioDocente(int p_dniSocio,String p_nombre,String p_area){
        Socio socio= new Docente(p_dniSocio,p_nombre,p_area);
        this.getSocios().add(socio);
    }

    public boolean prestarLibro(Calendar p_fechaRetiro,Socio p_socio,Libro p_libro){
        Libro l1;
        Socio s1;
        
        Calendar devolucion=p_fechaRetiro;
        devolucion.set(Calendar.DAY_OF_MONTH,devolucion.get(Calendar.DAY_OF_MONTH)+s1.getDiasPrestamo());
        Prestamo p1= new Prestamo(p_fechaRetiro,devolucion,l1,s1);

        Socio s1=this.buscarSocio(p_socio.getDni());

        for(Libro l: this.getLibros()){
            if(l.getTitulo()==p_libro.getTitulo()){
                l1=l;
            }
        }

        if(s1.soyDeLaClase().equalsIgnoreCase("Estudiante")){
            if(l1 != null && s1.cantLibrosPrestados()<3 && s1.puedePedir() ){
                s1.AgregarPrestamo(p1);
                return true;
            }
        }else if(s1.soyDeLaClase().equalsIgnoreCase("Docente")){
            if(l1 != null && s1.puedePedir()){
                s1.AgregarPrestamo(p1);
                return true;
            }
        }
        
        return false;
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }