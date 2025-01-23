package com.example.API_Hospital.dto;

import com.example.API_Hospital.entity.Especializacao;

public record MedicoDTO(
        Long id,
        String nome,
        Especializacao role
) {
}
