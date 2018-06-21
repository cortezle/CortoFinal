/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author LN710Q
 */
public class Producto {
        private int id;
        private String nombre;
        private String tipo;
        private Float precio;
        private int cantidad;
        private Boolean disponibilidad;

    public Producto() {
    }

    public Producto(int id, String nombre, String tipo, Float precio, int cantidad, Boolean disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.disponibilidad = disponibilidad;
    }



    public Producto(int id, String nombre, Float precio, Boolean disponibilidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
  
        
    
}
