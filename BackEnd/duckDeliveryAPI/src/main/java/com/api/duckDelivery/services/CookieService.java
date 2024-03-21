package com.api.duckDelivery.services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookie(HttpServletResponse responseCookie, String key, String valor,  int segundos){
        Cookie cookie = new Cookie(key, valor);
        cookie.setMaxAge(segundos);
        responseCookie.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest requestCookie, String key){
        return Optional.ofNullable(requestCookie.getCookies())
        .flatMap(cookies -> Arrays.stream(cookies)
        .filter(cookie -> key.equals(cookie.getName()))
        .findAny())
        .map(e -> e.getValue())
        .orElse(null);
    }
}
