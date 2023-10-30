package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.Entidades.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MesaData {

    private final ReservaData res = new ReservaData();
    private Connection con = null;

    public MesaData() {
        con = Conexion.getConexion("restaurante");
    }

   public void insertarMesas(int num) {
       for (int i = 0; i < num; i++) {
           while(comprobarSiHayMenosDe10Mesas()){
           PreparedStatement ps;
       try {
            String sql = "INSERT INTO mesa (capacidad, estado) VALUES (?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setBoolean(2, false);   
        int end = ps.executeUpdate();

        if (end == 0) {
             JOptionPane.showMessageDialog(null, "error al cargar las mesas");
            
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar Mesa: " + ex.getMessage());
    }}
       }
       JOptionPane.showMessageDialog(null, "Mesas cargadas");
       
}
   public boolean comprobarSiHayMenosDe10Mesas(){
       String sql="SELECT  COUNT(*) AS filas FROM Mesa";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(rs.getInt(1)<10){
                    return true;
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MesaData.class.getName()).log(Level.SEVERE, null, ex);
        }
       return false;
   }

    public List<Mesa> obtenerMesas(int num) {
        List<Mesa> lista = new ArrayList<>();
        Mesa mesa = new Mesa();
        try {
            if (num == 1) {
                String sql = "SELECT * FROM mesa WHERE estado = 1";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    mesa = buscarMesa(rs.getInt(1));

                    lista.add(mesa);
                    ps.close();
                }
            } else if (num == 0) {
                String sql = "SELECT * FROM mesa WHERE estado = 0";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    mesa = buscarMesa(rs.getInt(1));

                    lista.add(mesa);
                }
                ps.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las Mesas: " + ex.getMessage());
        }
        return lista;
    }
    public List<Mesa> obtenerTodasMesas() {
        List<Mesa> lista = new ArrayList<>();
        Mesa mesa = new Mesa();
        try {
                String sql = "SELECT * FROM mesa";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    mesa = buscarMesa(rs.getInt(1));
                    lista.add(mesa);
                }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las Mesas: " + ex.getMessage());
        }
        return lista;
    }
    
     public List<Mesa> obtenerTodasMesasSinReservas() {
        List<Mesa> lista = new ArrayList<>();
        Mesa mesa = new Mesa();
        try {
                String sql = "SELECT * FROM mesa WHERE idReserva is null;";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    mesa = buscarMesa(rs.getInt(1));
                    lista.add(mesa);
                }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las Mesas: " + ex.getMessage());
        }
        return lista;
    }
     
    public List<Mesa> obtenerTodasMesasConReservas() {
        List<Mesa> lista = new ArrayList<>();
        Mesa mesa = new Mesa();
        try {
                String sql = "SELECT * FROM mesa WHERE idReserva is not null;";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    mesa = buscarMesa(rs.getInt(1));
                    lista.add(mesa);
                }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las Mesas: " + ex.getMessage());
        }
        return lista;
    }
    
    public Mesa buscarMesa(int idMesa) {
        Mesa mesa = new Mesa();
        try {
            String sql = "SELECT * FROM mesa WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mesa.setIdMesa(rs.getInt(1)); //2 es numero
                mesa.setCapacidad(rs.getInt(2));
                mesa.setEstado(rs.getBoolean(3));
                int idReserva = rs.getInt("idReserva");
                if (!rs.wasNull()) {
                    Reserva reserva = res.buscarReserva(idReserva);
                    mesa.setIdReserva(reserva);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Mesa: " + ex.getMessage());
        }
        return mesa;
    }
    public void AbrirMesaxNRO(Mesa mesa) {
        try {
            String sql = "UPDATE mesa SET estado = 1 WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            int end = ps.executeUpdate();
            if (end == 1) {
               // JOptionPane.showMessageDialog(null, "Mesa Abierta.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo abrir la Mesa.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Abrir la Mesa: " + ex.getMessage());
        }
    }
    public void CerrarMesaxNRO(Mesa mesa) {
        try {
            String sql = "UPDATE mesa SET estado = 0 WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getIdMesa());
            int end = ps.executeUpdate();
            if (end == 1) {
                JOptionPane.showMessageDialog(null, "Mesa Cerrada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo Cerrar la Mesa.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Cerrar la Mesa: " + ex.getMessage());
        }
    }
    
    public void agregarIdReserva(int mesaId, int idReserva) {
        try {
            String sql = "UPDATE mesa SET idReserva = ? WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idReserva);
            ps.setInt(2, mesaId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar ID de reserva a la mesa: " + ex.getMessage());
        }
    }

    public Mesa buscarMesaxNRO(int idMesa) {
        Mesa mesa = new Mesa();
        try {
            String sql = "SELECT * FROM mesa WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mesa.setIdMesa(rs.getInt(1));
                mesa.setCapacidad(rs.getInt(2));
                mesa.setEstado(rs.getBoolean(3));
                int idReserva = rs.getInt("idReserva");
                if (!rs.wasNull()) {
                    Reserva reserva = res.buscarReserva(idReserva);
                    mesa.setIdReserva(reserva);
                }
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Mesa: " + ex.getMessage());
        }
        return mesa;
    }
}
