/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.proyecto.model.Artesania;
import com.proyecto.proyecto.repository.ArtesaniaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
* @author kelly
*/
@Controller
@RequestMapping("/artesanias")//http:localhost:8080/artesaniasAdmin
public class ArtesaniasController {
	
	private final Logger logg= LoggerFactory.getLogger(Artesania.class);
	
	//se inyecta al controlador el objeto
	@Autowired
	private ArtesaniaRepository artesaniaRepository;
	
	@GetMapping("/admin")
	public String artesaniaAdmin(Model model) {
		model.addAttribute("artesanias", artesaniaRepository.findAll());
		return "artesaniasAdmin";
	}
        
        @GetMapping("/cliente")
	public String artesaniaCliente(Model model) {
		model.addAttribute("artesanias", artesaniaRepository.findAll());
		return "artesanias";
	}

	
	@GetMapping("/nuevaArtesania")//http://localhost:8080/artesaniasAdmin/create
            public String crearArtesania() {
            return "nuevoArtesania";
	}
	
	@PostMapping("/guardarArtesania")
	public String guardarArtesania(Artesania artesania){
		logg.info("Información del producto, {}", artesania);
		artesaniaRepository.save(artesania);
		return "redirect:/artesanias/admin";
	}
	
	@GetMapping("/editarArtesania/{referencia}")
	public String editarArtesania( @PathVariable Long referencia, Model model ){
		Artesania p= artesaniaRepository.getOne(referencia);
		logg.info("Objeto Recuperado {}", p);
		model.addAttribute("artesania",p);
		return "editarArtesania";
	}
	
	@GetMapping("/borrarArtesania/{referencia}")
	public String borrarArtesania( @PathVariable Long referencia){
		Artesania p= artesaniaRepository.getOne(referencia);
		logg.info("Objeto eliminado {}", p);
		artesaniaRepository.delete(p);
		return "redirect:/artesanias/admin";
	}
	
	
	
	
}
