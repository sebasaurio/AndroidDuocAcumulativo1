package com.example.lc_xxx.actividadaculumatica.Controladores;

import android.content.Context;

import com.example.lc_xxx.actividadaculumatica.Conexion.ConexionHelper;
import com.example.lc_xxx.actividadaculumatica.Entidades.Producto;
import com.example.lc_xxx.actividadaculumatica.Modelos.ProductoModel;

/**
 * Created by LC_XXX on 28-09-2017.
 */

public class ProductoController {

    public boolean insertarProducto(Context context, String nombre_producto, String tipo_producto, String nombre_cliente, int telefono_cliente){
        Producto producto = new Producto();
        producto.setNombre_producto(nombre_producto);
        producto.setTelefono_cliente(telefono_cliente);
        producto.setTipo_producto(tipo_producto);
        producto.setNombre_cliente(nombre_cliente);

        ProductoModel model = new ProductoModel();
        return model.insertarProducto(context,producto);

    }

    public boolean modificarProducto(Context context, String nombre_producto, String tipo_producto, String nombre_cliente, int telefono_cliente){
        Producto producto = new Producto();
        producto.setNombre_producto(nombre_producto);
        producto.setTelefono_cliente(telefono_cliente);
        producto.setTipo_producto(tipo_producto);
        producto.setNombre_cliente(nombre_cliente);

        ProductoModel model = new ProductoModel();
        return model.modificarProducto(context, producto);
    }

    public boolean eliminarProducto(Context context, String nombre_producto){
        Producto producto = new Producto();
        producto.setNombre_producto(nombre_producto);

        ProductoModel model = new ProductoModel();
        return model.eliminarProducto(context, producto);
    }

}
