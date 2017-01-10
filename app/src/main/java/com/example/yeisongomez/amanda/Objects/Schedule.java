package com.example.yeisongomez.amanda.Objects;

/**
 * Created by YeisonGomez on 9/01/17.
 */

public class Schedule {

    public String CODIGO;
    public String CODIGOGRUPO;
    public String DIA;
    public String DOCENTE;
    public String ESPACIOFISICO;
    public String LOCALIDAD;
    public String NOMBREGRUPO;
    public String NOMBREMATERIA;
    public String NOMENCLATURA;
    public String TIEMPO;
    public String UNID_NOMBRE;

    public Schedule(String CODIGO, String CODIGOGRUPO, String DIA, String DOCENTE, String LOCALIDAD, String ESPACIOFISICO, String NOMBREGRUPO, String NOMBREMATERIA, String NOMENCLATURA, String TIEMPO, String UNID_NOMBRE) {
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
}
