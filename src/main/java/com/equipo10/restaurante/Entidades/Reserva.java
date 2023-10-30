package com.equipo10.restaurante.Entidades;

import java.time.LocalDate;

public class Reserva {

    private int idReserva;
    private String nombreApellido;
    private int dni;
    private LocalDate fechaHora;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(int idReserva, String nombreApellido, int dni, LocalDate fechaHora, boolean estado) {
        this.idReserva = idReserva;
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Reserva(String nombreApellido, int dni, LocalDate fechaHora, boolean estado) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        if (estado) {
            return "|ID: " + idReserva + " | " + nombreApellido + " | " + fechaHora.toString() + " |Activo";
        } else {
            return "|ID: " + idReserva + " | " + nombreApellido + " | " + fechaHora.toString() + " |Inactivo";
        }
    }

}
