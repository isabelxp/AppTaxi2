package com.example.joseris.apptaxi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;
import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.FotografiaUsuario;
import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.RegistroUsuarioDos;
import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.UltimoPaso;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.ResponseRegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static android.R.attr.bitmap;
import static android.R.attr.name;
import static java.security.AccessController.getContext;

public class UltimoPasoActivity extends AppCompatActivity {
    TextView confirmarfoto;
    TextView confirmarCedula;

    FloatingActionButton fab;
    private ProgressDialog loading;
    boolean foto=false;
    boolean cedula=false;
    ImageView imagenfoto;
    ImageView imagencedula;
    Toolbar toolbar;
    public FotografiaUsuario fotousuario =new FotografiaUsuario();
    public RegistroUsuarioDos frgment2 = new RegistroUsuarioDos();

    String nombre;
    String cedula2;
    String pasword;
    String email;
    String phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimo_paso);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        confirmarfoto=(TextView)findViewById(R.id.textViewFotoPerfil);
        confirmarCedula=(TextView)findViewById(R.id.textViewCedulaIdentidad);
                imagenfoto= (ImageView) findViewById(R.id.imageFoto);
                imagencedula=(ImageView) findViewById(R.id.imageCedula);

         nombre = getIntent().getStringExtra("nombre");
         cedula2 = getIntent().getStringExtra("ci");
         pasword = getIntent().getStringExtra("password");
         email = getIntent().getStringExtra("email");
         phone = getIntent().getStringExtra("phone");

        Log.e("nombre", "------" +nombre);
        Log.e("cedula", "------" +cedula2);
        Log.e("pasword", "------" +pasword);
        Log.e("email", "------" +email);
        Log.e("phone", "------" +phone);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Ultimo paso...");
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more_vert_black_24dp));
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        if (toolbar != null)
            setSupportActionBar(toolbar);

        confirmarfoto=(TextView)findViewById(R.id.textViewFotoPerfil);
        confirmarCedula=(TextView)findViewById(R.id.textViewCedulaIdentidad);

        RegistroUsuario usuario=new RegistroUsuario();
        Log.e("Datos", "------" +usuario.registro.toString());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foto==true&cedula==true)
                {
                    //frgment2.registroUsuario();


                    //ServRegistroUsuario registro=new ServRegistroUsuario();
                    //Log.e("Bolean", "------"+registro.isRegistroExitoso());
                    RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario("V"+cedula2,pasword,nombre,phone,1,email,"pasajero",null,null);
                    //registro.registrarUsuario(requestCrearUsuario);


                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://apptaxi.esy.es/API/public/api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    com.example.joseris.apptaxi.Interfaces.RegistroUsuario service=retrofit.create(com.example.joseris.apptaxi.Interfaces.RegistroUsuario.class);
                    Call<ResponseRegistroUsuario> call=service.registroUsuario(requestCrearUsuario);
                    loading = ProgressDialog.show(UltimoPasoActivity.this, "Cargando", "Por favor espere", false, false);
                    call.enqueue(new Callback<ResponseRegistroUsuario>() {
                        @Override
                        public void onResponse(Call<ResponseRegistroUsuario> call, Response<ResponseRegistroUsuario> response) {
                            if (response.isSuccessful()) {
                                Log.e("Registro", ":" + call.request().url().toString());
                                Log.e("isSuccessful", "------"+response.isSuccessful()+response.message());
                                Toast.makeText(UltimoPasoActivity.this, "Bienvenido "+name
                                        + "", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(UltimoPasoActivity.this, Actividad_principalTaxi.class);
                                startActivity(i);
                                finish();
                                loading.dismiss();
                            } else
                            {
                                Log.e("No_Registro", ":" + call.request().url().toString());
                                Toast.makeText(UltimoPasoActivity.this, "No se pudo concretar el registro correo o cedula registrada"
                                        + "", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(UltimoPasoActivity.this, Login.class);
                                startActivity(i);
                                finish();
                                loading.dismiss();
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseRegistroUsuario> call, Throwable t) {

                            Log.e("Error base datos", "------"+ t);
                            loading.dismiss();
                        }
                    });











                }

            }
        });
        confirmarCedula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foto==true)
                {
                    fab.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .remove(fotousuario).commit();
                    cedula=true;
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container2, frgment2).commit();
                }
            }
        });

        confirmarfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(foto==false)
                {
                    foto=true;
                    fab.setVisibility(View.INVISIBLE);
                    //imagenfoto.setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container2, fotousuario).commit();
                }
            }
        });

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    public void onBackPressed() { }
    public void removerFragmenfoto()
    {
        fab.setVisibility(View.VISIBLE);
        imagenfoto.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .remove(fotousuario).commit();
    }
    public void removerFragmenCedula()
    {
        fab.setVisibility(View.VISIBLE);
        imagencedula.setVisibility(View.VISIBLE);
        getSupportFragmentManager().beginTransaction()
                .remove(frgment2).commit();
    }


}
