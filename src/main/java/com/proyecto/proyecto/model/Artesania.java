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
@Table(name="pro_artesanias")
public class Artesania extends Producto{
    
    @Column(name="art_material")
    private String material;
    @Column(name="art_tipo_fabri")
    private String tipoFabricacion;
    @Column(name="art_color")
    private String color;

    public Artesania() {
        super();
    }

    public Artesania(String material, String tipoFabricacion, String color) {
        this.material = material;
        this.tipoFabricacion = tipoFabricacion;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoFabricacion() {
        return tipoFabricacion;
    }

    public void setTipoFabricacion(String tipoFabricacion) {
        this.tipoFabricacion = tipoFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Artesania{" + "material=" + material + ", tipoFabricacion=" + tipoFabricacion + ", color=" + color + '}';
    }
    
}
