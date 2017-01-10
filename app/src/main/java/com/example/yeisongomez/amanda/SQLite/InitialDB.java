package com.example.yeisongomez.amanda.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by YeisonGomez on 10/01/17.
 */

public class InitialDB extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "db_amanda";
    private static final int DATABASE_VERSION = 1;

    public String TABLE_USER = "user";
    public String TABLE_SCHEDULE = "schedule";
    public String TABLE_REMINDER = "reminder";
    public String TABLE_SETTINGS = "settings";

    InitialDB(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_SCHEDULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REMINDER);
        onCreate(db);
    }

    private String CREATE_TABLE_USER = TABLE_USER + " ( " +
            "USER_ID INTEGER PRIMARY KEY autoincrement, " +
            "CORREO TEXT, " +
            "NOMBRES TEXT, " +
            "APELLIDOS TEXT, " +
            "GENERO TEXT, " +
            "RH TEXT, " +
            "ROL TEXT, " +
            "DEPARTAMENTO TEXT, " +
            "MUNICIPIO TEXT, " +
            "ESTADO TEXT, " +
            "FOTO TEXT);";

    private String CREATE_TABLE_SCHEDULE = TABLE_SCHEDULE + " ( " +
            "SCHEDULE_ID INTEGER PRIMARY KEY autoincrement," +
            "CODIGO TEXT," +
            "CODIGOGRUPO TEXT," +
            "DIA TEXT," +
            "DOCENTE TEXT," +
            "ESPACIOFISICO TEXT," +
            "LOCALIDAD TEXT," +
            "NOMBREGRUPO TEXT," +
            "NOMBREMATERIA TEXT," +
            "NOMENCLATURA TEXT," +
            "TIEMPO TEXT," +
            "UNID_NOMBRE TEXT);";

    private String CREATE_TABLE_REMINDER = TABLE_REMINDER + " ( " +
            "REMINDER_ID INTEGER PRIMARY KEY autoincrement," +
            "SUBJECT TEXT," +
            "DESCRIPTION TEXT," +
            "IMPORTANT INTEGER," +
            "HORA TEXT);";

    //private String CREATE_TABLE_SETTINGS = TABLE_SETTINGS + "()";


    private String CREATE_USER = "CREATE TABLE if not exists " + CREATE_TABLE_USER;
    private String CREATE_SCHEDULE = "CREATE TABLE if not exists "+ CREATE_TABLE_SCHEDULE;
}
