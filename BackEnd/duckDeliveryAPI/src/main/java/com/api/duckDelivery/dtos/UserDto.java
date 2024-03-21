package com.api.duckDelivery.dto

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;


//Usado para garantir que os dados do cliente está como desejado.
//Utilizando notações e nessa parte so está os dados que o cliente irá inserir.


@Getter
@Setter
public class UserDto implements Serializable {

    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    @Size(max = 11)
    private String telefone;
    @NotBlank
    private String bairro;
    @NotBlank
    private String rua;
    @NotBlank
    private String numero;
    @NotBlank
    private String senha;
}
