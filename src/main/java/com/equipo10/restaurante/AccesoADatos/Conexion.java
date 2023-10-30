
package com.equipo10.restaurante.AccesoADatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    
    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConexion(String DB) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers! " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la Base de Datos " + ex.getMessage());
        }

        return connection;

    }

    public static int comprobar_acceso(String usuario) {
        try {
            Connection conn = Conexion.getConexion("restologin");

            String sql = "SELECT acceso FROM usuarios where usuario=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                return resultado.getInt("acceso");
            }
        } catch (SQLException ex) {
            ex.fillInStackTrace();
            return -1;
        }
        return -1;
    }

    public static boolean comprobar_datos(String usuario, String pw) {
        try {
            Connection conn = Conexion.getConexion("restologin");

            String sql = "SELECT usuario,contrasenia,estado FROM usuarios";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {
                if (resultado.getString("usuario").equals(usuario) && resultado.getInt("estado") == 1) {
                    if (resultado.getString("contrasenia").equals(pw)) {
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        return false;
                    }
                }
            }

        } catch (SQLException ex) {
            ex.fillInStackTrace();
            return false;
        }
        JOptionPane.showMessageDialog(null, "El usuario no se encuentra Registrdo");
        return false;
    }

    public static void CrearBD() {
        Connection conn = Conexion.getConexion("");
        
        String sql = "CREATE DATABASE IF NOT EXISTS restologin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int res=ps.executeUpdate();
            if(res==1){
                Connection conn2 = Conexion.getConexion("restologin");
                String sql1 = "CREATE TABLE usuarios (id_us INT AUTO_INCREMENT PRIMARY KEY, usuario VARCHAR(255) NOT NULL, contrasenia VARCHAR(255) NOT NULL, estado TINYINT, acceso TINYINT)";
                PreparedStatement ps1=conn2.prepareStatement(sql1);
                ps1.executeUpdate();
                    PreparedStatement ps2=conn2.prepareStatement("Insert into usuarios (usuario,contrasenia,estado,acceso) Values (?,?,?,?)");
                    ps2.setString(1, "admin");
                    ps2.setString(2, "admin");
                    ps2.setBoolean(3, true);
                    ps2.setInt(4, 1);
                    ps2.executeUpdate();
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
