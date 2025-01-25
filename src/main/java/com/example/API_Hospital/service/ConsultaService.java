package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Consulta;
import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.entity.Role.Convenio;
import com.example.API_Hospital.exception.IdNotFoundException;
import com.example.API_Hospital.exception.ListNotFoundException;
import com.example.API_Hospital.repository.ConsultaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ConsultaService {

    @Autowired
    ConsultaRepository repository;

    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    public Consulta create(Consulta consulta){
        Paciente paciente = pacienteService.findByName(consulta.getPaciente());
        log.info("Nome paciente: " + paciente);
        Medico medico = medicoService.findByName(consulta.getMedico());
        consulta.setValorConsulta(medico.getPrecoConsulta());
        consulta.setEsp(medico.getRole());


        for (Consulta cons : findByData(consulta.getDataHora())) {
            if (findByData(consulta.getDataHora()) != null && medico.getRole().equals(cons.getEsp())) {
                throw new RuntimeException("Vaga ja preenchida!");
            }
        }

        if (consulta.getCov().equals(Convenio.ROLE_PLANOSAUDE)){
                    consulta.setValorConsulta(BigDecimal.valueOf(0));
        }
        if (consulta.getCov().equals(Convenio.ROLE_PARTICULAR)){
                    consulta.setValorConsulta(consulta.getValorConsulta().subtract(consulta.getDesconto()));
        }

            return repository.save(consulta);
    }

    public List<Consulta> findByData(LocalDateTime date){
        List<Consulta> list =  repository.findBydataHora(date);
        String hour = String.valueOf(date);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Consultas para a Data e Hora (%s), não encontradas!", hour));
        }

        return list;
    }

    public List<Consulta> findAll(){
        List<Consulta> list = repository.findAll();

        if (list.isEmpty()){
            throw new ListNotFoundException("Nenhuma consulta foi encontrada!");
        }

        return list;
    }

    public List<Consulta> findByPaciente(String nome){
        List<Consulta> list = repository.findByPaciente(nome);

        if (list.isEmpty()){
            throw new ListNotFoundException(String.format("Nenhuma consulta com o paciente (%s) foi encontrada!", nome));
        }

        return list;
    }

    public Consulta findById(Long id){
        return repository.findById(id).orElseThrow(() ->
                new IdNotFoundException(String.format("Consulta com o ID (%d), não encontrada!", id)));
    }

}
