package biblioteca;

import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:sqlite:biblioteca.db";

    public static Connection obtener() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");   // ayuda a BlueJ a encontrar el driver
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de SQLite", e);
        }
        Connection con = DriverManager.getConnection(URL);
        try (Statement st = con.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return con;
    }

    public static void probar() {
        try (Connection con = obtener()) {
            System.out.println("Conectado a SQLite");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
   public static void mostrarClasspath() {
    System.out.println(System.getProperty("java.class.path"));
}

}