/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author kelly
 */
@Entity
@Table(name="orden")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="fecha_orden")
    private Date fechaOrden;
    @Column(name="lista_productos")
    private List<Producto> productos;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @ManyToOne()
    @JoinColumn(name="admin_id")
    private Admin admin;

    public Orden(long id, Date fechaOrden, List<Producto> productos, Cliente cliente, Admin admin) {
        this.id = id;
        this.fechaOrden = fechaOrden;
        this.productos = productos;
        this.cliente = cliente;
        this.admin = admin;
    }

    public Orden() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", fechaOrden=" + fechaOrden + ", productos=" + productos + ", cliente=" + cliente + ", admin=" + admin + '}';
    }
    
}
