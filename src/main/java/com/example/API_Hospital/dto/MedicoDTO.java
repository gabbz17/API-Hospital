package com.example.API_Hospital.dto;

import com.example.API_Hospital.entity.Role.Especializacao;

import java.math.BigDecimal;

public record MedicoDTO(
        Long id,
        String nome,
        Especializacao role,
        BigDecimal precoConsulta
) {
}
