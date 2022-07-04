/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Medicamento;
import com.proyecto.proyecto.repository.MedicamentoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kelly
 */
@Controller
@RequestMapping("/medicamentosAdmin")
public class MedicamentoController {
    
    private final Logger logg=LoggerFactory.getLogger(Medicamento.class);
    
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    
    @GetMapping("")
    public String medicamentoAdmin(Model model){
        model.addAttribute("medicamentos", medicamentoRepository.findAll());
        return "medicamentosAdmin";
    }
    
    @GetMapping("/nuevoMedicamento")//http://localhost:8080/medicamentosAdmin/create
    public String crearMedicamento(){
        return "nuevoMedicamento";
    }
    
    @PostMapping("/guardarMedicamento")
    public String guardarMedicamento(Medicamento medicamento){
        logg.info("Informacion del objeto medicamento, {}",medicamento);
        medicamentoRepository.save(medicamento);
        return "redirect:/medicamentosAdmin";
    }
}
