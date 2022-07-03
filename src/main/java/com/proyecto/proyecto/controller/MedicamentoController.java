/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.repository.MedicamentoRepository;
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
@RequestMapping("/medicamentosAdmin")
public class MedicamentoController {
    
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    
    @GetMapping("")
    public String medicamentoAdmin(Model model){
        model.addAttribute("medicamentos", medicamentoRepository.findAll());
        return "medicamentosAdmin";
    }
    
    @GetMapping("/create")//http://localhost:8080/medicamentosAdmin/create
    public String create(){
        return "";
    }
}
