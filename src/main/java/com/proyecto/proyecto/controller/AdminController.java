/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Admin;
import com.proyecto.proyecto.repository.AdminRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kelly
 */
@Controller
@RequestMapping("/admin")
public class AdminController{
    
    @Autowired
    private AdminRepository adminRepository;
    
    @GetMapping("")
    public String admin(Model model){
        model.addAttribute("admin", adminRepository.findAll());
        return "";
    }
    
    @GetMapping("/iniciarSesion")
    public String iniciarSesion(){
        return "logInAdmin";
    }
    
    public Optional<Admin> autenticarAdmin(String usuario, String contraseña){
        return adminRepository.findByUsuarioAndContraseña(usuario, contraseña);
    }
    
    public Admin autenticar(String usuario, String contraseña){
        Optional<Admin> administrador = autenticarAdmin(usuario, contraseña);
        if(administrador.isEmpty()){
            return new Admin();
        }else{
            return administrador.get();
        }
    }
    
    @GetMapping("/{usuario}/{contraseña}")
    public String logueo(@PathVariable("usuario") String usuario, @PathVariable("contraseña") String contraseña){
        Admin administradorEncontrado = autenticar(usuario, contraseña);
        if(administradorEncontrado.getNombre().isEmpty()){
            return "No encontrado";
        }else{
            String usuarioEncontrado = administradorEncontrado.getNombre();
            String correoEncontrado = administradorEncontrado.getCorreo();
            return "redirect:/admin/homeAdmin";
        }
        
    }
    
    @GetMapping("/homeAdmin")
    public String homeAdmin(){
        return "homeAdmin";
    }
    
    
}
