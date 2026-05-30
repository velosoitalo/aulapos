/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabricio.AulaPos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

/**
 *
 * @author italo
 */
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String nome;
    
    /**

     * @return the id

     */

    public Long getId() {

        return id;

    }
 
    /**

     * @param id the id to set

     */

    public void setId(Long id) {

        this.id = id;

    }
 
    /**

     * @return the nome

     */

    public String getNome() {

        return nome;

    }
 
    /**

     * @param nome the nome to set

     */

    public void setNome(String nome) {

        this.nome = nome;

    }
 
}