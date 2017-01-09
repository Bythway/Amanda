package com.example.yeisongomez.amanda.Oauth2_chaira;

/**
 * Created by YeisonGomez on 9/01/17.
 */

public class Oauth2Me {
    public static String CLIENT_ID = "668927208865";
    public static String SECRET_ID = "lywdr17xg5k84ew3one4zv6o8k3mnp";
    public static String REDIRECT_URI = "http://localhost";
    private String API_URL = "http://chaira.udla.edu.co/api/v0.1/oauth2";

    public String getUrlAuthorizationUser(){
        return API_URL + "/authorize.asmx/auth?response_type=code&client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&state=xyz";
    }

    public String getUrlAuthorizationCode(){
        return API_URL + "/authorize.asmx/token";
    }

    public String getUrlRefreshToken(){
        return API_URL + "/authorize.asmx/refreshToken";
    }

    public String getUrlLogout(){
        return API_URL + "/resource.asmx/logout";
    }
}
