package com.example.lc_xxx.actividadaculumatica.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;
import com.example.lc_xxx.actividadaculumatica.R;

import java.util.List;

/**
 * Created by Seba on 02-10-2017.
 */

public class TecnicosAdapter extends RecyclerView.Adapter<TecnicosAdapter.MyViewHolder>{

    private List<Tecnico> listaTecnicos;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lista_tecnicos_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tecnico tecnico = listaTecnicos.get(position);
        holder.txtNombre.setText("Nombre: "+tecnico.getNombre());
        holder.txtRut.setText("Rut: "+tecnico.getRut());
        holder.txtEdad.setText("Edad: "+String.valueOf(tecnico.getEdad()));
        holder.txtTelefono.setText("Telefono: "+String.valueOf(tecnico.getTelefono()));
    }

    @Override
    public int getItemCount() {
       return listaTecnicos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtNombre, txtRut, txtEdad, txtTelefono;

        public MyViewHolder(View view) {
            super(view);
            txtNombre = (TextView) view.findViewById(R.id.txtListNombre);
            txtRut = (TextView) view.findViewById(R.id.txtListRut);
            txtEdad = (TextView) view.findViewById(R.id.txtListEdad);
            txtTelefono = (TextView) view.findViewById(R.id.txtListTelefono);

        }
    }

    public TecnicosAdapter(List<Tecnico> lista){
        this.listaTecnicos = lista;
    }




}
