package biblioteca;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Representa una biblioteca encargada de administrar el registro de libros, 
 * socios (estudiantes y docentes) y la gestión de préstamos.
 * 
 * @author Almiron Jose, Gomez Diego, Almiron Franco
 * @version 1.0
 */
public class Biblioteca
{
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Socio> socios;

    /**
     * Constructor que inicializa la biblioteca con un nombre, una lista de libros y una lista de socios dadas.
     * 
     * @param p_nombre Nombre de la biblioteca.
     * @param p_libros Colección inicial de libros.
     * @param p_socios Colección inicial de socios.
     */
    public Biblioteca(String p_nombre, ArrayList<Libro> p_libros, ArrayList<Socio> p_socios){
        this.setNombre(p_nombre);
        this.setLibros(p_libros);
        this.setSocios(p_socios);
    }

    /**
     * Constructor que inicializa la biblioteca con un nombre y colecciones vacías de libros y socios.
     * 
     * @param p_nombre Nombre de la biblioteca.
     */
    public Biblioteca(String p_nombre){
        this.setNombre(p_nombre);
        this.setLibros(new ArrayList<Libro>());
        this.setSocios(new ArrayList<Socio>());
    }

    /**
     * Constructor que inicializa la biblioteca con un nombre, un libro inicial y un socio inicial.
     * 
     * @param p_nombre Nombre de la biblioteca.
     * @param p_libro Libro inicial a registrar.
     * @param p_socio Socio inicial a registrar (Estudiante o Docente).
     */
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

    /**
     * Establece el nombre de la biblioteca.
     * 
     * @param p_nombre Nuevo nombre de la biblioteca.
     */
    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    /**
     * Establece la colección de libros de la biblioteca.
     * 
     * @param p_libros Nueva colección de libros.
     */
    private void setLibros(ArrayList<Libro> p_libros){
        this.libros = p_libros;
    }

    /**
     * Establece la colección de socios de la biblioteca.
     * 
     * @param p_socios Nueva colección de socios.
     */
    private void setSocios(ArrayList<Socio> p_socios){
        this.socios = p_socios;
    }

    /**
     * Retorna el nombre de la biblioteca.
     * 
     * @return El nombre de la biblioteca.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Retorna la colección de libros de la biblioteca.
     * 
     * @return ArrayList con los libros registrados.
     */
    public ArrayList<Libro> getLibros(){
        return this.libros;
    }

    /**
     * Retorna la colección de socios de la biblioteca.
     * 
     * @return ArrayList con los socios registrados.
     */
    public ArrayList<Socio> getSocios(){
        return this.socios;
    }

    /**
     * Crea y agrega un nuevo libro a la colección de la biblioteca.
     * 
     * @param p_titulo Título del libro.
     * @param p_edicion Número de edición.
     * @param p_editorial Editorial del libro.
     * @param p_anio Año de publicación.
     */
    public void nuevoLibro(String p_titulo, int p_edicion, String p_editorial, int p_anio){
        Libro libro = new Libro(p_titulo, p_edicion, p_editorial, p_anio);
        this.getLibros().add(libro);
    }

    /**
     * Crea y agrega un nuevo socio de tipo Estudiante a la biblioteca.
     * 
     * @param p_dniSocio DNI del estudiante.
     * @param p_nombre Nombre y apellido del estudiante.
     * @param p_carrera Carrera que cursa.
     */
    public void nuevoSocioEstudiante(int p_dniSocio,String p_nombre,String p_carrera){
        Socio socio= new Estudiante(p_dniSocio,p_nombre,p_carrera);
        this.getSocios().add(socio);
    }

    /**
     * Crea y agrega un nuevo socio de tipo Docente a la biblioteca.
     * 
     * @param p_dniSocio DNI del docente.
     * @param p_nombre Nombre y apellido del docente.
     * @param p_area Área o departamento al que pertenece.
     */
    public void nuevoSocioDocente(int p_dniSocio,String p_nombre,String p_area){
        Socio socio= new Docente(p_dniSocio,p_nombre,p_area);
        this.getSocios().add(socio);
    }

