package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.joseris.apptaxi.Login;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuarioNoRegistradoCNE extends Fragment {

    TextView nombre;
    public UsuarioNoRegistradoCNE() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_usuario_no_registrado_cne, container, false);
        FloatingActionButton boton=(FloatingActionButton) v.findViewById(R.id.fab);
        nombre=(TextView) v.findViewById(R.id.editNombre);
        TextView apellido=(TextView) v.findViewById(R.id.editApellido);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nombre.length()>2)
                {
                    ((RegistroUsuario)getActivity()).registro.setName(nombre.getText().toString());
                    ((RegistroUsuario)getActivity()).RegistroTres();
                }

            }
        });

        return v;
    }

}
