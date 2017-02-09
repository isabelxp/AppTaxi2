package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

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
                //ServRegistroUsuario registro=new ServRegistroUsuario();
                //RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario("V21455","12345","Isa","4142122",1,"isabel2017@gmail.com","pasajero",null,null);
                //registro.registrarUsuario(requestCrearUsuario);
            }
        });

        TextFoto = (TextView) v.findViewById(R.id.textView8);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        return v;
    }

}
