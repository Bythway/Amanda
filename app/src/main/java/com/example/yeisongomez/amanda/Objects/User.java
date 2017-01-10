package com.example.yeisongomez.amanda.Objects;

/**
 * Created by YeisonGomez on 9/01/17.
 */

public class User {

    public int USER_ID;
    public String APELLIDOS;
    public String NOMBRES;
    public String GENERO;
    public String RH;
    public String CORREO;
    public String ROL;
    public String DEPARTAMENTO;
    public String MUNICIPIO;
    public String ESTADO;
    public String FOTO;

    public User(int USER_ID, String APELLIDOS, String NOMBRES, String GENERO, String RH, String CORREO, String ROL, String DEPARTAMENTO, String MUNICIPIO, String ESTADO, String FOTO) {
        this.USER_ID = USER_ID;
        this.APELLIDOS = APELLIDOS;
        this.NOMBRES = NOMBRES;
        this.GENERO = GENERO;
        this.RH = RH;
        this.CORREO = CORREO;
        this.ROL = ROL;
        this.DEPARTAMENTO = DEPARTAMENTO;
        this.MUNICIPIO = MUNICIPIO;
        this.ESTADO = ESTADO;
        this.FOTO = FOTO;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public void setNOMBRES(String NOMBRES) {
        this.NOMBRES = NOMBRES;
    }

    public String getGENERO() {
        return GENERO;
    }

    public void setGENERO(String GENERO) {
        this.GENERO = GENERO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getROL() {
        return ROL;
    }

    public void setROL(String ROL) {
        this.ROL = ROL;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getDEPARTAMENTO() {
        return DEPARTAMENTO;
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getFOTO() {
        return FOTO;
    }

    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }

    public String getMUNICIPIO() {
        return MUNICIPIO;
    }

    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }
}
