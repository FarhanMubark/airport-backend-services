package com.example.airportsystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)",nullable = false)
    private String name;
    @NotEmpty
    @Column(columnDefinition = "varchar(20)",nullable = false)
    private String type;
    @NotNull
    @Column(columnDefinition = "int",nullable = false)
    private Integer capacity;


}
