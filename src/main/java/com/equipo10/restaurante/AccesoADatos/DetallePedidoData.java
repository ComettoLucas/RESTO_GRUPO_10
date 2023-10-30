/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Categoria;
import com.equipo10.restaurante.Entidades.DetallePedido;
import com.equipo10.restaurante.Entidades.Pedido;
import com.equipo10.restaurante.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class DetallePedidoData {

    /*nsertas el detalle del producto en la tabla pedidodetalle utilizando el ID del pedido existente en el argumento pedido*/
    private Connection con = null;

    public DetallePedidoData() {
        con = Conexion.getConexion("restaurante");
    }

    public void crearCategoria(Categoria categoria) {
        con = Conexion.getConexion("restaurante");
    }

    public void agregarProductoAlDetalle(Pedido pedido, DetallePedido detalle) {
        String insertDetalleSQL = "INSERT INTO pedidodetalle (id_pedido, id_producto, totalpedido, cantidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(insertDetalleSQL)) {

            PreparedStatement insertDetalleStmt = con.prepareStatement(insertDetalleSQL);
            insertDetalleStmt.setInt(1, pedido.getIdPedido()); // Utiliza el ID del pedido existente
            insertDetalleStmt.setInt(2, detalle.getIdProducto());
            insertDetalleStmt.setDouble(3, detalle.getTotalPedido());
            insertDetalleStmt.setInt(4, detalle.getCantidad());
            insertDetalleStmt.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double calcularTotalPedido(int idPedido) {
        double total = 0;
        String sql = "SELECT producto.Precio, pedidodetalle.cantidad FROM pedidodetalle JOIN producto ON pedidodetalle.idProducto = producto.idProducto WHERE pedidodetalle.idPedido = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total += rs.getDouble("Precio") * rs.getInt("cantidad");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error consulta sql al traer total");
        }
        return total;
    }
    public void agregarDetallePedido(DetallePedido detalle) {
        ProductoData pd = new ProductoData();
        Producto p = pd.TraerProducto(detalle.getIdProducto());
        if (p.getCantidadEnStock() >= detalle.getCantidad() && detalle.getCantidad() != 0) {
            String insertDetalleSQL = "INSERT INTO pedidodetalle (idPedido, idProducto, totalPedido, cantidad) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement ps = con.prepareStatement(insertDetalleSQL);
                ps.setInt(1, detalle.getPedido().getIdPedido());
                ps.setInt(2, detalle.getIdProducto());
                ps.setDouble(3, detalle.getTotalPedido());
                ps.setInt(4, detalle.getCantidad());
                ps.executeUpdate();
                PreparedStatement ps1 = con.prepareStatement("Update Producto Set CantidadenStock =CantidadenStock - ? where idProducto=?");
                ps1.setInt(1, detalle.getCantidad());
                ps1.setInt(2, detalle.getIdProducto());
                ps1.executeUpdate();
                ps1.close();
                ps.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay stock para el producto " + p.getNombre());
        }

    }

    public List<DetallePedido> obtenerDetalleXPedido(Pedido pedido) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM pedidodetalle WHERE idPedido = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,pedido.getIdPedido());
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                DetallePedido dp = new DetallePedido();
                dp.setIdDetalle(rs.getInt(1));
                dp.setPedido(pedido);
                dp.setIdProducto(rs.getInt(3));
                dp.setTotalPedido(rs.getDouble(4));
                dp.setCantidad(rs.getInt(5));
                
                lista.add(dp);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return lista;
    }

    public int ultimo() {
        int ultimo = 1;
        String sql = "SELECT MAX(idPedidoDetalle) FROM pedidodetalle";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getObject(1) != null) {
                    ultimo = rs.getInt(1) + 1;
                }
            }ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return ultimo;
    }

    public boolean verificarPedidosEnDetalles(int idPedido) {
        String sql = "SELECT idPedido FROM pedidodetalle where idPedido=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            ps.close();
        } catch (SQLException ex) {

        }
        return false;
    }
 public List<DetallePedido> obtenerProductosDeLaMesa(int idMesa){
     Pedido pedido = new Pedido();
     PedidoData pd = new PedidoData();
// Creo un objeto DetallePedido con la información
                
     List<DetallePedido> listaDetallePedido = new ArrayList<>();
 String consulta=  "SELECT pd.idPedidoDetalle, pd.idPedido, pd.idProducto, pd.totalPedido, pd.cantidad, pr.precio\n" +
"FROM pedidoDetalle pd\n" +
"JOIN pedido p ON pd.idPedido = p.idPedido\n" +
"JOIN producto pr ON pd.idProducto = pr.idProducto\n" +
"WHERE p.idMesa = ? AND pagado=0;"; 
  try {             
            PreparedStatement ps = con.prepareStatement(consulta);
            ps.setInt(1, idMesa);
            ResultSet resultados = ps.executeQuery();

            // Procesar los resultados
            while (resultados.next()) {
                int idPedidoDetalle = resultados.getInt("idPedidoDetalle");
                int idPedido = resultados.getInt("idPedido");
                int idProducto = resultados.getInt("idProducto");
                double totalPedido = resultados.getDouble("totalPedido");
                int cantidad = resultados.getInt("cantidad");
                double precio = resultados.getDouble("precio");
                
               DetallePedido detalle = new DetallePedido();
                detalle.setIdDetalle(idPedidoDetalle);
                detalle.setIdProducto(idProducto);
                detalle.setCantidad(cantidad);
                detalle.setPedido(pd.buscarPedido(idPedido));
                detalle.setTotalPedido(totalPedido);

                listaDetallePedido.add(detalle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con!= null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
  return listaDetallePedido;
 }
}
