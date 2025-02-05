package com.example.API_Hospital.controller;

import com.example.API_Hospital.dto.MedicoDTO;
import com.example.API_Hospital.dto.MedicoUpdate;
import com.example.API_Hospital.dto.mapper.MedicoMapper;
import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Role.Especializacao;
import com.example.API_Hospital.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/medico")
public class MedicoController {

    @Autowired
    MedicoService service;

    @PostMapping
    public ResponseEntity<Medico> create(@Valid @RequestBody Medico medico){
        Medico pc = service.create(medico);
        return ResponseEntity.status(201).body(pc);
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(){
        List<Medico> pc = service.findAll();
        List<MedicoDTO> pc1 = MedicoMapper.toAllDto(pc);
        return ResponseEntity.ok().body(pc1);
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<MedicoDTO> findByName(@Valid @PathVariable String nome){
        Medico pc = service.findByName(nome);
        MedicoDTO dto = MedicoMapper.toDTO(pc);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<MedicoDTO>> findByRole(@Valid @PathVariable String role){
        Especializacao esp = Especializacao.valueOf(role);
        List<Medico> pc = service.findByRole(esp);
        List<MedicoDTO> dto = MedicoMapper.toAllDto(pc);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> findByRole(@Valid @PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @Valid @RequestBody MedicoUpdate update){
        Medico medico = service.update(id, update);
        return ResponseEntity.ok().body(medico);
    }

}
