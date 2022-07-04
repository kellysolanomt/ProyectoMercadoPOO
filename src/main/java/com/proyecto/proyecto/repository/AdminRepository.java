/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.proyecto.repository;

import com.proyecto.proyecto.model.Admin;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kelly
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    Optional<Admin> findByUsuarioAndContraseña(String usuario, String contraseña);
}
