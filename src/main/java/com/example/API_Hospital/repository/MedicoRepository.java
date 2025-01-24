package com.example.API_Hospital.repository;

import com.example.API_Hospital.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, String> {
    Medico findByNome(String name);
}
