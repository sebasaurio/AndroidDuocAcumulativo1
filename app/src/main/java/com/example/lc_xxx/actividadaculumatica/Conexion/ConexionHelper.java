package com.example.lc_xxx.actividadaculumatica.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LC_XXX on 28-09-2017.
 */

public class ConexionHelper extends SQLiteOpenHelper{

    String SQL_CREATE_TABLE_TECNICO = "CREATE TABLE tecnico(id_tecnico INTEGER auto_increment primary key, " +
            "rut TEXT, " +
            "nombre TEXT, " +
            "edad INTEGER, " +
            "telefono INTEGER, " +
            "direccion TEXT, password TEXT)";

    //TIPO-PRODUCTO : Computador,notebook, etc

    String SQL_CREATE_TABLE_PRODUCTO = "CREATE TABLE producto(id_producto INTEGER auto_increment primary key," +
            "tipo_producto TEXT," +
            "nombre_producto TEXT," +
            "nombre_cliente TEXT," +
            "telefono_cliente INTEGER," +
            "id_tecnico INTEGER)";

    public ConexionHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_PRODUCTO);
        db.execSQL(SQL_CREATE_TABLE_TECNICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST tecnico");
        db.execSQL("DROP TABLE IF EXIST producto");
        onCreate(db);
    }
}

