package com.example.lc_xxx.actividadaculumatica;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lc_xxx.actividadaculumatica.Controladores.TecnicoController;
import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AgregarTecnicoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AgregarTecnicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarTecnicoFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    EditText txtAgregarTecnicoNombre, txtAgregarTecnicoPassword, txtAgregarTecnicoRut, txtAgregarTecnicoEdad, txtAgregarTecnicoTelefono, txtAgregarTecnicoDireccion;
    Button btnCancelarCrearTecnico, btnAgregarTecnico;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AgregarTecnicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarTecnicoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarTecnicoFragment newInstance(String param1, String param2) {
        AgregarTecnicoFragment fragment = new AgregarTecnicoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnCancelarCrearTecnico:
                limpiar();
                break;
            case R.id.btnAgregarTecnico:

                int auxAgregarTecnico = 0;
                TecnicoController controller = new TecnicoController();
                String nombre = txtAgregarTecnicoNombre.getText().toString();
                String password = txtAgregarTecnicoPassword.getText().toString();
                String rut = txtAgregarTecnicoRut.getText().toString();
                int edad = 0;
                if(txtAgregarTecnicoEdad.getText().toString().length()>0){
                    edad = Integer.parseInt(txtAgregarTecnicoEdad.getText().toString());
                }
                int telefono = 0;
                if(txtAgregarTecnicoTelefono.getText().toString().length()>0){
                    telefono = Integer.parseInt(txtAgregarTecnicoTelefono.getText().toString());
                }
                String direccion = txtAgregarTecnicoDireccion.getText().toString();


                if(nombre.length()==0) {txtAgregarTecnicoNombre.setError("Campo requerido"); auxAgregarTecnico+=1; }
                if(password.length()==0){txtAgregarTecnicoPassword.setError("Campo requerido"); auxAgregarTecnico+=1;}
                if(rut.length()==0){txtAgregarTecnicoRut.setError("Campo requerido"); auxAgregarTecnico+=1;}
                if(txtAgregarTecnicoEdad.getText().toString().length()==0){txtAgregarTecnicoEdad.setError("Campo requerido"); auxAgregarTecnico+=1;}
                if(txtAgregarTecnicoTelefono.getText().toString().length()==0){txtAgregarTecnicoTelefono.setError("Campo requerido"); auxAgregarTecnico+=1;}
                if(direccion.length()==0){txtAgregarTecnicoDireccion.setError("Campo requerido"); auxAgregarTecnico+=1;}


                if(auxAgregarTecnico == 0) {
                    if (controller.registrarTecnico(getActivity().getApplicationContext(), nombre, password, rut, edad, telefono, direccion)) {
                        Toast.makeText(getActivity().getApplicationContext(), "Registro guardado exitosamente", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
                break;
        }
    }

    public void limpiar(){
        txtAgregarTecnicoNombre.setText("");
        txtAgregarTecnicoPassword.setText("");
        txtAgregarTecnicoRut.setText("");
        txtAgregarTecnicoEdad.setText("");
        txtAgregarTecnicoTelefono.setText("");
        txtAgregarTecnicoDireccion.setText("");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_agregar_tecnico, container, false);

        txtAgregarTecnicoNombre = (EditText)v.findViewById(R.id.txtAgregarTecnicoNombre);
        txtAgregarTecnicoPassword = (EditText)v.findViewById(R.id.txtAgregarTecnicoPassword);
        txtAgregarTecnicoRut = (EditText)v.findViewById(R.id.txtAgregarTecnicoRut);
        txtAgregarTecnicoEdad = (EditText)v.findViewById(R.id.txtAgregarTecnicoEdad);
        txtAgregarTecnicoTelefono = (EditText)v.findViewById(R.id.txtAgregarTecnicoTelefono);
        txtAgregarTecnicoDireccion = (EditText)v.findViewById(R.id.txtAgregarTecnicoDireccion);
        btnCancelarCrearTecnico = (Button)v.findViewById(R.id.btnCancelarCrearTecnico);
        btnAgregarTecnico = (Button)v.findViewById(R.id.btnAgregarTecnico);

        btnCancelarCrearTecnico.setOnClickListener(this);
        btnAgregarTecnico.setOnClickListener(this);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
