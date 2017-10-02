package com.example.lc_xxx.actividadaculumatica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lc_xxx.actividadaculumatica.Controladores.TecnicoController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtUsuarioLogin, txtPasswordLogin;
    Button btnRegistrar, btnAcceder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsuarioLogin = (EditText)findViewById(R.id.txtUsuarioLogin);
        txtPasswordLogin = (EditText) findViewById(R.id.txtPasswordLogin);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnAcceder = (Button) findViewById(R.id.btnAcceder);

        btnRegistrar.setOnClickListener(this);
        btnAcceder.setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnRegistrar:
                registrarCuenta();
                break;
            case R.id.btnAcceder:
                int auxAcceder = 0;
                if(txtUsuarioLogin.length()==0){
                    txtUsuarioLogin.setError("Campo requerido");
                    auxAcceder +=1;
                }
                if(txtPasswordLogin.length()==0){
                    txtPasswordLogin.setError("Campo requerido");
                    auxAcceder += 1;
                }
                if(auxAcceder == 0){
                    loginTecnico();
                }


                break;
            default:
                break;
        }
    }

    public void loginTecnico(){
        TecnicoController controller = new TecnicoController();
        String usuario = txtUsuarioLogin.getText().toString().trim();
        String password = txtPasswordLogin.getText().toString().trim();
        Log.i("DATOS", usuario+"-"+password);
        if(controller.loginTecnico(getApplicationContext(), usuario, password)){
            Toast.makeText(getApplicationContext(), "Accediendo al sistema", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), MenuPrincipalActivity.class));
        }else{
            Toast.makeText(getApplicationContext(), "Verifica las credenciales", Toast.LENGTH_SHORT).show();
        }
    }

    public void registrarCuenta(){
        Intent intent = new Intent(getApplicationContext(), RegistrarActivity.class);
        startActivity(intent);
    }
}
