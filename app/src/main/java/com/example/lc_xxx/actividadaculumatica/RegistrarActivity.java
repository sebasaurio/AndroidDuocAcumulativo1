package com.example.lc_xxx.actividadaculumatica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lc_xxx.actividadaculumatica.Controladores.TecnicoController;

public class RegistrarActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtRegistrarNombre, txtRegistrarRut,txtRegistrarEdad,txtRegistrarTelefono,txtRegistrarDireccion, txtRegistrarPassword;
    Button btnRegistarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnRegistarCuenta = (Button) findViewById(R.id.btnRegistrarCuenta);
        txtRegistrarNombre = (EditText) findViewById(R.id.txtRegistrarNombre);
        txtRegistrarRut = (EditText) findViewById(R.id.txtRegistrarRut);
        txtRegistrarEdad = (EditText) findViewById(R.id.txtRegistrarTelefono);
        txtRegistrarDireccion = (EditText) findViewById(R.id.txtRegistrarDireccion);
        txtRegistrarTelefono = (EditText) findViewById(R.id.txtRegistrarTelefono);
        txtRegistrarPassword = (EditText) findViewById(R.id.txtRegistrarPassword);

        btnRegistarCuenta.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnRegistrarCuenta:
                TecnicoController controller = new TecnicoController();

                String nombre = txtRegistrarNombre.getText().toString();
                String password = txtRegistrarPassword.getText().toString();
                String direccion = txtRegistrarDireccion.getText().toString();
                String rut = txtRegistrarRut.getText().toString();
                int edad = Integer.parseInt(txtRegistrarEdad.getText().toString());
                int telefono = Integer.parseInt(txtRegistrarTelefono.getText().toString());

                if(controller.registrarTecnico(getApplicationContext(), nombre,password,rut,edad,telefono,direccion)){
                    Toast.makeText(getApplicationContext(), "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un inconveniente con \n la conexion a la base de datos", Toast.LENGTH_SHORT).show();
                }

        }
    }
}
