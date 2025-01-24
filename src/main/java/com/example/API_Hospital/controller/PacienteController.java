package com.example.API_Hospital.controller;

import com.example.API_Hospital.dto.PacienteDTO;
import com.example.API_Hospital.dto.mapper.PacienteMapper;
import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente paciente){
        Paciente pc = service.create(paciente);
        return ResponseEntity.status(201).body(pc);
    }

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll(){
        List<Paciente> pc = service.findAll();
        List<PacienteDTO> pc1 = PacienteMapper.toAllDto(pc);
        return ResponseEntity.ok().body(pc1);
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<PacienteDTO> findByName(@Valid @PathVariable String nome){
        Paciente pc = service.findByName(nome);
        PacienteDTO pc1 = PacienteMapper.toDTO(pc);
        return ResponseEntity.ok().body(pc1);
    }
}
