package com.example.airportsystem.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    @NotEmpty
    private String name;

    @Column(columnDefinition = "boolean", nullable = false)
    private Boolean checkin;
    @NotEmpty
    @Column(columnDefinition = "varchar(7) check(gender='male' or gender='female')",nullable = false)
    private String gender;

}
