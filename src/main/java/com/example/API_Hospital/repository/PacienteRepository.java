package com.example.API_Hospital.repository;

import com.example.API_Hospital.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNome(String nome);
    Optional<Paciente> findByNumero(String numero);
}
