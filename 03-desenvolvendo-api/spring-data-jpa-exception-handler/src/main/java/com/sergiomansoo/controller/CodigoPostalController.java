package com.sergiomansoo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sergiomansoo.handler.BusinessException;

@RestController
@RequestMapping("/cep")
public class CodigoPostalController {
    @GetMapping("/{ibge}")
    public String getCidade(@PathVariable String ibge){
        if(ibge.equals("3550308"))
            return "São Paulo";
        else
            throw new BusinessException("Não localizamos nenhuma cidade com o código informado.");
    }
}
