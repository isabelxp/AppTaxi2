package com.example.joseris.apptaxi.FragmentsApp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;
import com.example.joseris.apptaxi.R;


public class FragmentParteBusquedaMapa extends Fragment {
    Button opciones;
    Button opcionesdepago;

    public FragmentParteBusquedaMapa() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_fragment_parte_busqueda_mapa, container, false);
        opciones=(Button) v.findViewById(R.id.buttonopciones);
        opcionesdepago=(Button) v.findViewById(R.id.buttonefectivo);

        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((Actividad_principalTaxi)getActivity()).onShowOpciones();
            }
        });
        opcionesdepago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Actividad_principalTaxi)getActivity()).onShowOpcionesdepago();
            }
        });

        return v;
    }



}
