package com.example.yeisongomez.amanda.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.yeisongomez.amanda.Objects.Schedule;

/**
 * Created by YeisonGomez on 10/01/17.
 */

public class ScheduleDB {

    private String TABLE_NAME = "schedule";

    public String SCHEDULE_ID = "SCHEDULE_ID";
    public String CODIGO = "CODIGO";
    public String CODIGOGRUPO = "CODIGOGRUPO";
    public String DIA = "DIA";
    public String DOCENTE = "DOCENTE";
    public String ESPACIOFISICO = "ESPACIOFISICO";
    public String LOCALIDAD = "LOCALIDAD";
    public String NOMBREGRUPO = "NOMBREGRUPO";
    public String NOMBREMATERIA = "NOMBREMATERIA";
    public String NOMENCLATURA = "NOMENCLATURA";
    public String TIEMPO = "TIEMPO";
    public String UNID_NOMBRE = "UNID_NOMBRE";

    private static Context ctx;
    private SQLiteDatabase DB;
    private InitialDB DBInitial;

    ScheduleDB(Context ctx){ this.ctx = ctx; }

    public void open() throws SQLException {
        DBInitial = new InitialDB(this.ctx);
        DB = DBInitial.getWritableDatabase();
    }

    public void close() {
        if (DBInitial != null){
            DBInitial.close();
        }
    }

    public long createSchedule(Schedule schedule){
        ContentValues values = new ContentValues();
        values.put(CODIGO, schedule.getCODIGO());
        values.put(CODIGOGRUPO, schedule.getCODIGOGRUPO());
        values.put(DIA, schedule.getDIA());
        values.put(DOCENTE, schedule.getDOCENTE());
        values.put(ESPACIOFISICO, schedule.getESPACIOFISICO());
        values.put(LOCALIDAD, schedule.getLOCALIDAD());
        values.put(NOMBREGRUPO, schedule.getNOMBREGRUPO());
        values.put(NOMBREMATERIA, schedule.getNOMBREMATERIA());
        values.put(NOMENCLATURA, schedule.getNOMENCLATURA());
        values.put(TIEMPO, schedule.getTIEMPO());
        values.put(UNID_NOMBRE, schedule.getUNID_NOMBRE());
        return DB.insert(TABLE_NAME, null, values);
    }

    public Schedule getScheduleById(int id){
        Cursor cursor = DB.query(
                TABLE_NAME,
                new String[]{ SCHEDULE_ID, CODIGO, CODIGOGRUPO, DIA, DOCENTE, ESPACIOFISICO, LOCALIDAD, NOMBREGRUPO, NOMBREMATERIA, NOMENCLATURA, TIEMPO, UNID_NOMBRE},
                SCHEDULE_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();

        return new Schedule(
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
                cursor.getString(10),
                cursor.getString(11)
        );
    }

    public Cursor getSchedule(){
        Cursor cursor = DB.query(
                TABLE_NAME,
                new String[]{ SCHEDULE_ID, CODIGO, CODIGOGRUPO, DIA, DOCENTE, ESPACIOFISICO, LOCALIDAD, NOMBREGRUPO, NOMBREMATERIA, NOMENCLATURA, TIEMPO, UNID_NOMBRE},
                null, null, null, null, null
        );
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public void updateSchedule(Schedule schedule){
        ContentValues values = new ContentValues();
        values.put(CODIGO, schedule.getCODIGO());
        values.put(CODIGOGRUPO, schedule.getCODIGOGRUPO());
        values.put(DIA, schedule.getDIA());
        values.put(DOCENTE, schedule.getDOCENTE());
        values.put(ESPACIOFISICO, schedule.getESPACIOFISICO());
        values.put(LOCALIDAD, schedule.getLOCALIDAD());
        values.put(NOMBREGRUPO, schedule.getNOMBREGRUPO());
        values.put(NOMBREMATERIA, schedule.getNOMBREMATERIA());
        values.put(NOMENCLATURA, schedule.getNOMENCLATURA());
        values.put(TIEMPO, schedule.getTIEMPO());
        values.put(UNID_NOMBRE, schedule.getUNID_NOMBRE());
        DB.update(TABLE_NAME, values, SCHEDULE_ID + "=?", new String[]{String.valueOf(schedule.getSCHEDULE_ID())});
    }

    public void deleteScheduleById(int id){
        DB.delete(TABLE_NAME, SCHEDULE_ID + "=?", new String[]{String.valueOf(id)});
    }

}
