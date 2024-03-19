package com.api.duckDelivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;



@Entity
@Table(name = "TB_USER")
@Getter
@Setter
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String nome;
    private String telefone;
    private String bairro;
    private String rua;
    private String numero;
    private String senha;

    

}
