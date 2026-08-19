package com.gamevault.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private double precio;

    public Producto() {

    }

    public Producto(
            Long id,
            String nombre,
            double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "***** PRODUCTO *****\n" + "Id: " + getId() + "\n" + "Nombre: " + getNombre() + "\n" + "Precio: " + getPrecio() + "\n" + "********************";
    }
}
