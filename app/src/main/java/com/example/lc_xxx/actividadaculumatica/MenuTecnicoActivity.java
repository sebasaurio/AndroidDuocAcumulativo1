package com.example.lc_xxx.actividadaculumatica;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuTecnicoActivity extends AppCompatActivity implements View.OnClickListener, AgregarTecnicoFragment.OnFragmentInteractionListener{


    Button btnGoAgregarTecnico, btnGoModificarTecnico, btnGoListarTecnico, btnGoEliminarTecnico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tecnico);

        AgregarTecnicoFragment fragmentAgregar = new AgregarTecnicoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.containerTecnicos, fragmentAgregar).commit();

        btnGoAgregarTecnico = (Button) findViewById(R.id.btnGoAgregarTecnico); btnGoAgregarTecnico.setOnClickListener(this);
        btnGoModificarTecnico = (Button) findViewById(R.id.btnGoModificarTecnico); btnGoModificarTecnico.setOnClickListener(this);
        btnGoListarTecnico = (Button) findViewById(R.id.btnGoListarTecnico); btnGoListarTecnico.setOnClickListener(this);
        btnGoEliminarTecnico = (Button) findViewById(R.id.btnGoEliminarTecnico); btnGoEliminarTecnico.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnGoAgregarTecnico:
                break;
            case R.id.btnGoModificarTecnico:
                break;
            case R.id.btnGoListarTecnico:
                break;
            case R.id.btnGoEliminarTecnico:
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        
    }
}
