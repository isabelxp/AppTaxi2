package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;

import static com.example.joseris.apptaxi.R.id.fab;


public class RegistroUsuarioTres extends Fragment {

    TextView TextFoto;
    ServRegistroUsuario registro=new ServRegistroUsuario();
    Spinner numero;
    EditText numerotelefono;
    EditText correo;
    EditText password;
    ImageView x;
    public int numerocelular;

    public RegistroUsuarioTres() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_registro_usuario_tres, container, false);
        x=(ImageView) v.findViewById(R.id.imagviewX);
        numerotelefono=(EditText) v.findViewById(R.id.editnumerotelefo);
        correo=(EditText) v.findViewById(R.id.editCorreo);
        password=(EditText) v.findViewById(R.id.editContrasena);
        numerotelefono.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s,int start, int count, int after) {


            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(numerotelefono.getText().toString().isEmpty()==false)
                {
                    x.setVisibility(View.VISIBLE);
                 }else
                    x.setVisibility(View.INVISIBLE);
                }
                    });
                x.setOnClickListener(new View.OnClickListener() {
                             @Override
                            public void onClick(View view) {
                                               numerotelefono.setText("");
                                                  }
                                    });

        FloatingActionButton botonchck=(FloatingActionButton) v.findViewById(fab);

        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(numerotelefono.getText().toString().isEmpty() == false & correo.getText().toString().isEmpty() == false& password.getText().toString().isEmpty() == false)
               {
                   ((RegistroUsuario)getActivity()).RegistroCuatro();
                   ((RegistroUsuario)getActivity()).setNumerodecel(numerotelefono.getText().toString());
                 //  numerocelular=Integer.parseInt(numerotelefono.getText().toString());
                  // Log.e("numero", "------"+numerocelular);
               }

            }
        });

        TextFoto = (TextView) v.findViewById(R.id.textView8);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        numero=(Spinner) v.findViewById(R.id.spinner2);
               ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this.getContext(), R.array.numero, android.R.layout.simple_spinner_item);
               numero.setAdapter(adapter);
        return v;
    }

}
