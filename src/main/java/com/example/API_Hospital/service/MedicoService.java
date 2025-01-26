package com.example.API_Hospital.service;

import com.example.API_Hospital.dto.MedicoUpdate;
import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Role.Especializacao;
import com.example.API_Hospital.exception.*;
import com.example.API_Hospital.repository.MedicoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico create(Medico medico){
        try {
            return repository.save(medico);

        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new NameUniqueException("Dados já cadastrados!");
        }
    }

    public List<Medico> findAll(){
        List<Medico> list = repository.findAll();

        if (list.isEmpty()){
            throw new ListNotFoundException("Médicos não cadastrados!");
        }

        return list;
    }

    public Medico findByName(String nome){
        return repository.findByNome(nome).orElseThrow(() ->
                new NameNotFoundException(String.format("Médico(a) com o nome (%s), não encontrado!", nome)));
    }

    public List<Medico> findByRole(Especializacao role){
        List<Medico> list = repository.findByrole(role);
        String nm = String.valueOf(role);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Médicos com a especialização (%s), não encontrados!", nm));
        }

        return list;
    }

    public Medico findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Médico com o ID (%d), não encontrado!", id)));
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Medico update(Long id, MedicoUpdate medicoUp){
        Medico medico = findById(id);

        medico.setEndereco(medicoUp.getEndereco());
        medico.setNumero(medicoUp.getNumero());
        medico.setEmail(medicoUp.getEmail());

        return repository.save(medico);
    }
}
