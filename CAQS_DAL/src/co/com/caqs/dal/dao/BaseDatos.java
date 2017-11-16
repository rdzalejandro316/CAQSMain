package co.com.caqs.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static Connection connect = null;
    private static BaseDatos INSTANCE = null;

    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String bd = "caqs";
    private static final String url = "jdbc:mysql://localhost/" + bd;

    private BaseDatos() {

        try {
            Class.forName(driver);
            connect = DriverManager.getConnection(url, user, password);
            if (connect != null) {
                System.out.println("conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public static Connection getConexion() {
        if (connect == null) {
            INSTANCE = new BaseDatos();  // patron singleton
        }
        return connect;
    }

    public void desconectar() {
        connect = null;
        if (connect == null) {
            System.out.println("conexion terminada");
        }
    }
}
