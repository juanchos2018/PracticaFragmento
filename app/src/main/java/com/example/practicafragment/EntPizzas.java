package com.example.practicafragment;

import java.io.Serializable;

public class EntPizzas implements Serializable {

    private String nomnbre;
    private int foto;
    private String detalle;
    private int fotodetalle;

    public EntPizzas(String nomnbre, int foto, String detalle, int fotodetalle) {
        this.nomnbre = nomnbre;
        this.foto = foto;
        this.detalle = detalle;
        this.fotodetalle = fotodetalle;
    }

    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getFotodetalle() {
        return fotodetalle;
    }

    public void setFotodetalle(int fotodetalle) {
        this.fotodetalle = fotodetalle;
    }
}
