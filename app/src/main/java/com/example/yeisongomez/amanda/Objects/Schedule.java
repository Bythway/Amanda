package com.example.yeisongomez.amanda.Objects;

import android.media.Image;

/**
 * Created by YeisonGomez on 9/01/17.
 */

public class Schedule {

    private int SCHEDULE_ID;
    private String CODIGO;
    private String CODIGOGRUPO;
    private String DIA;
    private String DOCENTE;
    private String ESPACIOFISICO;
    private String LOCALIDAD;
    private String NOMBREGRUPO;
    private String NOMBREMATERIA;
    private String NOMENCLATURA;
    private String TIEMPO;
    private String UNID_NOMBRE;
    private String STRING_RESOURCES;
    private boolean notificate;

    public Schedule(int SCHEDULE_ID, String CODIGO, String CODIGOGRUPO, String DIA, String DOCENTE, String LOCALIDAD, String ESPACIOFISICO, String NOMBREGRUPO, String NOMBREMATERIA, String NOMENCLATURA, String TIEMPO, String UNID_NOMBRE) {
        this.SCHEDULE_ID = SCHEDULE_ID;
        this.CODIGO = CODIGO;
        this.CODIGOGRUPO = CODIGOGRUPO;
        this.DIA = DIA;
        this.DOCENTE = DOCENTE;
        this.LOCALIDAD = LOCALIDAD;
        this.ESPACIOFISICO = ESPACIOFISICO;
        this.NOMBREGRUPO = NOMBREGRUPO;
        this.NOMBREMATERIA = NOMBREMATERIA;
        this.NOMENCLATURA = NOMENCLATURA;
        this.TIEMPO = TIEMPO;
        this.UNID_NOMBRE = UNID_NOMBRE;
        this.STRING_RESOURCES = DIA + " " + TIEMPO + " ➜ " + NOMENCLATURA;
    }

    public int getSCHEDULE_ID() {
        return SCHEDULE_ID;
    }

    public String getDIA() {
        return DIA;
    }

    public void setDIA(String DIA) {
        this.DIA = DIA;
    }

    public String getCODIGOGRUPO() {
        return CODIGOGRUPO;
    }

    public void setCODIGOGRUPO(String CODIGOGRUPO) {
        this.CODIGOGRUPO = CODIGOGRUPO;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getDOCENTE() {
        return DOCENTE;
    }

    public void setDOCENTE(String DOCENTE) {
        this.DOCENTE = DOCENTE;
    }

    public String getESPACIOFISICO() {
        return ESPACIOFISICO;
    }

    public void setESPACIOFISICO(String ESPACIOFISICO) {
        this.ESPACIOFISICO = ESPACIOFISICO;
    }

    public String getLOCALIDAD() {
        return LOCALIDAD;
    }

    public void setLOCALIDAD(String LOCALIDAD) {
        this.LOCALIDAD = LOCALIDAD;
    }

    public String getNOMBREGRUPO() {
        return NOMBREGRUPO;
    }

    public void setNOMBREGRUPO(String NOMBREGRUPO) {
        this.NOMBREGRUPO = NOMBREGRUPO;
    }

    public String getNOMBREMATERIA() {
        return NOMBREMATERIA;
    }

    public void setNOMBREMATERIA(String NOMBREMATERIA) {
        this.NOMBREMATERIA = NOMBREMATERIA;
    }

    public String getNOMENCLATURA() {
        return NOMENCLATURA;
    }

    public void setNOMENCLATURA(String NOMENCLATURA) {
        this.NOMENCLATURA = NOMENCLATURA;
    }

    public String getTIEMPO() {
        return TIEMPO;
    }

    public void setTIEMPO(String TIEMPO) {
        this.TIEMPO = TIEMPO;
    }

    public String getUNID_NOMBRE() {
        return UNID_NOMBRE;
    }

    public void setUNID_NOMBRE(String UNID_NOMBRE) {
        this.UNID_NOMBRE = UNID_NOMBRE;
    }

    public String getSTRING_RESOURCES() {
        return STRING_RESOURCES;
    }

    public void setSTRING_RESOURCES(String STRING_RESOURCES) {
        this.STRING_RESOURCES += "\n" + STRING_RESOURCES;
    }

    public boolean isNotificate() {
        return notificate;
    }

    public void setNotificate(boolean notificate) {
        this.notificate = notificate;
    }
}
