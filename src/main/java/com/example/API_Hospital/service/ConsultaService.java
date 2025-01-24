package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Consulta;
import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.entity.Role.Convenio;
import com.example.API_Hospital.repository.ConsultaRepository;
import com.example.API_Hospital.repository.MedicoRepository;
import com.example.API_Hospital.repository.PacienteRepository;
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

        if (findByData(consulta.getDataHora()) == null){
            if (consulta.getCov().equals(Convenio.ROLE_PLANOSAUDE)){
                consulta.setValorConsulta(BigDecimal.valueOf(0));
            }
            if (consulta.getCov().equals(Convenio.ROLE_PARTICULAR)){
                consulta.setValorConsulta(consulta.getValorConsulta().subtract(consulta.getDesconto()));
            }
        }

        Consulta cons = findByData(consulta.getDataHora());
        if (consulta.getDataHora() == cons.getDataHora()){
            throw new RuntimeException("Vaga ja preenchida!");
        }

            return repository.save(consulta);
    }

    public Consulta findByData(LocalDateTime date){
        return repository.findBydataHora(date);
    }
}
