/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */
@Entity
@Table(name = "pro_alimentos")
public class Alimento extends Producto {

   
    @Column(name = "ali_fecha_venc")
    private String fechaVencimiento;
    @Column(name = "ali_consumo")
    private boolean listoParaConsumir;
    @Column(name = "ali_origen_ani")
    private boolean origenAnimal;

    public Alimento() {
        super();
    }

    public Alimento(String fechaVencimiento, boolean listoParaConsumir, boolean origenAnimal) {
        this.fechaVencimiento = fechaVencimiento;
        this.listoParaConsumir = listoParaConsumir;
        this.origenAnimal = origenAnimal;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isListoParaConsumir() {
        return listoParaConsumir;
    }

    public void setListoParaConsumir(boolean listoParaConsumir) {
        this.listoParaConsumir = listoParaConsumir;
    }

    public boolean isOrigenAnimal() {
        return origenAnimal;
    }

    public void setOrigenAnimal(boolean origenAnimal) {
        this.origenAnimal = origenAnimal;
    }

    @Override
    public String toString() {
        return "Alimento{" + "fechaVencimiento=" + fechaVencimiento + ", listoParaConsumir=" + listoParaConsumir + ", origenAnimal=" + origenAnimal + '}';
    }
}
