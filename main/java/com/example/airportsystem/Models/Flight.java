package com.example.airportsystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @NotEmpty
    @Column(columnDefinition = "varchar(12)",nullable = false)
    private String date;
    @NotNull
    @Column(columnDefinition = "varchar(5)",nullable = false)
    private String gate_number;

    @OneToOne(cascade = CascadeType.ALL) // Automatic save
    @JoinColumn(name = "plane_number" , referencedColumnName = "number")
    private Plane plane;
}
