package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Reserva;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ReservaData {

    private Connection con;

    public ReservaData() {
        con = Conexion.getConexion("restaurante");
    }

    public void guardarReserva(Reserva res) {
        String sql = "INSERT INTO reserva (idReserva, nombreApellido, dni, fechaHora, estado) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, res.getIdReserva());
            ps.setString(2, res.getNombreApellido());
            ps.setInt(3, res.getDni());
            ps.setDate(4, Date.valueOf(res.getFechaHora()));
            ps.setBoolean(5, res.isEstado());
            int end = ps.executeUpdate();
            if (end == 1) {
                JOptionPane.showMessageDialog(null, "Reserva Guardada");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar Reserva");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Reserva: " + ex.getMessage());
        }
    }

    //Busca en la Base de Datos una Reserva que coincida con "id",
    //y luego retorna un Objeto Reserva con todos los datos obtenidos.
    public Reserva buscarReserva(int id) {
        Reserva res = new Reserva();
        String sql = "SELECT * FROM reserva WHERE idReserva = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res.setIdReserva(rs.getInt("idReserva"));
                res.setNombreApellido(rs.getString("nombreApellido"));
                res.setDni(rs.getInt("dni"));
                res.setFechaHora(rs.getDate("fechaHora").toLocalDate());
                res.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la Reserva");
                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Reserva: " + ex.getMessage());
        }catch(NullPointerException ex){
            
        }
        return res;
    }

    //Si el parametro ingresado es == 1, retornará un List de Reservas activas.
    //Si el parametro ingresado es == 0, retornará un List de Reservas inactivas.
    public List<Reserva> obtenerReservas(int num) {
        List<Reserva> listaRes = new ArrayList<>();
        Reserva res = null;

        try {
            if (num == 1) {
                String sql = "SELECT * FROM reserva WHERE estado = 1";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    res = buscarReserva(rs.getInt("idReserva"));
                    listaRes.add(res);
                }
                ps.close();
                rs.close();
            } else if (num == 0) {
                String sql = "SELECT * FROM reserva WHERE estado = 0";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    res = buscarReserva(rs.getInt("idReserva"));
                    listaRes.add(res);
                }
                ps.close();
                rs.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Reservas: " + ex.getMessage());
        }

        return listaRes;
    }

    //Retorna un ArrayList de todas las Reservas con el mismo DNI.
    public List<Reserva> obtenerReservasPorDni(int dni) {
        List<Reserva> listaRes = new ArrayList<>();
        Reserva res = null;
        try {
            String sql = "SELECT * FROM reserva WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res = buscarReserva(rs.getInt("idReserva"));
                listaRes.add(res);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Reservas por DNI: " + ex.getMessage());
        }

        return listaRes;
    }

    public void actualizarReserva(Reserva res) {
        String sql = "UPDATE reserva SET nombreApellido = ?, dni = ?, fechaHora = ?, estado = ? WHERE idReserva =" + res.getIdReserva();
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, res.getNombreApellido());
                ps.setInt(2, res.getDni());
                ps.setDate(3, Date.valueOf(res.getFechaHora()));
                ps.setBoolean(4, res.isEstado());
                int end = ps.executeUpdate();
                if (end == 1) {
                    JOptionPane.showMessageDialog(null, "Reserva modificada");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo modificar la Reserva.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar Reserva: " + ex.getMessage());
        }
    }

    public void eliminarReserva(Reserva res) {
        try {
            String sql = "UPDATE reserva SET estado = 0 WHERE idReserva = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, res.getIdReserva());
            int end = ps.executeUpdate();
            if (end == 1) {
                JOptionPane.showMessageDialog(null, "Reserva eliminada.");
            } else {
                JOptionPane.showMessageDialog(null, "No se puedo eliminar la Reserva.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Reserva: " + ex.getMessage());
        }
    }

    public List<Reserva> todas() {
        List<Reserva> listaRes = new ArrayList<>();
        Reserva res = null;

        try {

            String sql = "SELECT * FROM reserva";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res = buscarReserva(rs.getInt("idReserva"));
                listaRes.add(res);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener Reservas: " + ex.getMessage());
        }

        return listaRes;
    }

}
