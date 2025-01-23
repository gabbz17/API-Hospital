package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente create(Paciente paciente){
        return repository.save(paciente);
    }

    public List<Paciente> findAll(){
        List<Paciente> list = repository.findAll();

//        if (list.isEmpty()){
//
//        }
        return list;
    }
}
