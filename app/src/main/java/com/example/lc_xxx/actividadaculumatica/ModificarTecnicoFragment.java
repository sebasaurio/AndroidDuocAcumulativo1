package com.example.lc_xxx.actividadaculumatica;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lc_xxx.actividadaculumatica.Controladores.TecnicoController;
import com.example.lc_xxx.actividadaculumatica.Entidades.Tecnico;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ModificarTecnicoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ModificarTecnicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModificarTecnicoFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<String> listaRutTecnicos;

    Spinner spinnerModificarTecnicoRut;
    EditText txtModificarTecnicoNombre, txtModificarTecnicoEdad, txtModificarTecnicoTelefono, txtModificarTecnicoDireccion;
    Button btnEliminarAccionTecnico, btnModificarAccionTecnico;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ModificarTecnicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ModificarTecnicoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ModificarTecnicoFragment newInstance(String param1, String param2) {
        ModificarTecnicoFragment fragment = new ModificarTecnicoFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_modificar_tecnico, container, false);;
        spinnerModificarTecnicoRut = (Spinner)v.findViewById(R.id.spinnerModificarTecnicoRut);
        txtModificarTecnicoNombre = (EditText)v.findViewById(R.id.txtModificarTecnicoNombre) ;
        txtModificarTecnicoEdad = (EditText)v.findViewById(R.id.txtModificarTecnicoEdad) ;
        txtModificarTecnicoTelefono = (EditText)v.findViewById(R.id.txtModificarTecnicoTelefono) ;
        txtModificarTecnicoDireccion = (EditText)v.findViewById(R.id.txtModificarTecnicoDireccion) ;
        btnEliminarAccionTecnico = (Button)v.findViewById(R.id.btnEliminarAccionTecnico);
        btnModificarAccionTecnico = (Button)v.findViewById(R.id.btnModificarAccionTecnico);
        btnEliminarAccionTecnico.setOnClickListener(this);
        btnModificarAccionTecnico.setOnClickListener(this);
        btnModificarAccionTecnico.setEnabled(false);
        btnEliminarAccionTecnico.setEnabled(false);
        cargarDatosRutTecnico();

        spinnerModificarTecnicoRut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){
                    String rutSeleccionado = parent.getItemAtPosition(position).toString();
                    TecnicoController controller = new TecnicoController();
                    Tecnico tecnico = controller.selectTecnicoPorRut(getActivity().getApplicationContext(),rutSeleccionado);
                    txtModificarTecnicoNombre.setText(tecnico.getNombre());
                    txtModificarTecnicoEdad.setText(String.valueOf(tecnico.getEdad()));
                    txtModificarTecnicoTelefono.setText(String.valueOf(tecnico.getTelefono()));
                    txtModificarTecnicoDireccion.setText(tecnico.getDireccion());

                    btnModificarAccionTecnico.setEnabled(true);
                    btnEliminarAccionTecnico.setEnabled(true);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

    @Override
    public void onClick(View v) {
        TecnicoController controller = new TecnicoController();
        switch (v.getId()){
            case R.id.btnEliminarAccionTecnico:
                String rutDelete = spinnerModificarTecnicoRut.getSelectedItem().toString();
                try {
                    if(controller.eliminarTecnico(getActivity().getApplicationContext(), rutDelete)){
                        Toast.makeText(getActivity().getApplicationContext(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
                        limpiar();
                        cargarDatosRutTecnico();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnModificarAccionTecnico:

                int auxModificar = 0;
                if(txtModificarTecnicoNombre.getText().toString().length()==0){txtModificarTecnicoNombre.setError("Campo requerido");auxModificar+=1;}
                if(txtModificarTecnicoEdad.getText().toString().length()==0){txtModificarTecnicoEdad.setError("Campo requerido");auxModificar+=1;}
                if(txtModificarTecnicoTelefono.getText().toString().length()==0){txtModificarTecnicoTelefono.setError("Campo requerido");auxModificar+=1;}
                if(txtModificarTecnicoDireccion.getText().toString().length()==0){txtModificarTecnicoDireccion.setError("Campo requerido");auxModificar+=1;}

                if(auxModificar == 0){
                    String rut = spinnerModificarTecnicoRut.getSelectedItem().toString();
                    String nombre = txtModificarTecnicoNombre.getText().toString();
                    int edad = Integer.parseInt(txtModificarTecnicoEdad.getText().toString());
                    int telefono = Integer.parseInt(txtModificarTecnicoTelefono.getText().toString());
                    String direccion = txtModificarTecnicoDireccion.getText().toString();


                    if(controller.modificarTecnico(getActivity().getApplicationContext(),rut,nombre,edad,telefono,direccion)){
                        Toast.makeText(getActivity().getApplicationContext(), "Registro Actualizado", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
                break;
        }
    }

    public void cargarDatosRutTecnico(){
        listaRutTecnicos = new ArrayList<>();
        listaRutTecnicos.add("Seleccion");
        TecnicoController controller = new TecnicoController();
        List<Tecnico> listaTecnico = controller.selectTecnicos(getActivity().getApplicationContext());
        for(int i = 0; i<listaTecnico.size();i++){
            listaRutTecnicos.add(listaTecnico.get(i).getRut());
        }
        spinnerModificarTecnicoRut.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, listaRutTecnicos));
    }

    public void limpiar(){
        spinnerModificarTecnicoRut.setSelection(0);
        txtModificarTecnicoNombre.setText("");
        txtModificarTecnicoEdad.setText("");
        txtModificarTecnicoTelefono.setText("");
        txtModificarTecnicoDireccion.setText("");
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
