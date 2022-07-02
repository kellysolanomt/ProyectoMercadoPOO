/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */

@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public abstract class Producto {
    @Id
    @SequenceGenerator(name="SEQ_PRODUCTO",sequenceName = "seq_producto",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SEQ_PRODUCTO")
    @Column(name="referencia")
    private long referencia;
    @Column(name="nombre")
    private String nombre;
    @Column(name="precio")
    private long precio;
    @Column(name="origen")
    private String origen;

    public Producto() {
        super();
    }
    
    public Producto(long referencia, String nombre, long precio, String origen) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
        this.origen = origen;
    }

    public long getReferencia() {
        return referencia;
    }

    public void setReferencia(long referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String toString() {
        return "Producto{" + "referencia=" + referencia + ", nombre=" + nombre + ", precio=" + precio + ", origen=" + origen + '}';
    }
}
