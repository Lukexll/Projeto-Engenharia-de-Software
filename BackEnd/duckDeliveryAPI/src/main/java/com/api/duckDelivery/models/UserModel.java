package com.api.duckDelivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;



@Entity
@Table(name = "TB_USER")
@Getter
@Setter
public class UserModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 11)
    private String telephone;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String road;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String password;
    



}