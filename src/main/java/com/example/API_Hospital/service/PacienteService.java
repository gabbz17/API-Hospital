package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.exception.ListNotFoundException;
import com.example.API_Hospital.exception.NameNotFoundException;
import com.example.API_Hospital.exception.NameUniqueException;
import com.example.API_Hospital.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente create(Paciente paciente){
        try {
            return repository.save(paciente);

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new NameUniqueException("Dados já cadastrados!");
        }
    }

    public List<Paciente> findAll(){
        List<Paciente> list = repository.findAll();

        if (list.isEmpty()){
            throw new ListNotFoundException("Pacientes não cadastrados!");
        }

        return list;
    }

    public Paciente findByName(String nome){
        return repository.findByNome(nome).orElseThrow(() ->
                new NameNotFoundException(String.format("Paciente com o nome (%s), não encontrado(a)!", nome)));
    }

    public Paciente findByNumero(String nome){
        return repository.findByNumero(nome).orElseThrow(() ->
                new NameNotFoundException(String.format("Paciente com o numero (%s), não encontrado(a)!", nome)));
    }
}
