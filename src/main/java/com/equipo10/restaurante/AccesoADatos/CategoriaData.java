
package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian
 */
public class CategoriaData {

   
      private Connection con = null;
      
      public CategoriaData() {
        con = Conexion.getConexion("restaurante");
        }
        public void crearCategoria(Categoria categoria) {
        con=Conexion.getConexion("restaurante");
    }
    
    public int obtenerIdCategoriaPorNombre(String nombreCategoria) {
        int idCategoria = -1; // Valor predeterminado en caso de no encontrar la categoría.

        String sql = "SELECT idCategoria FROM categorias WHERE nombre = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nombreCategoria);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idCategoria = resultSet.getInt("idCategoria");
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la Tabla Categoria");
        }

        return idCategoria;
    }
    
    public Categoria obtenerNombreCategoriaPorId(int idCategoria) {
        Categoria nombreCategoria = null; // Valor predeterminado en caso de no encontrar la categoría.

        String sql = "SELECT * FROM categorias WHERE idCategoria = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, idCategoria);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nombreCategoria = Categoria.valueOf(resultSet.getString("nombre"));
            }
            statement.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error en la Tabla Categoria");
        }

        return nombreCategoria;
    }
    
    public void CargarEnumsABD(){
        ArrayList<String> nombres=new ArrayList<>();
        for (Categoria valor : Categoria.values()) {
            String sql="Select * From Categorias where estado=1";
            try {
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){             
                    nombres.add(rs.getString("nombre"));
                }
                if(!nombres.contains(valor.toString())){
                    CrearCategoria(valor.toString()); 
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error sql");
            }
        }
    }
    
    public void CrearCategoria(String valor){
        String sql="INSERT INTO Categorias (nombre,estado) VALUES (?,1)";
          try {
              PreparedStatement ps=con.prepareStatement(sql);
              ps.setString(1, valor);
              ps.executeUpdate();
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "error sql");
          }
    }
}
