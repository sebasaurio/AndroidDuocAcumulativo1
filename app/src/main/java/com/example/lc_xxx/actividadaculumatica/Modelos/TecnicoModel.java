package com.example.lc_xxx.actividadaculumatica.Modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lc_xxx.actividadaculumatica.Conexion.ConexionHelper;
import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class TecnicoModel {

    String nombreDB = "DB_ACTIVIDAD";


    public boolean insertarTecnico(Context context, Tecnico tecnico){

        ConexionHelper con = new ConexionHelper(context,nombreDB,null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("rut", tecnico.getRut());
        values.put("nombre", tecnico.getNombre());
        values.put("edad", tecnico.getEdad());
        values.put("telefono",tecnico.getTelefono());
        values.put("direccion",tecnico.getDireccion());
        values.put("password", tecnico.getPassword());

        long i = db.insert("tecnico",null, values);
        if(i>0){
            return true;
        }
        return false;
    }

    public boolean eliminarTecnico(Context context, Tecnico tecnico) throws Exception{

        ConexionHelper con =  new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getWritableDatabase();
        String[] parametros = {tecnico.getRut()};

        if(db.delete("tecnico","rut = ?", parametros)>0){
            return true;
        }
        return false;
    }

    public boolean modificarTecnico(Context context, Tecnico tecnico){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametros = {tecnico.getRut()};


        ContentValues content = new ContentValues();
        content.put("nombre", tecnico.getNombre());
        content.put("edad", tecnico.getEdad());
        content.put("telefono", tecnico.getTelefono());
        content.put("direccion", tecnico.getDireccion());
        content.put("password", tecnico.getPassword());

        int i = db.update("tecnico",content, "rut=?", parametros);
        return i > 0;
    }

    public ArrayList<Tecnico> selectTecnicos(Context context){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        Tecnico tecnico = null;

        ArrayList<Tecnico> listaTecnico = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT id_tecnico,rut,nombre,edad,telefono,direccion,password from tecnico", null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            tecnico = new Tecnico();
            tecnico.setId_tecnico(cursor.getInt(0));
            tecnico.setRut(cursor.getString(1));
            tecnico.setNombre(cursor.getString(2));
            tecnico.setEdad(cursor.getInt(3));
            tecnico.setTelefono(cursor.getInt(4));
            tecnico.setDireccion(cursor.getString(5));
            tecnico.setPassword(cursor.getString(6));
            listaTecnico.add(tecnico);
        }
        return listaTecnico;
    }

    public void selectTecnicoPorRut(Context context, Tecnico tecnico){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametros = {tecnico.getRut()};
    }

    public boolean loginTecnico(Context context, Tecnico tecnico){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametros = {tecnico.getNombre()};

        Cursor cursor = db.rawQuery("SELECT password from tecnico where nombre=?",parametros);
        cursor.moveToFirst();
        Log.i("DATOS", "cursor:"+cursor.getColumnCount());
        if(cursor.getColumnCount()>0){
                Log.i("DATOSCURSOR", "cursor:"+cursor.getString(0));
                if(tecnico.getPassword().equals(cursor.getString(0))) {
                    return true;
                }
        }

        return false;
    }

}
