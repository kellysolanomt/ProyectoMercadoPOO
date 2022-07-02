/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyecto.proyecto.model.Alimento;
import org.springframework.stereotype.Repository;
/**
 *
 * @author kelly
 */

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Integer>{
    
    
}
