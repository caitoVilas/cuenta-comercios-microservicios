package com.caito.usuarioms.repository;

import com.caito.usuarioms.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByDni(String dni);
    boolean existsByEmail(String email);
}
