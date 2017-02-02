package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joseris.apptaxi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroUsuarioTres extends Fragment {

    TextView TextFoto;
    public RegistroUsuarioTres() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_registro_usuario_tres, container, false);
        TextFoto = (TextView) v.findViewById(R.id.textView8);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        return v;
    }

}
