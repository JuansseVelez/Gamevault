package com.gamevault.backend.model;

public class Accesorio extends Producto {

    private String marca;
    private String compatibilidad;
    private String categoria;

    public Accesorio(
            Long id,
            String nombre,
            double precio,
            String marca,
            String compatibilidad,
            String categoria
    ) {
        super(id, nombre, precio);

        this.marca = marca;
        this.compatibilidad = compatibilidad;
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(String compatibilidad) {
        this.compatibilidad = compatibilidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "****** ACCESORIO ******" + "\n" + "Id: " + getId() + "\n" + "Nombre: " + getNombre() + "\n" + "Precio: " + getPrecio() + "\n" + "Marca: " + getMarca() + "\n" + "Compatibilidad: " + getCompatibilidad() + "\n" + "Categoria: " + getCategoria() + "\n" + "**********";
    }
}
