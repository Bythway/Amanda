package com.example.yeisongomez.amanda.Objects;

/**
 * Created by YeisonGomez on 9/01/17.
 */

public class User {

    private int USER_ID;
    private String APELLIDOS;
    private String NOMBRES;
    private String GENERO;
    private String RH;
    private String CORREO;
    private String ROL;
    private String DEPARTAMENTO;
    private String MUNICIPIO;
    private String ESTADO;
    private String FOTO;

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
        return this.parse(APELLIDOS);
    }

    public void setAPELLIDOS(String APELLIDOS) {
        this.APELLIDOS = APELLIDOS;
    }

    public String getNOMBRES() {
        return this.parse(NOMBRES);
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
        return this.parse(CORREO);
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    public String getROL() {
        return this.parse(ROL);
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
        return this.parse(DEPARTAMENTO);
    }

    public void setDEPARTAMENTO(String DEPARTAMENTO) {
        this.DEPARTAMENTO = DEPARTAMENTO;
    }

    public String getESTADO() {
        return this.parse(ESTADO);
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
        return this.parse(MUNICIPIO);
    }

    public void setMUNICIPIO(String MUNICIPIO) {
        this.MUNICIPIO = MUNICIPIO;
    }

    public String getNombreApellido(){
        String nombre = this.NOMBRES.split(" ")[0];
        String apellido = this.APELLIDOS.split(" ")[0];
        return this.parse(nombre + " " + apellido);
    }

    private String parse(String text){
        String total = "";
        String[] texts = text.split(" ");
        for(int i = 0; i < texts.length; i++){
            total += texts[i].substring(0, 1) + texts[i].toLowerCase().substring(1, texts[i].length());
            if (i + 1 < texts.length )
                total += " ";
        }
        return total;
    }
}
