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
@RequestMapping("/artesaniasAdmin")//http:localhost:8080/artesaniasAdmin
public class ArtesaniasController {
	
	private final Logger logg= LoggerFactory.getLogger(Artesania.class);
	
	//se inyecta al controlador el objeto
	@Autowired
	private ArtesaniaRepository artesaniaRepository;
	
	@GetMapping("")
	public String artesaniaAdmin(Model model) {
		model.addAttribute("artesanias", artesaniaRepository.findAll());
		return "artesaniasAdmin";
	}
	
	@GetMapping("/create")//http://localhost:8080/artesaniasAdmin/create
    public String create() {
		return "nuevoArtesania";
	}
	
	@PostMapping("/guardarArtesania")
	public String guardarArtesania(Artesania artesania){
		logg.info("Información del producto, {}", artesania);
		artesaniaRepository.save(artesania);
		return "redirect:/artesaniasAdmin";
	}
	
	@GetMapping("/editarArtesania/{referencia}")
	public String editarArtesania( @PathVariable long referencia, Artesania artesania ){
		Artesania p= artesaniaRepository.getOne(referencia);
		logg.info("Objeto Recuperado {}", p);
		return "editarArtesania";
	}
}