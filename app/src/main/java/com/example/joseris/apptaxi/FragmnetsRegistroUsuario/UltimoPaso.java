package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;

import static com.google.android.gms.R.id.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltimoPaso extends Fragment {
    TextView confirmarfoto;
    TextView confirmarCedula;

    public UltimoPaso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_ultimo_paso, container, false);
        confirmarfoto=(TextView)v.findViewById(R.id.textViewFotoPerfil);
        confirmarCedula=(TextView)v.findViewById(R.id.textViewCedulaIdentidad);

        confirmarCedula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).RegistroDos();
            }
        });

        confirmarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).fotousuario();
            }
        });


        return v;
    }

}
