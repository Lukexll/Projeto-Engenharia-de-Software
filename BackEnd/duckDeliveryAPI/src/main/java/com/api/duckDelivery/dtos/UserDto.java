package com.api.duckDelivery.dtos;

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
    private String name;
    @NotBlank
    @Size(max = 11)
    private String telephone;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String road;
    @NotBlank
    private String number;
    @NotBlank
    private String password;
}
