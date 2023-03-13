package com.caito.sucursalradicacionms.repository;

import com.caito.sucursalradicacionms.entity.SucursalDeRadicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SucursalDeRadicacionRepository extends JpaRepository<SucursalDeRadicacion, Long> {
    boolean existsByCode(String code);
    boolean existsByName(String name);
    Optional<SucursalDeRadicacion> findByCode(String code);
}
