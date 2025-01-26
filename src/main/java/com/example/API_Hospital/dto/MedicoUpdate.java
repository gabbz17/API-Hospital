package com.example.API_Hospital.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MedicoUpdate {

    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String endereco;
    @NotBlank
    @Column(unique = true)
    @Size(min = 10, max = 11)
    private String numero;
}
