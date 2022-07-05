/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kelly
 */
@Controller
@RequestMapping("/alimentos")//http:localhost:8080/alimentos
public class AlimentoController {
    //se inyecta al controlador el objeto
    @Autowired
    private AlimentoRepository alimentoRepository;
    
    @GetMapping("/admin")
    public String alimentoAdmin(Model model){
        model.addAttribute("alimentos", alimentoRepository.findAll());
        return "alimentosAdmin";
    }
    
    @GetMapping("/cliente")
    public String alimentoCliente(Model model){
        model.addAttribute("alimentos", alimentoRepository.findAll());
        return "alimentos";
    }
    
    @GetMapping("/create") //http://localhost:8080/alimentosAdmin/create
    public String create(){
        return "";
    }
    
    
}
