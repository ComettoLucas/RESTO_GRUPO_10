package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Mesa;
import com.equipo10.restaurante.Entidades.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MesaData {

    private final ReservaData res = new ReservaData();
    private Connection con = null;

    public MesaData() {
        con = Conexion.getConexion("restaurante");
    }

   public void guardarMesa(Mesa mesa) {
    PreparedStatement ps;
       try {
            String sql = "INSERT INTO mesa (capacidad, estado, idReserva) VALUES (?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, mesa.getCapacidad());
            ps.setBoolean(2, mesa.isEstado());
            if (mesa.getIdReserva() != null) {
                ps.setInt(3, mesa.getIdReserva().getIdReserva());
            } else {
                ps.setNull(3, Types.INTEGER); // Usar setNull para indicar un valor NULL
            }
       
        int end = ps.executeUpdate();

        if (end == 1) {
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la Mesa.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar Mesa: " + ex.getMessage());
    }
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
                //falta el numero de mesa columna 2
                mesa.setCapacidad(rs.getInt(3));
                mesa.setEstado(rs.getBoolean(4));
                mesa.setEliminada(rs.getBoolean(6));
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
