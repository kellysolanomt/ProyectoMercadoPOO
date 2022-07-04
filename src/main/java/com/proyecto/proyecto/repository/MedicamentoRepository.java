/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kelly
 */

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
   
    
}
