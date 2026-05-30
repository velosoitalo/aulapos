/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabricio.AulaPos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author italo
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }
    
    public String world(){
        return "Hello World!";
    }
    @PostMapping("/world/{valor}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public String retornaValor(@PathVariable String valor){
        return valor;
    }
    @PostMapping("/hello/{valor1}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public int retornaSoma (@PathVariable int valor1, @RequestBody int valor2){
        return valor1 + valor2;
    }
        @GetMapping("/{nome}")
    @ResponseBody
    public String helloNome(@PathVariable String nome) {
        return "Olá, " + nome;
    }
    
    @GetMapping("/calc/soma/{a}/{b}")
@ResponseBody
public String soma(@PathVariable int a,@PathVariable int b) {
if (a < 0 || b < 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Informe valor corretamente");
    }

    return "Resultado:"+ (a + b);
    
}

@GetMapping("/temperatura/{valor}/{de}/{para}")
@ResponseBody
public String converterTemperatura(@PathVariable double valor,@PathVariable String de,@PathVariable String para) {

   if (de.equals("F")) {
        valor = (valor - 32) * 5 / 9;
    } else if (de.equals("K")) {
        valor = valor - 273.15;
    }
       if (para.equals("F")) {
        valor = (valor * 9 / 5) + 32;
    } else if (para.equals("K")) {
        valor = valor + 273.15;
    }

    return "Resultado: " + valor;
}
    
    
}
