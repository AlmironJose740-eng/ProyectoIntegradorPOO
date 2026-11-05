package biblioteca;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class GestionBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Mariño");
        cargarSocios(biblioteca);
        cargarLibros(biblioteca);
        probarPrestamos(biblioteca);
    }

    private static void cargarSocios(Biblioteca b) {
        b.nuevoSocioEstudiante(347819324, "Juan Gomez", "Lic. Sistemas");
        b.nuevoSocioEstudiante(654324554, "Esteban Qiton", "Lic. Bellas Artes");
        b.nuevoSocioEstudiante(790235454, "Juana Fernandez", "Lic. Nutricion");
        b.nuevoSocioDocente(562245643, "Carlos Ponce", "Datos");
        b.nuevoSocioDocente(445436332, "Rosa Fernandez", "Literatura");
    }

    private static void cargarLibros(Biblioteca b) {
        b.nuevoLibro("Harry Potter y la piedra filosofal", 4, "Bloomsbury", 1997);
        b.nuevoLibro("Harry Potter y la piedra filosofal", 4, "Bloomsbury", 1997);
        b.nuevoLibro("Programando con JAVA", 1, "Editorial X", 2015);
        b.nuevoLibro("El señor de los anillos", 5, "Allen & Unwin", 1954);
    }

    private static void probarPrestamos(Biblioteca b) {
        Calendar hoy = new GregorianCalendar();

        Socio estudiante = b.buscarSocio(347819324);
        Socio docente = b.buscarSocio(562245643);
        if (estudiante == null || docente == null) {
            System.out.println("Falta cargar un socio");
            return;
        }
        Libro libro1 = b.getLibros().get(0);
        Libro libro2 = b.getLibros().get(1);

        System.out.println("1. Estudiante (esperado true): " + b.prestarLibro(hoy, estudiante, libro1));
        System.out.println("2. Docente (esperado true): " + b.prestarLibro(hoy, docente, libro2));
        System.out.println("3. Libro ya prestado (esperado false): " + b.prestarLibro(hoy, docente, libro1));

        try {
            System.out.println("libro1 lo tiene: " + b.quienTieneElLibro(libro1));
            System.out.println("libro2 lo tiene: " + b.quienTieneElLibro(libro2));
        } catch (LibroNoPrestadoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(b.listaDeSocios());
    }
}