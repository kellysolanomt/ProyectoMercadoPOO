/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Cliente;
import com.proyecto.proyecto.repository.ClienteRepository;
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
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("")
    public String cliente(Model model){
        model.addAttribute("cliente", clienteRepository.findAll());
        return "";
    }
    
    @GetMapping("/iniciarSesion")
    public String iniciarSesion(){
        return "logInUsuario";
    }
    
    public Optional<Cliente> autenticarCliente(String usuario, String contraseña){
        return clienteRepository.findByUsuarioAndContraseña(usuario, contraseña);
    }
    
    public Cliente autenticar(String usuario, String contraseña){
        Optional<Cliente> cliente = autenticarCliente(usuario, contraseña);
        
        if(cliente.isEmpty()){
            return new Cliente();
        }else{
            return cliente.get();
        }
    }
    
    @GetMapping("/{usuario}/{contraseña}")
    public String logueo(@PathVariable("usuario") String usuario, @PathVariable("contraseña") String contraseña, Model model){
        Cliente clienteEncontrado = autenticar(usuario, contraseña);
        if(clienteEncontrado.getNombre()==null){
            return "redirect:/cliente/iniciarSesion";
        }else{
            model.addAttribute("clienteEncontrado", clienteEncontrado);
            System.out.println(clienteEncontrado.getUsuario());
            return "homeCliente";
        }
        
    }

}
