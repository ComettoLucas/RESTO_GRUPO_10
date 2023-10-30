
package com.equipo10.restaurante.Entidades;


public class Producto {
    private int idProducto;
    private Categoria categoria;
    private String nombre;
    private int Cantidad;
    private int cantidadEnStock;
    private double precio;
    private boolean estado;
    
    public Producto() {
    }

    public Producto(int idProducto, Categoria categoria, String nombre, int cantidadEnStock, double precio, boolean estado) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidadEnStock = cantidadEnStock;
        this.precio = precio;
        this.estado = estado;
    }
    

    public Producto(int idProducto, String nombre, int cantidad, double precio, Categoria categoria, boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidadEnStock = cantidad;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    public Producto(String nombre, int cantidad, double precio, Categoria categoria, boolean estado) {
        this.nombre = nombre;
        this.cantidadEnStock = cantidad;
        this.precio = precio;
        this.categoria = categoria;
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    

    

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre ;
    }
    
    
    
}
