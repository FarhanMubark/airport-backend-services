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
public class Waiting_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer seat;
    @NotEmpty
    @Column(columnDefinition = "varchar(5) not null check(type='VIP' or type='ECO' )")
    private String type;
}
