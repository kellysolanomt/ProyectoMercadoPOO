/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */

@Entity
@Table(name="usu_cliente")
public class Cliente extends Usuario{
    
    @Column(name="cli_activo")
    private boolean estaActivo;
    
    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Orden> ordenes;

    public Cliente(boolean estaActivo, List<Orden> ordenes) {
        this.estaActivo = estaActivo;
        this.ordenes = ordenes;
    }

    public Cliente() {
        super();
    }
    

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
    
    
    
}
