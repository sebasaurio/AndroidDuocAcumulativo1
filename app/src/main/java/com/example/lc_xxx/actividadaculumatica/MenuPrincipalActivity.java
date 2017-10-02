package com.example.lc_xxx.actividadaculumatica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnGoMenuProductos, btnGoMenuTecnicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnGoMenuProductos = (Button) findViewById(R.id.btnGoMenuProductos);
        btnGoMenuTecnicos = (Button) findViewById(R.id.btnGoMenuTecnico);

        btnGoMenuProductos.setOnClickListener(this);
        btnGoMenuTecnicos.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnGoMenuProductos:
                Intent intentProducto = new Intent(getApplicationContext(), MenuProductoActivity.class);
                startActivity(intentProducto);
                break;
            case R.id.btnGoMenuTecnico:
                Intent intentTecnico = new Intent(getApplicationContext(), MenuTecnicoActivity.class);
                startActivity(intentTecnico);
                break;
        }
    }


}
