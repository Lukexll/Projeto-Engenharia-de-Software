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
    @Size(max = 14)
    private String CNPJ;
}
