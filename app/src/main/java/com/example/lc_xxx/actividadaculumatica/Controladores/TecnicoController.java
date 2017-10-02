package com.example.lc_xxx.actividadaculumatica.Controladores;

import android.content.Context;
import android.util.Log;

import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;
import com.example.lc_xxx.actividadaculumatica.Modelos.TecnicoModel;

import java.util.List;

/**
 * Created by LC_XXX on 28-09-2017.
 */

public class TecnicoController {

    public boolean loginTecnico(Context context, String nombre, String password){
        TecnicoModel modelo = new TecnicoModel();
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setPassword(password);
        return modelo.loginTecnico(context, tecnico);
    }

    public boolean registrarTecnico(Context context, String nombre, String password, String rut, int edad, int telefono, String direccion){
        TecnicoModel modelo = new TecnicoModel();
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setPassword(password);
        tecnico.setRut(rut);
        tecnico.setEdad(edad);
        tecnico.setTelefono(telefono);
        tecnico.setDireccion(direccion);
        return modelo.insertarTecnico(context, tecnico);
    }

    public boolean eliminarTecnico(Context context, String rut) throws Exception {
        Tecnico tecnico = new Tecnico();
        TecnicoModel modelo = new TecnicoModel();
        tecnico.setRut(rut);

        return modelo.eliminarTecnico(context,tecnico);
    }

    public boolean modificarTecnico(Context context, String rut, String nombre, int edad, int telefono, String direccion){
        Tecnico tecnico = new Tecnico();
        TecnicoModel modelo = new TecnicoModel();
        tecnico.setRut(rut);
        tecnico.setNombre(nombre);
        tecnico.setEdad(edad);
        tecnico.setTelefono(telefono);
        tecnico.setDireccion(direccion);
        return modelo.modificarTecnico(context,tecnico);
    }

    public List<Tecnico> selectTecnicos(Context context){
        TecnicoModel modelo = new TecnicoModel();
        Log.i("controller", "-"+modelo.selectTecnicos(context).size());
        return modelo.selectTecnicos(context);
    }

    public Tecnico selectTecnicoPorRut(Context context, String rut){
        Tecnico tecnico = new Tecnico();
        tecnico.setRut(rut);

        TecnicoModel model = new TecnicoModel();
        return model.selectTecnicoPorRut(context,tecnico);
    }

}
