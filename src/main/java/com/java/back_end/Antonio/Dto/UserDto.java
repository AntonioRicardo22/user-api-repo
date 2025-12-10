package com.java.back_end.Antonio.Dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotBlank(message = "Nome é Obrigatório!")
    private String name;
    @NotBlank(message = "Cpf é Obrigatório!")
    private String cpf;
    private String endereço;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

}
