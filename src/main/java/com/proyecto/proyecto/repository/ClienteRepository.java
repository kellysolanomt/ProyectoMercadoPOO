/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kelly
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Optional<Cliente> findByUsuarioAndContraseña(String usuario, String contraseña);
    
}
