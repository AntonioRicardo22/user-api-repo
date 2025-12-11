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
    @Column(name = "nome")
    private String name;
    private String cpf;
    @Column(name = "endereco")
    private String endereço;
    private String email;
    private String telefone;
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
}
