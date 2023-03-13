package com.caito.comercioms.entity;

import com.caito.comercioms.enums.Categoria;
import com.caito.comercioms.enums.EstadoComercio;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comercios")
@SQLDelete(sql = "UPDATE comercios SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
@Data
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String razonSocial;
    private String domicilio;
    @Column(length = 70)
    private String localidad;
    @Column(length = 50)
    private String provincia;
    @Column(length = 70)
    private String email;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Column(length = 15)
    private String cuit;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private EstadoComercio estadoComercio;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private boolean deleted;
}
