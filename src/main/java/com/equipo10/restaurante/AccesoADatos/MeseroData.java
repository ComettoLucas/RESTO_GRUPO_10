package com.equipo10.restaurante.AccesoADatos;

import com.equipo10.restaurante.Entidades.Mesero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Cometto
 */
public class MeseroData {

    private Connection con = null;

    public MeseroData() {
        con = Conexion.getConexion("restaurante");
    }

    public void crearMozo(Mesero mesero) {

        String sql = "INSERT INTO mesero (NombreyApellido,Documento, estado,Ingreso) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mesero.getNombreApellido());
            ps.setInt(2, Integer.parseInt(mesero.getDocu()));
            ps.setBoolean(3, mesero.getEstado());
            ps.setBoolean(4, mesero.isIngreso());
            int fila = ps.executeUpdate();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, "Mesero Agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Algo salió mal");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero" + ex.getMessage());
        }
    }

    public void modificarMozo(Mesero mozo) {
        String consulta = "UPDATE mesero SET nombreyapellido=?,estado=? WHERE idMesero=?;";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setString(1, mozo.getNombreApellido());
                ps.setBoolean(2, mozo.getEstado());
                ps.setInt(3, mozo.getIdMesero());
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, "Mesero modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Algo salió mal");
                }
                ps.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero" + ex.getMessage());

            }
        }
    }

    public Mesero buscarMozoxId(int idMozo) {
        Mesero mozo = null;
        String consulta = "SELECT * FROM `mesero` WHERE idMesero=? AND estado=1";
        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setInt(1, idMozo);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    mozo = new Mesero();
                    mozo.setIdMesero(idMozo);
                    mozo.setNombreApellido(rs.getString("nombreyapellido"));
                    mozo.setEstado(rs.getBoolean("estado"));
                } else {
                    JOptionPane.showMessageDialog(null, "Mesero no encontrado");
                }
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesero" + ex.getMessage());

            }

        }
        return mozo;
    }

    public void eliminarMozo(int idMozo) {
        if (con != null) {
            try {
                String consulta = "UPDATE mesero SET estado=0 WHERE idMesero=?";
                PreparedStatement ps = con.prepareStatement(consulta);
                ps.setInt(1, idMozo);
                int fila = ps.executeUpdate();
                if (fila == 1) {
                    JOptionPane.showMessageDialog(null, "Mesero Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Id No encontrada");

                }
                ps.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " EXPLOTÓ" + e.getMessage());

            }
        }
    }

    public List<Mesero> listarMozos() {
        List<Mesero> meseros = new ArrayList<>();

        if (con != null) {
            try {
                String consulta = "SELECT * FROM mesero";
                PreparedStatement statement = con.prepareStatement(consulta);
                ResultSet resultado = statement.executeQuery();
                while (resultado.next()) {
                    int idMesero = resultado.getInt("idmesero");
                    String nombreApellido = resultado.getString("nombreyapellido");
                    boolean estado = resultado.getBoolean("estado");
                    Mesero mesero = new Mesero(idMesero, nombreApellido, estado);
                    meseros.add(mesero);
                }
                resultado.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, " EXPLOTÓ" + e.getMessage());

            }
        }
        return meseros;
    }

    public ArrayList<Mesero> mozosActivos() {
        ArrayList<Mesero> meseros = new ArrayList<>();
        String sql = "SELECT * FROM mesero where Ingreso=1";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                int idMesero = resultado.getInt("idmesero");
                String docu = resultado.getString("Documento");
                String nombreApellido = resultado.getString("nombreyapellido");
                Mesero mesero = new Mesero(idMesero, nombreApellido, docu);
                meseros.add(mesero);
            }
            statement.close();
            resultado.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error sql");
        }
        return meseros;
    }

    public void IngresoMesero(String docu) {
        String sql = "Update mesero Set Ingreso=1 where Documento=? AND estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, docu);
            int r = ps.executeUpdate();
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra ese mesero");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error sql");
        }
    }

    public void CierreLaboral() {
        String sql = "Update mesero Set Ingreso=0";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            int r = ps.executeUpdate();
            if (r == 1) {
                JOptionPane.showMessageDialog(null, "Hasta la proxima");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error sql");
        }
    }

    public int ultimo() {
        int ultimo = 1;
        String sql = "SELECT MAX(idMesero) FROM mesero";
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
    
    public ArrayList<Mesero> mozosEstadoActivo() {
        ArrayList<Mesero> meseros = new ArrayList<>();
        String sql = "SELECT * FROM mesero where estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesero m = new Mesero();
                m.setIdMesero(rs.getInt(1));
                m.setDocu(String.valueOf(rs.getInt(2)));
                m.setNombreApellido(rs.getString(3));
                m.setEstado(true);
                m.setIngreso(rs.getBoolean(5));
                
                
                meseros.add(m);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL");
        }
        return meseros;
    }
}
