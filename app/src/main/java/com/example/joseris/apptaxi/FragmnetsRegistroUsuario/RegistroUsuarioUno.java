package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.joseris.apptaxi.DatosUsuario.Cne;
import com.example.joseris.apptaxi.Interfaces.DatosUsuarioInter;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.joseris.apptaxi.R.id.fab;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroUsuarioUno extends Fragment {
    TextView nombre;
    EditText cedula;
    Button ir;
    ImageView x;
    private ProgressDialog loading;
    Spinner opcionesNacionalidad;
    public RegistroUsuarioUno() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_registro_usuario_uno, container, false);
        FloatingActionButton botonchck=(FloatingActionButton) v.findViewById(fab);
        nombre=(TextView) v.findViewById(R.id.textView3);
        cedula=(EditText) v.findViewById(R.id.editCedula);
        x=(ImageView) v.findViewById(R.id.imagviewX);
        ir=(Button) v.findViewById(R.id.buttonIr);


        cedula.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                     if(cedula.getText().toString().isEmpty()==false)
                     {
                         x.setVisibility(View.VISIBLE);
                     }else
                         x.setVisibility(View.INVISIBLE);
                }
            });


        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre.setText("");
                cedula.setText("");
            }
        });




        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cedu=Integer.valueOf(cedula.getText().toString());
                usuario(cedu);
            }
        });


        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).RegistroDos();
            }
        });
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        opcionesNacionalidad=(Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this.getContext(), R.array.VE, android.R.layout.simple_spinner_item);
        opcionesNacionalidad.setAdapter(adapter);



        return v;
    }
    public void usuario(int numerocedula)
    {

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.willicab.com.ve/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        final DatosUsuarioInter service = retrofit.create(DatosUsuarioInter.class);
        loading = ProgressDialog.show(getContext(), "Cargando", "Por favor espere", false, false);
        service.UsuarioCne("V",numerocedula).enqueue(new Callback<Cne>() {
            @Override
            public void onResponse(Call<Cne> call, Response<Cne> response) {
                if (response.isSuccessful()) {
                    nombre.setText(response.body().getNombre());
                    Log.e("Nombre", ":" + response.body().getNombre());
                    }else
                    Log.e("Noooooooo", ":" + response.body().getNombre());
                loading.dismiss();
                {

                }
                }

            @Override
            public void onFailure(Call<Cne> call, Throwable t) {
                Log.e("Error:", ":" + t);
            }

        });
    }



}
