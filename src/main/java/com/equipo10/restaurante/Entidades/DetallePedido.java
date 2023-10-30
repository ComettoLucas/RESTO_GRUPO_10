/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo10.restaurante.Entidades;

import com.equipo10.restaurante.AccesoADatos.ProductoData;

/**
 *
 * @author Lucas
 */
public class DetallePedido {

    ProductoData pd = new ProductoData();

    private int idDetalle;
    private int idProducto;
    private int cantidad;
    private Pedido pedido; // Referencia al pedido al que pertenece
    private double totalPedido;

    public DetallePedido(int idDetalle, int idProducto, int cantidad, Pedido pedido) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.totalPedido = pd.TraerProducto(idProducto).getPrecio() * cantidad;
        this.cantidad = cantidad;
        this.pedido = pedido;
    }

    public DetallePedido(int idDetalle, int idProducto, int cantidad, Pedido pedido, double totalPedido) {
        this.idDetalle = idDetalle;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.pedido = pedido;
        this.totalPedido = totalPedido;
    }
    
    public DetallePedido(){
        
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "idDetalle=" + idDetalle + ", idProducto=" + idProducto + ", cantidad=" + cantidad + ", pedido=" + pedido.getIdPedido() + ", totalPedido=" + totalPedido + '}';
    }

}
