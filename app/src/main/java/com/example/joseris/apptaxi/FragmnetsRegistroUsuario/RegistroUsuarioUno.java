package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

import com.example.joseris.apptaxi.ClassInformacionUsuarioRegistro;
import com.example.joseris.apptaxi.DatosUsuario.Cne;
import com.example.joseris.apptaxi.Interfaces.DatosUsuarioInter;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.joseris.apptaxi.R.id.fab;
import static java.sql.Types.NULL;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroUsuarioUno extends Fragment {
    TextView nombre;
    EditText cedula;
    FloatingActionButton botonchck;
    Button ir;
    ImageView x;
    private ProgressDialog loading;
    boolean nombreencontrado=false;
    boolean nombreEscritoManual=false;
    Spinner opcionesNacionalidad;
    ImageView imagenacercade;
    public RegistroUsuarioUno() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_registro_usuario_uno, container, false);

        botonchck=(FloatingActionButton) v.findViewById(fab);
        nombre=(TextView) v.findViewById(R.id.textViewNombreUsuario);
        cedula=(EditText) v.findViewById(R.id.editCedula);
        imagenacercade=(ImageView) v.findViewById(R.id.imageAcercade);
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

        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombreEscritoManual==false & nombreencontrado==false)
                {
                    if(cedula.length()>=6)
                    {
                    int cedu=Integer.valueOf(cedula.getText().toString());
                    usuario(cedu);
                    }
                }
                if(nombreencontrado==true)
                {
                    if(cedula.length()>=6)
                    {
                    ((RegistroUsuario)getActivity()).RegistroTres();
                    }
                }
                if(nombreEscritoManual==true)
                {
                    if(cedula.length()>=6)
                    {
                        ((RegistroUsuario)getActivity()).RegistroUsuarioNoRegistrado();
                        ((RegistroUsuario) getActivity()).registro.setCi(cedula.getText().toString());
                    }
                }
            }
        });
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        opcionesNacionalidad=(Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this.getContext(), R.array.VE, android.R.layout.simple_spinner_item);
        opcionesNacionalidad.setAdapter(adapter);



        return v;
    }
    public void usuario(final int numerocedula)
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
                   if(response.body().getModo()!=null) {
                       if (response.body().getModo() == 1) {
                           nombreencontrado = true;
                           botonchck.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.ic_checkflecha));
                           ((RegistroUsuario) getActivity()).registro.setName(response.body().getNombre().toString());
                           ((RegistroUsuario) getActivity()).registro.setCi(Integer.toString(numerocedula));
                           nombre.setText(response.body().getNombre());

                           loading.dismiss();
                       }
                       if (response.body().getModo() == 2) {
                           nombreEscritoManual = true;

                           nombre.setText("Esta Cedula de Identidad no se encuentra inscrita en el CNE. Presione el boton " +
                                   "de siguiente para continuar con el registro.");
                           imagenacercade.setVisibility(View.VISIBLE);
                           Log.e("Nombre_", ":" + response.body().getModo());
                           loading.dismiss();
                       }
                      }
                    }else
                {
                     Log.e("Noooooooo123", ":" + response.body().getNombre());
                }

                loading.dismiss();
                }

            @Override
            public void onFailure(Call<Cne> call, Throwable t) {
                nombreEscritoManual=true;
                loading.dismiss();
                Log.e("Error:", ":" + t);
            }

        });
    }



}
