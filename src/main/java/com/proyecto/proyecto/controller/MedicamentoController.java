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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author kelly
 */
@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {
    
    private final Logger logg=LoggerFactory.getLogger(Medicamento.class);
    
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    
    @GetMapping("/admin")
    public String medicamentoAdmin(Model model){
        model.addAttribute("medicamentos", medicamentoRepository.findAll());
        return "medicamentosAdmin";
    }
    
    @GetMapping("/cliente")
    public String medicamentoCliente(Model model){
        model.addAttribute("medicamentos", medicamentoRepository.findAll());
        return "medicamentos";
    }
    
    @GetMapping("/nuevoMedicamento")
    public String crearMedicamento(){
        return "nuevoMedicamento";
    }
    
    @PostMapping("/guardarMedicamento")
    public String guardarMedicamento(Medicamento medicamento){
        logg.info("Informacion del objeto medicamento, {}",medicamento);
        medicamentoRepository.save(medicamento);
        return "redirect:/medicamentos/admin";
    }
    
    @GetMapping("/editarMedicamento/{referencia}")
    public String editarMedicamento(@PathVariable Long referencia, Model model){
        Medicamento medi = medicamentoRepository.getOne(referencia);
        logg.info("Objeto recuperado {}",medi);
        model.addAttribute("medicamento",medi);
        return "editarMedicamento";
    }
    
    @GetMapping("/borrarMedicamento/{referencia}")
    public String borrarMedicamento(@PathVariable Long referencia){
        Medicamento medi = medicamentoRepository.getOne(referencia);
        logg.info("Objeto eliminado {}",medi);
        medicamentoRepository.delete(medi);
        return "redirect:/medicamentos/admin";
    }
    
    
}
