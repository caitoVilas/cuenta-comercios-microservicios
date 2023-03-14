package com.caito.usuarioms.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author: caito Vilas
 */

@Entity
@Table(name = "personas")
@SQLDelete(sql = "UPDATE personas SET deleted=true WHERE id=?")
@Where(clause = "deleted=false")
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String surname;
    @Column(length = 8)
    private String dni;
    private String domicilio;
    private String localidad;
    private String provincia;
    private String telefono;
    @Column(length = 70)
    private String email;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private boolean deleted;
}
