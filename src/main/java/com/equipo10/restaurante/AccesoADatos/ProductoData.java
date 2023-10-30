package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoData {

    private Connection con;

    public ProductoData() {
        this.con = Conexion.getConexion("restaurante");
    }

    public void guardarProcuto(Producto p) {
        String sql = "INSERT INTO producto (idCategoria,Nombre, CantidadenStock, Precio, estado) VALUES (?,?,?,?,?)";
        CategoriaData cat = new CategoriaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cat.obtenerIdCategoriaPorNombre(p.getCategoria().toString()));
            ps.setString(2, p.getNombre());
            ps.setInt(3, p.getCantidadEnStock());
            ps.setDouble(4, p.getPrecio());
            ps.setBoolean(5, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                p.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto cargado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Guardar" + ex.fillInStackTrace());
        }
    }

    public void eliminarProducto(int id) {
        String sql = "UPDATE producto SET estado=0 WHERE idProducto=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int r = ps.executeUpdate();

            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Eliminar");
        }

    }

    public void actualizarProducto(Producto p) {
        String sql = "UPDATE producto SET Nombre=?,CantidadenStock=?,Precio=?,idCategoria=?,estado=? WHERE idProducto=?";
        CategoriaData cat = new CategoriaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCantidadEnStock());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, cat.obtenerIdCategoriaPorNombre(p.getCategoria().toString()));
            ps.setBoolean(5, p.isEstado());
            ps.setInt(6, p.getIdProducto());
            int r = ps.executeUpdate();

            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Producto Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "error al Actualizar");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al Actualizar SQL");
        }

    }

    public Producto TraerProducto(int id) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        CategoriaData cat = new CategoriaData();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(id);
                p.setNombre(rs.getString("Nombre"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setCantidadEnStock(rs.getInt("CantidadenStock"));
                p.setEstado(true);
                p.setCategoria(cat.obtenerNombreCategoriaPorId(rs.getInt("idCategoria")));
                return p;
            } else {
                JOptionPane.showMessageDialog(null, "No existe el producto");
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer el producto");
        }
        return null;
    }

    public List<Producto> listarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE estado = 1";
        ProductoData pd = new ProductoData();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto p;
                p = pd.TraerProducto(rs.getInt(1));
                productos.add(p);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer los productos");
        }
        return productos;
    }
}
