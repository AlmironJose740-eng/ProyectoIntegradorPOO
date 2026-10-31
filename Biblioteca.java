import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        this.setSocios(new ArrayList<Socio>());
        if(p_socio.soyDeLaClase().equalsIgnoreCase("Estudiante")){
            Estudiante e =(Estudiante)p_socio;
            this.nuevoSocioEstudiante(e.getDniSocio(),e.getNombre(),e.getCarrera());
        }else{
            Docente d=(Docente)p_socio;
            this.nuevoSocioDocente(d.getDniSocio(),d.getNombre(),d.getArea());
        }
        this.nuevoLibro(p_libro.getTitulo(),p_libro.getEdicion(),p_libro.getEditorial(),p_libro.getAnio());
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
        if(!p_libro.prestado() && !p_socio.puedePedir()){
            Prestamo p=new Prestamo(p_socio,p_fechaRetiro,p_libro);
            p_socio.agregarPrestamo(p);
            p_libro.agregarPrestamo(p);
            return true;
        }
        return false;
    }

    public void devolverLibro(Libro p_libro)throws LibroNoPrestadoException{
        //prestado devuelve true si el libro esta prestado
        if(p_libro.prestado()){
            p_libro.ultimoPrestamo().registrarFechaDevolucion(new GregorianCalendar());
        }else{
            throw new LibroNoPrestadoException("El libro "+p_libro.getTitulo() +" no se puede devolver ya que se encuentra en la biblioteca");
        }

    }

    public int cantidadDeSociosPorTipo(String p_tipo){
        int contador=0;
        for(Socio s:this.getSocios()){
            if(s.soyDeLaClase()==p_tipo){
                contador++;
            }
        }

        return contador;
    }

    public ArrayList<Prestamo> prestamosVencidos(){
        ArrayList<Prestamo> vencidos=new ArrayList();
        Calendar fechaHoy=new GregorianCalendar();
        for(Libro l:this.getLibros()){
            if(l.prestado()){
                Prestamo p=l.ultimoPrestamo();
                if(p.vencido(fechaHoy)){
                    vencidos.add(p);
                }
            }
        }
        return vencidos;
    }

    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> responsables=new ArrayList();
        for(Socio s:this.getSocios()){
            if(s.soyDeLaClase().equalsIgnoreCase("Docente") && ((Docente)s).esResponsable()){
                responsables.add((Docente)s);
            }
        }

        return responsables;
    }

    public String quienTieneElLibro(Libro p_libro)throws LibroNoPrestadoException{
        if(p_libro.prestado()){
            return p_libro.ultimoPrestamo().getSocio().getNombre();
        }
        throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
    }

    public Socio buscarSocio(int p_dni){
        for(Socio s:this.getSocios()){
            if(s.getDniSocio()==p_dni){
                return s;
            }
        }
        return null;
    }

    public String listaDeSocios(){
        StringBuilder sd=new StringBuilder();
        int num=1;

        sd.append("Lista Socios: \n");

        for(Socio s:this.getSocios()){
            sd.append(num).append(")").append(s.toString()).append("\n");
            num++;
        }

        sd.append("******************************************************").append("\n");
        sd.append("Cantidad de socios del tipo Estudiante:").append(this.cantidadDeSociosPorTipo("Estudiante")).append("\n");
        sd.append("Cantidad de socios del tipo Docente:").append(this.cantidadDeSociosPorTipo("docente")).append("\n");
        sd.append("******************************************************").append("\n");

        return sd.toString();
    }

    public String listaDeLibros(){
        StringBuilder sd=new StringBuilder();
        int contador=1;
        sd.append("Lista de Libros:").append("\n");

        for(Libro l:this.getLibros()){
            sd.append(contador).append(")").append(l.toString()).append(" ||Prestado: (").append(l.prestado() ? "si": "No").append(")\n");
            contador++;
        }
        return sd.toString();
    }

    public String listaTitulos(){
        Set<String> titulosUnicos=new LinkedHashSet<>();

        for(Libro l:this.getLibros()){
            titulosUnicos.add(l.getTitulo());
        }

        StringBuilder sd=new StringBuilder();

        sd.append("Lista de Titulos:").append("\n");

        for(String t:titulosUnicos){
            sd.append("-Titulo:").append(t).append("\n");
        }

        return sd.toString();
    }

    public String listarDocentesResponsables(){
        StringBuilder sd=new StringBuilder();

        sd.append("  Listar Docentes Responsables").append("\n");

        for(Docente d:this.docentesResponsables()){
            sd.append("*").append(d.toString()).append("\n");
        }

        return sd.toString();
    }

    
    
}