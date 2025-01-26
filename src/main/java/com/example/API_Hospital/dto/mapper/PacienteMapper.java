package com.example.API_Hospital.dto.mapper;

import com.example.API_Hospital.dto.PacienteDTO;
import com.example.API_Hospital.entity.Paciente;

import java.util.List;

public class PacienteMapper {

    public static PacienteDTO toDTO(Paciente paciente){
        return new PacienteDTO(paciente.getId(), paciente.getNome(), paciente.getNascimento());
    }

    public static List<PacienteDTO> toAllDto(List<Paciente> pessoa){
        return pessoa.stream().map(PacienteMapper::toDTO).toList();
    }
}
