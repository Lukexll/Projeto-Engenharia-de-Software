package com.api.duckDelivery.services;

import com.api.duckDelivery.repositories.DuckDeliveryRepository;
import org.springframework.stereotype.Service;

//Usado para criar serviçõs que serão utilizado no controller

@Service //Bean da spring
public class DuckDeliveryService {

    //Injeção de dependência
    final
    DuckDeliveryRepository duckDeliveryRepository;

    public DuckDeliveryService(DuckDeliveryRepository duckDeliveryRepository) {
        this.duckDeliveryRepository = duckDeliveryRepository;
    }
}
