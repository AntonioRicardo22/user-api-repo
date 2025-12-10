package com.java.back_end.Antonio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "User")
@Entity(name = "User")
@RequiredArgsConstructor

@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String cpf;
    private String endereço;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
}
