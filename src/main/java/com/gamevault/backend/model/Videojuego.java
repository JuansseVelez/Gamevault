package com.gamevault.backend.model;

import jakarta.persistence.Entity;

@Entity
public class Videojuego extends Producto {

    private String genero;
    private String plataforma;

    public Videojuego() {

    }

    public Videojuego(
            Long id,
            String nombre,
            double precio,
            String genero,
            String plataforma
    ) {
        super(id, nombre, precio);

        this.genero = genero;
        this.plataforma = plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "***** VIDEOJUEGO *****\n" + "Id: " + getId() + "\n" + "Nombre: " + getNombre() + "\n" + "Precio: " + getPrecio() + "\n" + "Genero: " + getGenero() + "\n" + "Plataforma: " + getPlataforma() + "\n" + "********************";
    }
}
