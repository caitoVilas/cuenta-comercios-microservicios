package com.caito.comercioms.repository;

import com.caito.comercioms.entity.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercioRepository extends JpaRepository<Comercio, Long> {
    boolean existsByCuit(String cuit);
    boolean existsByEmail(String email);
}
