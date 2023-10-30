
package com.equipo10.restaurante.Entidades;

import com.equipo10.restaurante.AccesoADatos.MeseroData;


public class Mesero {
    
    private MeseroData md = new MeseroData();
    
    private int idMesero;
    private String nombreApellido,docu;
    private boolean estado,Ingreso;
    
    
    public Mesero() {
    }

    public Mesero(String nombreApellido, String docu) {
        this.idMesero = md.ultimo();
        this.nombreApellido = nombreApellido;
        this.docu = docu;
        this.estado = true;
        this.Ingreso = false;
    }


    public Mesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero(int idMesero, String nombreApellido, String docu) {
        this.idMesero = idMesero;
        this.nombreApellido = nombreApellido;
        this.docu = docu;
    }


    public Mesero(int idMesero, String nombreApellido, boolean estado) {

        this.idMesero = idMesero;
        this.nombreApellido = nombreApellido;
        this.estado=estado;
    }

    public String getDocu() {
        return docu;
    }

    public void setDocu(String docu) {
        this.docu = docu;
    }

    public boolean isIngreso() {
        return Ingreso;
    }

    public void setIngreso(boolean Ingreso) {
        this.Ingreso = Ingreso;
    }
    
    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombreApellido;
    }
    

    
}
