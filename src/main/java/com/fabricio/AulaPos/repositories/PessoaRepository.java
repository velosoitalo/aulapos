/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabricio.AulaPos.repositories;

import com.fabricio.AulaPos.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author italo
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long > {
    
    
}