    /**
     * Realiza el préstamo de un libro a un socio si el libro no está prestado y el socio cumple las condiciones.
     * 
     * @param p_fechaRetiro Fecha en la que se efectúa el retiro.
     * @param p_socio Socio que solicita el préstamo.
     * @param p_libro Libro a ser prestado.
     * @return true si el préstamo se pudo realizar, false en caso contrario.
     */
    public boolean prestarLibro(Calendar p_fechaRetiro,Socio p_socio,Libro p_libro){
        if(!p_libro.prestado() && p_socio.puedePedir()){
            Prestamo p=new Prestamo(p_socio,p_fechaRetiro,p_libro);
            p_socio.agregarPrestamo(p);
            p_libro.getPrestamos().add(p);
            //p_libro.agregarPrestamo(p);
            return true;
        }
        return false;
    }

    /**
     * Registra la devolución de un libro prestado asignándole la fecha actual.
     * 
     * @param p_libro Libro que se desea devolver.
     * @throws LibroNoPrestadoException Si el libro no se encuentra prestado actualmente.
     */
    public void devolverLibro(Libro p_libro)throws LibroNoPrestadoException{
        //prestado devuelve true si el libro esta prestado
        if(p_libro.prestado()){
            p_libro.ultimoPrestamo().registrarFechaDevolucion(new GregorianCalendar());
        }else{
            throw new LibroNoPrestadoException("El libro "+p_libro.getTitulo() +" no se puede devolver ya que se encuentra en la biblioteca");
        }

    }

    /**
     * Devuelve la cantidad de socios registrados según el tipo especificado ("Estudiante" o "Docente").
     * 
     * @param p_tipo Tipo de socio a filtrar.
     * @return Cantidad de socios de dicho tipo.
     */
    public int cantidadDeSociosPorTipo(String p_tipo){
        int contador=0;
        for(Socio s:this.getSocios()){
            if(s.soyDeLaClase().equalsIgnoreCase(p_tipo)){
                contador++;
            }
        }

        return contador;
    }

    /**
     * Retorna una colección con todos los préstamos que se encuentran vencidos a la fecha actual.
     * 
     * @return ArrayList de objetos Prestamo vencidos.
     */
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

    /**
     * Retorna una colección con los docentes que son considerados responsables (nunca han adeudado libros).
     * 
     * @return ArrayList de objetos Docente responsables.
     */
    public ArrayList<Docente> docentesResponsables(){
        ArrayList<Docente> responsables=new ArrayList();
        for(Socio s:this.getSocios()){
            if(s.soyDeLaClase().equalsIgnoreCase("Docente") && ((Docente)s).esResponsable()){
                responsables.add((Docente)s);
            }
        }

        return responsables;
    }

    /**
     * Consulta qué socio tiene en su poder un determinado libro.
     * 
     * @param p_libro Libro a consultar.
     * @return El nombre del socio que tiene el libro.
     * @throws LibroNoPrestadoException Si el libro se encuentra en la biblioteca (no está prestado).
     */
    public String quienTieneElLibro(Libro p_libro)throws LibroNoPrestadoException{
        if(p_libro.prestado()){
            return p_libro.ultimoPrestamo().getSocio().getNombre();
        }
        throw new LibroNoPrestadoException("El libro se encuentra en la biblioteca");
    }

    /**
     * Busca y retorna un socio según su número de DNI.
     * 
     * @param p_dni DNI del socio a buscar.
     * @return El objeto Socio encontrado, o null si no existe.
     */
    public Socio buscarSocio(int p_dni){
        for(Socio s:this.getSocios()){
            if(s.getDniSocio()==p_dni){
                return s;
            }
        }
        return null;
    }

    /**
     * Genera un reporte formateado con la lista de socios y las cantidades según su tipo (Formato 1).
     * 
     * @return String con el listado completo de socios.
     */
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
        sd.append("Cantidad de socios del tipo Docente:").append(this.cantidadDeSociosPorTipo("Docente")).append("\n");
        sd.append("******************************************************").append("\n");

        return sd.toString();
    }

    /**
     * Genera un reporte formateado con la lista de todos los libros y su estado de préstamo (Formato 2).
     * 
     * @return String con el listado de libros.
     */
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

    /**
     * Genera un reporte con los títulos únicos con los que cuenta la biblioteca, sin repetir.
     * 
     * @return String con la lista de títulos únicos.
     */
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

    /**
     * Genera un reporte con el listado de docentes responsables (Formato 3).
     * 
     * @return String con el listado formateado de docentes responsables.
     */
    public String listarDocentesResponsables(){
        StringBuilder sd=new StringBuilder();

        sd.append("Lista De Docentes Responsables").append("\n");

        for(Docente d:this.docentesResponsables()){
            sd.append("*").append(d.toString()).append("\n");
        }

        return sd.toString();
    }
}