package com.example.API_Hospital.entity;

import com.example.API_Hospital.entity.Role.Pessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente extends Pessoa {

    @NotNull
    private LocalDate nascimento;
}
