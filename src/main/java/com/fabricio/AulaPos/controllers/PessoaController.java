/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabricio.AulaPos.controllers;

import com.fabricio.AulaPos.models.Pessoa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
/**
*
* @author fabri
*/
@Controller
@RequestMapping("/pessoa")
public class PessoaController 
{
    private List<Pessoa> pessoas = new ArrayList<>();
    @PostMapping("/pessoa")
    @ResponseBody
    public Pessoa criar(@RequestBody Pessoa p)
    {
        pessoas.add(p);
        return p;
    }
    @GetMapping("/pessoas")
    @ResponseBody
    public List<Pessoa> listar()
    {
        return pessoas;
    }
    @GetMapping("/pessoa/{nome}")
    @ResponseBody
    public Optional<Pessoa> buscar(@PathVariable String nome)
    {
        return pessoas.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
    }
}