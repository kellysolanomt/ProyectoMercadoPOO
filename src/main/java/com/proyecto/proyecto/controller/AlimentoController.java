/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Alimento;
import com.proyecto.proyecto.repository.AlimentoRepository;
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
@RequestMapping("/alimentos")//http:localhost:8080/alimentos
public class AlimentoController {
    private final Logger logg=LoggerFactory.getLogger(Alimento.class);
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
    
    @GetMapping("/nuevoAlimento")
    public String crearAlimento(){
        return "nuevoAlimento";
    }
    
    @PostMapping("/guardarAlimento")
    public String guardarAlimento(Alimento alimento){
        logg.info("Informacion del objeto alimento, {}",alimento);
        alimentoRepository.save(alimento);
        return "redirect:/alimentos/admin";
    }
    
    @GetMapping("/editarAlimento/{referencia}")
    public String editarAlimento(@PathVariable Long referencia, Model model){
        Alimento alim = alimentoRepository.getOne(referencia);
        logg.info("Objeto recuperado {}",alim);
        model.addAttribute("alimento",alim);
        return "editarAlimento";
    }
    
    @GetMapping("/borrarAlimento/{referencia}")
    public String borrarAlimento(@PathVariable Long referencia){
        Alimento alim = alimentoRepository.getOne(referencia);
        logg.info("Objeto eliminado {}",alim);
        alimentoRepository.delete(alim);
        return "redirect:/alimentos/admin";
    }
    
}
