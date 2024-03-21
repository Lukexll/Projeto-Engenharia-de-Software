package com.api.duckDelivery.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Usada para controlar os post, get, put.
@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/login")//URI a nível de classe,
// os end points são acessados a partir de "/duck-delivery"
public class DuckDeliveryController {

}
