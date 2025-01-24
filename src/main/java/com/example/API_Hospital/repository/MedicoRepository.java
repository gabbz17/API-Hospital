package com.example.API_Hospital.repository;

import com.example.API_Hospital.entity.Medico;
import com.example.API_Hospital.entity.Role.Especializacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Medico findByNome(String name);
    List<Medico> findByrole(Especializacao esp);
}
