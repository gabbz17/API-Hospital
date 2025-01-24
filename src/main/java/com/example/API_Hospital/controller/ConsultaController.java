package com.example.API_Hospital.controller;

import com.example.API_Hospital.entity.Consulta;
import com.example.API_Hospital.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService service;

    @PostMapping
    public ResponseEntity<Consulta> create(@Valid @RequestBody Consulta consulta){
        Consulta cons = service.create(consulta);
        return ResponseEntity.status(201).body(cons);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> findAll(){
        List<Consulta> cs = service.findAll();
        return ResponseEntity.ok().body(cs);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Consulta>> findByDate(@PathVariable String date) {
        LocalDateTime dateTime = LocalDateTime.parse(date);
        List<Consulta> cs = service.findByData(dateTime);
        return ResponseEntity.ok().body(cs);
    }
}
