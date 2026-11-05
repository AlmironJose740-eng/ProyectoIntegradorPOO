package biblioteca;
/**
 * Write a description of class GestionBiblioteca here.
 * 
 * @author Todos 
 * @version (a version number or a date)
 */
public class GestionBiblioteca{
    public static void main(String args[]){
        Biblioteca unaBiblioteca = new Biblioteca("Biblioteca Mariño");
        int cantidad = unaBiblioteca.cantidadDeSociosPorTipo("Estudiante"); //guardo la cant de socios de tipo estudiante
        System.out.println("Cantidad de estudiantes: " + cantidad);
        
    }
}