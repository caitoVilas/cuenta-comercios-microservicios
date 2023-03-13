package com.caito.sucursalradicacionms.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Sucursales_radicacion")
@Data
public class SucursalDeRadicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    private String code;
    @CreationTimestamp
    private LocalDateTime created;
}
