package com.example.API_Hospital.entity;

import com.example.API_Hospital.entity.Role.Especializacao;
import com.example.API_Hospital.entity.Role.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Medico extends Pessoa {

    @NotBlank
    @Column(unique = true)
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Especializacao role;
    private BigDecimal precoConsulta;
}
