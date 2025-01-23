package com.example.API_Hospital.dto;

import java.time.LocalDate;

public record PacienteDTO(
        Long id,
        String nome,
        LocalDate nascimento
) {
}
