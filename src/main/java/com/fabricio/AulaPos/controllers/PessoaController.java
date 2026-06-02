/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabricio.AulaPos.controllers;

import com.fabricio.AulaPos.models.Pessoa;
import com.fabricio.AulaPos.repositories.PessoaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
 
/**
*
* @author italo
*/
@RestController
@RequestMapping("/pessoa")
public class PessoaController 
{
    @Autowired
    private PessoaRepository pessoaRepository;
    @GetMapping
    public List<Pessoa> getPessoas()
    {
        return pessoaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Pessoa> getPessoa(@PathVariable Long id)
    {
        try
        {
            //return pessoaRepository.getOne(id);
            return pessoaRepository.findById(id);
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa p)
    {
        return pessoaRepository.save(p);
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id)
    {
        pessoaRepository.deleteById(id);
    }
    @PutMapping("/{id}")
    public Pessoa alterar(@RequestBody Pessoa novaPessoa, @PathVariable Long id)
    {
        Pessoa p = pessoaRepository.findById(id)
                .orElseThrow(()-> new 
        ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada!"));
        p.setNome(novaPessoa.getNome());
        return pessoaRepository.save(p);
    }

    
    
    
    
    /*private static final List<Pessoa> pessoas = new ArrayList<>();
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
        /*for (Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return pessoas.stream().filter(p -> p.getNome().equalsIgnoreCase(nome)).findFirst();
    }*/
}