package com.api.duckDelivery.services.Autentication;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.api.duckDelivery.services.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle
    (HttpServletRequest requestCookie, HttpServletResponse response, Object handler)
    throws Exception {

        //Checar se há um cookie de login para permissão de acesso
        if(CookieService.getCookie(requestCookie, "userId") != null){
            return true;
        }

        //Pra quando tiver a tela de login, redirecionar para ela caso não haja cookie
        //response.sendRedirect("/login");
        return false;
        
    } 

}
