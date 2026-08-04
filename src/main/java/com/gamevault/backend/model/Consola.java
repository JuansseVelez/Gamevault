package com.gamevault.backend.model;

public class Consola extends Producto {

    private String marca;
    private String tipo;
    private String soporte;

    public Consola(
            Long id,
            String nombre,
            double precio,
            String marca,
            String tipo,
            String soporte
    ) {
        super(id, nombre, precio);

        this.marca = marca;
        this.tipo = tipo;
        this.soporte = soporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSoporte() {
        return soporte;
    }

    public void setSoporte(String soporte) {
        this.soporte = soporte;
    }

    @Override
    public String toString() {
        return "***** CONSOLA *****" + "\n" + "Id: " + getId() + "\n" + "Nombre: " + getNombre() + "\n" + "Precio: " + getPrecio() + "\n" + "Marca: " + getMarca() + "\n" + "Tipo: " + getTipo() + "\n" + "Soporte: " + getSoporte() + "\n" + "********************";
    }
}
