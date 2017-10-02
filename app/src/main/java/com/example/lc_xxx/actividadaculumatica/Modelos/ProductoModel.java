package com.example.lc_xxx.actividadaculumatica.Modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lc_xxx.actividadaculumatica.Conexion.ConexionHelper;
import com.example.lc_xxx.actividadaculumatica.Entidades.Producto;
import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;

import java.util.ArrayList;

/**
 * Created by LC_XXX on 28-09-2017.
 */

public class ProductoModel {

    String nombreDB = "DB_ACTIVIDAD";

    public boolean insertarProducto(Context context, Producto producto){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("tipo_producto", producto.getTipo_producto());
        content.put("nombre_cliente", producto.getNombre_cliente());
        content.put("telefono_cliente", producto.getTelefono_cliente());
        content.put("nombre_producto",producto.getNombre_producto());
        //content.put("id_tecnico", tecnico.getId_tecnico());

        long i = db.insert("producto", null, content);
        return i > 0;
    }

    public boolean modificarProducto(Context context, Producto producto){
        ConexionHelper con = new ConexionHelper(context,nombreDB,null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        String[] parametros = {producto.getNombre_producto()};

        ContentValues content = new ContentValues();
        content.put("nombre_cliente", producto.getNombre_cliente());
        content.put("telefono_cliente", producto.getTelefono_cliente());
        content.put("tipo_producto", producto.getTipo_producto());

        if(db.update("producto",content,"nombre_producto=?",parametros)>0){
            return true;
        }
        return  false;

    }

    public boolean eliminarProducto(Context context, Producto producto){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getWritableDatabase();

        String[] parametros = {producto.getNombre_producto()};
        if(db.delete("producto","nombre_producto=?",parametros)>0) {
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Producto> selectProductos(Context context){
        ConexionHelper con = new ConexionHelper(context, nombreDB, null, 1);
        SQLiteDatabase db = con.getReadableDatabase();

        Producto producto = null;
        ArrayList<Producto> listaProducto = new ArrayList<>();

        Cursor cursor = db.rawQuery("select id_producto, tipo_producto, nombre_cliente, telefono_cliente, nombre_producto from producto", null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            producto = new Producto();
            producto.setId_producto(cursor.getInt(0));
            producto.setTipo_producto(cursor.getString(1));
            producto.setNombre_cliente(cursor.getString(2));
            producto.setTelefono_cliente(cursor.getInt(3));
            producto.setNombre_producto(cursor.getString(4));
            listaProducto.add(producto);
        }

        return listaProducto;

    }


}
