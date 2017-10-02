package com.example.lc_xxx.actividadaculumatica;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuTecnicoActivity extends AppCompatActivity implements View.OnClickListener, AgregarTecnicoFragment.OnFragmentInteractionListener, ListarTecnicosFragment.OnFragmentInteractionListener, ModificarTecnicoFragment.OnFragmentInteractionListener{


    Button btnGoAgregarTecnico, btnGoModificarTecnico, btnGoListarTecnico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tecnico);

        AgregarTecnicoFragment fragmentAgregar = new AgregarTecnicoFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.containerTecnicos, fragmentAgregar).commit();

        btnGoAgregarTecnico = (Button) findViewById(R.id.btnGoAgregarTecnico); btnGoAgregarTecnico.setOnClickListener(this);
        btnGoModificarTecnico = (Button) findViewById(R.id.btnGoModificarTecnico); btnGoModificarTecnico.setOnClickListener(this);
        btnGoListarTecnico = (Button) findViewById(R.id.btnGoListarTecnico); btnGoListarTecnico.setOnClickListener(this);


    }



    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnGoAgregarTecnico:
                AgregarTecnicoFragment fragmentAgregarTecnico = new AgregarTecnicoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerTecnicos, fragmentAgregarTecnico);
                transaction.commit();
                break;
            case R.id.btnGoModificarTecnico:
                ModificarTecnicoFragment fragmentModificarTecnico = new ModificarTecnicoFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.containerTecnicos, fragmentModificarTecnico);
                transaction1.commit();
                break;
            case R.id.btnGoListarTecnico:
                ListarTecnicosFragment fragmentLista = new ListarTecnicosFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerTecnicos, fragmentLista);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(this, "Opcion Agregar", Toast.LENGTH_SHORT).show();
                AgregarTecnicoFragment fragmentAgregarTecnico = new AgregarTecnicoFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerTecnicos, fragmentAgregarTecnico);
                transaction.commit();
                return true;
            case R.id.MnuOpc3:
                Toast.makeText(this, "Opcion Modificar", Toast.LENGTH_SHORT).show();
                ModificarTecnicoFragment fragmentModificarTecnico = new ModificarTecnicoFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.containerTecnicos, fragmentModificarTecnico);
                transaction1.commit();
                return true;
            case R.id.MnuOpc4:
                Toast.makeText(this, "Opcion Listar", Toast.LENGTH_SHORT).show();
                ListarTecnicosFragment fragmentLista = new ListarTecnicosFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.containerTecnicos, fragmentLista);
                fragmentTransaction.commit();
                return true;
            default:
                Toast.makeText(this, "ERROR!!!", Toast.LENGTH_SHORT).show();
                //DIRECCIONAR AL MENU PRINCIPA
                return super.onOptionsItemSelected(item);
        }
    }


}
