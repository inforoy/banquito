package com.bank.credit.model;

public class Sexo {
    private String id;
    private String descripcionCorta;
    private String descripcionLarga;
    private String indel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getIndel() {return indel;}

    public void setIndel(String indel) {this.indel = indel;}
}
