package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.Entidades.Mesero;
import com.equipo10.restaurante.Entidades.Pedido;
import com.equipo10.restaurante.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PedidoData {

    private Connection con = null;
    private final MesaData md = new MesaData();
    private MeseroData me = new MeseroData();

    public PedidoData() {
        con = Conexion.getConexion("restaurante");
    }
    int idPedido;

    public void agregarPedido(Pedido pedido) {

        String sql = "INSERT INTO pedido (idMesa, idMesero, entregado, pagado,estado) VALUES ( ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            //ps.setInt(1, pedido.getIdPedido());
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setBoolean(3, pedido.isEntregado());
            ps.setBoolean(4, pedido.isPagado());
            ps.setBoolean(5, pedido.isEstado());
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar pedido ");
        }
    }

    public int getIdPedido() {
        return idPedido;
    }
    
    public void setearEntregado(boolean f,int id){
        String sql = "UPDATE pedido SET entregado= ? WHERE idPedido = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setBoolean(1, f);
            ps.setInt(2, id);
            ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET mesa = ? , mesero = ?, detalle = ?, entregado= ?, pagado= ? WHERE idPedido = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getMesa().getIdMesa());
            ps.setInt(2, pedido.getMesero().getIdMesero());
            ps.setBoolean(3, pedido.isEntregado());
            ps.setBoolean(4, pedido.isPagado());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro pedido");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al pedido ");
        }

    }

    public void CerrarPedido(int id) {
        try {
            String sql = "UPDATE pedido SET estado=0 , pagado=1 WHERE idPedido = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó pedido.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder al pedido");
        }
    }

    public Pedido buscarPedidoXidMesa(int numMesa) {
        Pedido pedido = new Pedido();
        String sql = "SELECT * FROM pedido WHERE idMesa=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, numMesa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(md.buscarMesa(rs.getInt("idMesa")));
                pedido.setMesero(new Mesero(rs.getInt("idMesero")));
                pedido.setEntregado(rs.getBoolean("entregado"));
                pedido.setPagado(rs.getBoolean("pagado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe pedido");

            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos");
        }

        return pedido;
    }
    /// este podes cambiar

    public List<Pedido> obtenerPedidosXidMesa(int idMesa) {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido where idMesa=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setMesa(md.buscarMesa(rs.getInt("idMesa")));
                pedido.setMesero(new Mesero(rs.getInt("idMesero")));
                pedido.setEntregado(rs.getBoolean("entregado"));
                pedido.setPagado(rs.getBoolean("pagado"));
                pedido.setPagado(rs.getBoolean("Estado"));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder ");
        }
        return pedidos;
    }

    public List<Pedido> listarPedido() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE estado = 1 AND anulado IS NULL;";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido;

                pedido = buscarPedido(rs.getInt(1));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos.");
        }

        return pedidos;
    }

    public List<Pedido> listarPedidoNoEntregados() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE entregado = 0 AND estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido;

                pedido = buscarPedido(rs.getInt(1));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos.");
        }

        return pedidos;
    }

    public List<Pedido> listarPedidoEntregado() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE entregado = 1 AND estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido;

                pedido = buscarPedido(rs.getInt(1));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos.");
        }

        return pedidos;
    }

    public List<Pedido> listarPedidoPagado() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE pagado = 1 AND estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido;

                pedido = buscarPedido(rs.getInt(1));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos.");
        }

        return pedidos;
    }
    

    public List<Pedido> listarPedidoNoPagado() {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido WHERE pagado = 0 AND estado=1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido pedido;

                pedido = buscarPedido(rs.getInt(1));
                pedidos.add(pedido);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a pedidos.");
        }

        return pedidos;
    }

    public void agregarProductoAlPedido(int idPedido, int idProducto, int cantidad) {
        String sql = "INSERT INTO pedidodetalle (idPedido,idProducto,cantidad) Values (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            int r = ps.executeUpdate();
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Producto Añadido");

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en sql");
        }
    }


    public ArrayList<Integer> buscarPedidosxIDMesa(Mesa m) {
        ArrayList<Integer> pedidos = new ArrayList<>();
        String sql = "SELECT pedido.idPedido FROM pedido where idMesa=? AND estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getIdMesa());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedidos.add(rs.getInt("idPedido"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public ArrayList<Integer> buscarPedidosxNumeroMesa(int m) {
        ArrayList<Integer> pedidos = new ArrayList<>();
        MesaData me = new MesaData();
        Mesa mesa = me.buscarMesaxNRO(m);
        String sql = "SELECT pedido.idPedido FROM pedido where idMesa=? AND estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pedidos.add(rs.getInt("idPedido"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }

    public ArrayList<Producto> listarProductosDeLaMesa(int m) {
        ArrayList<Producto> productos = new ArrayList<>();
        CategoriaData cat = new CategoriaData();
        for (int id : buscarPedidosxNumeroMesa(m)) {
            for (Producto p : listarProductosDelPedido(id)) {
                productos.add(p);
            }
        }
        return productos;
    }
  
    public ArrayList<Producto> listarProductosDelPedido(int idPedido) {
        ArrayList<Producto> productos = new ArrayList<>();
        CategoriaData cat = new CategoriaData();
        String sql = "Select Producto.*,cantidad FROM Producto JOIN pedidodetalle ON (pedidodetalle.idProducto=Producto.idProducto) WHERE pedidodetalle.idPedido =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setCategoria(cat.obtenerNombreCategoriaPorId(rs.getInt("idCategoria")));
                p.setNombre(rs.getString("Nombre"));
                p.setCantidadEnStock(rs.getInt("CantidadEnStock"));
                p.setPrecio(rs.getDouble("Precio"));
                p.setEstado(rs.getBoolean("estado"));
                productos.add(p);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error consulta sql");
        }
        return productos;
    }

    public int ultimo() {
        int ultimo=1;
        String sql = "SELECT MAX(idPedido) FROM pedido";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getObject(1) != null) {
                    ultimo = rs.getInt(1) + 1;
                }
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return ultimo;
    }

    public Pedido buscarPedido(int id) {
        Pedido pedido = new Pedido();
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
                pedido.setMesa(md.buscarMesa(rs.getInt(2)));
                pedido.setMesero(me.buscarMozoxId(rs.getInt(3)));
                pedido.setEntregado(rs.getBoolean(4));
                pedido.setPagado(rs.getBoolean(5));
                pedido.setEstado(rs.getBoolean(6));
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar pedido" + ex.getMessage());
        }
        return pedido;
    }
    
    public void anularPedido(int id){
        try {
            String sql = "UPDATE pedido SET anulado=1 WHERE idPedido = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se anulo el pedido.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder al pedido");
        }
    }
    
    public ArrayList<Pedido> ListarPedidosDeLaMesa(Mesa m) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        String sql = "SELECT idPedido FROM pedido WHERE idMesa = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, m.getIdMesa());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p;
                
                p = buscarPedido(rs.getInt(1));
                
                pedidos.add(p);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error consulta sql");
        }
        return pedidos;
    }
}
