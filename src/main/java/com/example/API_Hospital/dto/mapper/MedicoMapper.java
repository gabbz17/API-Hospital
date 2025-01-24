package com.example.API_Hospital.dto.mapper;

import com.example.API_Hospital.dto.MedicoDTO;
import com.example.API_Hospital.entity.Medico;

import java.util.List;

public class MedicoMapper {

    public static MedicoDTO toDTO(Medico medico){
        return new MedicoDTO(medico.getId(), medico.getNome(), medico.getRole(), medico.getPrecoConsulta());
    }

    public static List<MedicoDTO> toAllDto(List<Medico> pessoa){
        return pessoa.stream().map(MedicoMapper::toDTO).toList();
    }
}
