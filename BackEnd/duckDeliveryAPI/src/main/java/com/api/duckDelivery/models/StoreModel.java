package com.api.duckDelivery.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_LOJA")
@Getter
@Setter
public class StoreModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String storeName;
    @Column(nullable = false)
    private String businessCategory;
    @Column(nullable = false)
    private String road;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false, length = 14)
    private String CNPJ;

    @Column(length = 1000)
    private String description;
    private String note;

    @Column
    private String ID_User;
}
