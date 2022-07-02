/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */

@Entity
@Table(name="pro_medicamento")
public class Medicamento extends Producto{
    @Column(name="med_cantidad")
    private long cantidad;
    @Column(name="med_tipo")
    private String tipo;
    @Column(name="med_dosis")
    private String dosis;

    public Medicamento() {
        super();
    }

    public Medicamento(long cantidad, String tipo, String dosis) {
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.dosis = dosis;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "cantidad=" + cantidad + ", tipo=" + tipo + ", dosis=" + dosis + '}';
    }
    
    
    
    
    
}
