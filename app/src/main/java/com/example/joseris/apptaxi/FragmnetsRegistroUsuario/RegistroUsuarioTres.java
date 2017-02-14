package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;

import static com.example.joseris.apptaxi.R.id.fab;


public class RegistroUsuarioTres extends Fragment {

    TextView TextFoto;
    ServRegistroUsuario registro=new ServRegistroUsuario();

    public RegistroUsuarioTres() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_registro_usuario_tres, container, false);

        FloatingActionButton botonchck=(FloatingActionButton) v.findViewById(fab);

        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((RegistroUsuario)getActivity()).RegistroCuatro();
            }
        });

        TextFoto = (TextView) v.findViewById(R.id.textView8);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        return v;
    }

}
