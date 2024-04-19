package com.api.duckDelivery.services.Autentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class LoginInterceptorAppConfig extends WebMvcConfigurationSupport {
        
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
        .excludePathPatterns(
            "/login/userRegister",
            "/login/userLogin",
            "/login/red",
            "/login",
            "/js/**",
            "/css/**",
            "/",


    //URI a ser excluida, após teste.
            "/store/storeRegister",
            "/store/storeGet/MrPizzas",
            "/store/storeDelete/MrPizzas",
            "/store/storeGetAll"
        );
    }
}
