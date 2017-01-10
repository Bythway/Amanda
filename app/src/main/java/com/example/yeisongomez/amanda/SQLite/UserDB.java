package com.example.yeisongomez.amanda.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.yeisongomez.amanda.Objects.User;

/**
 * Created by YeisonGomez on 10/01/17.
 */

public class UserDB {

    private String TABLE_NAME = "user";

    private String USER_ID = "USER_ID";
    private String APELLIDOS = "APELLIDOS";
    private String NOMBRES = "NOMBRES";
    private String GENERO = "GENERO";
    private String RH = "RH";
    private String CORREO = "CORREO";
    private String ROL = "ROL";
    private String DEPARTAMENTO = "DEPARTAMENTO";
    private String MUNICIPIO = "MUNICIPIO";
    private String ESTADO = "ESTADO";
    private String FOTO = "FOTO";

    private static Context ctx;
    private SQLiteDatabase DB;
    private InitialDB DBInitial;

    UserDB(Context ctx){ this.ctx = ctx; }

    public void open() throws SQLException {
        DBInitial = new InitialDB(this.ctx);
        DB = DBInitial.getWritableDatabase();
    }

    public void close() {
        if (DBInitial != null){
            DBInitial.close();
        }
    }

    public long createUser(User user){
        ContentValues values = new ContentValues();
        values.put(APELLIDOS, user.getAPELLIDOS());
        values.put(NOMBRES, user.getNOMBRES());
        values.put(GENERO, user.getGENERO());
        values.put(RH, user.getRH());
        values.put(CORREO, user.getCORREO());
        values.put(ROL, user.getROL());
        values.put(DEPARTAMENTO, user.getDEPARTAMENTO());
        values.put(MUNICIPIO, user.getMUNICIPIO());
        values.put(ESTADO, user.getESTADO());
        values.put(FOTO, user.getFOTO());
        return DB.insert(TABLE_NAME, null, values);
    }

    public User getUserById(int id){
        Cursor cursor = DB.query(
                TABLE_NAME,
                new String[]{ USER_ID, APELLIDOS, NOMBRES, GENERO, RH, CORREO, ROL, DEPARTAMENTO, MUNICIPIO, ESTADO, FOTO},
                USER_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        return new User(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10)
        );
    }

    public Cursor getUsers(){
        Cursor cursor = DB.query(
                TABLE_NAME,
                new String[]{ USER_ID, APELLIDOS, NOMBRES, GENERO, RH, CORREO, ROL, DEPARTAMENTO, MUNICIPIO, ESTADO, FOTO},
                null, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }
}
