package com.example.API_Hospital.service;

import com.example.API_Hospital.entity.Consulta;
import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Paciente;
import com.example.API_Hospital.entity.Role.Convenio;
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

        List<Consulta> cs = findByData(consulta.getDataHora());

        for (Consulta cons : cs) {
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
        return repository.findBydataHora(date);
    }

    public List<Consulta> findAll(){
        return repository.findAll();
    }

}
