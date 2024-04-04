package com.api.duckDelivery.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class StoreDto implements Serializable {

    @NotBlank
    private String storeName;
    @NotBlank
    private String businessCategory;
    @NotBlank
    private String road;
    @NotBlank
    private String neighborhood;
    @NotBlank
    private String number;
    @NotBlank
    @Size(max = 11)
    private String telephone;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String openingHours;
    @NotBlank
    @Size(max = 1000)
    private String description;
    @NotBlank
    @Size(max = 14, min = 14)
    private String CNPJ;
}
