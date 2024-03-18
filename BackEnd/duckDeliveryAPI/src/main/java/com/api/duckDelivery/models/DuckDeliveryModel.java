package com.api.duckDelivery.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

//Usado para criar um modelo de cadastro.Com restrições.

@Entity
@Table(name = "TB_DUCK_DELIVERY")
public class DuckDeliveryModel implements Serializable {

    //Controlador de conversões
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

}
