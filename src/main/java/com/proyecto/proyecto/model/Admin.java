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
@Table(name="usu_admin")
public class Admin extends Usuario{
    @Column(name="adm_region")
    private String regionAdmin;
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orden> ordenesAdmin;

    public Admin(String regionAdmin, List<Orden> ordenesAdmin) {
        this.regionAdmin = regionAdmin;
        this.ordenesAdmin = ordenesAdmin;
    }

    public Admin() {
        super();
    }

    public String getRegionAdmin() {
        return regionAdmin;
    }

    public void setRegionAdmin(String regionAdmin) {
        this.regionAdmin = regionAdmin;
    }

    public List<Orden> getOrdenesAdmin() {
        return ordenesAdmin;
    }

    public void setOrdenesAdmin(List<Orden> ordenesAdmin) {
        this.ordenesAdmin = ordenesAdmin;
    }

    @Override
    public String toString() {
        return "Admin{" + "regionAdmin=" + regionAdmin + ", ordenesAdmin=" + ordenesAdmin + '}';
    }
    
}
