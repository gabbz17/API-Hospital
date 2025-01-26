package com.example.API_Hospital.entity;

import com.example.API_Hospital.entity.Role.Convenio;
import com.example.API_Hospital.entity.Role.Especializacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String paciente;
    @NotBlank
    private String medico;
    @NotNull
    private LocalDateTime dataHora;
    private Especializacao esp;
    private BigDecimal valorConsulta;
    private BigDecimal desconto;
    @NotNull
    private Convenio cov;
}
