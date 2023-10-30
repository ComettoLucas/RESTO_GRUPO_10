package com.equipo10.restaurante.Entidades;

public class Mesa {

    private int idMesa;
    private int capacidad;
    private boolean estado, eliminada;
    private Reserva idReserva = new Reserva();

    public boolean isEliminada() {
        return eliminada;
    }

    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    /*                            IMPORTANTE
    *       AL CREAR UNA MESA SE PUEDE AGREGAR UNA RESERVA Y SI NO
    *       LO REQUIERE SE DEBE AGREGAR null EN LUGAR DE LA RESERVA" 
     */
    public Mesa() {
    }

    public Mesa(int idMesa, int capacidad, boolean estado, Reserva idReserva) {
        this.idMesa = idMesa;
        this.capacidad = capacidad;
        this.estado = estado;
        this.idReserva = idReserva;

    }

    public Mesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public Mesa(int capacidad, boolean estado, Reserva idReserva) {
        this.capacidad = capacidad;
        this.estado = estado;
        this.idReserva = idReserva;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() { // si esta abierta
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    @Override
    public String toString() {
        return idMesa + "";
    }

}
