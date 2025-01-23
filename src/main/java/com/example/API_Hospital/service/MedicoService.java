package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico create(Medico medico){
        return repository.save(medico);
    }

    public List<Medico> findAll(){
        return repository.findAll();
    }
}
