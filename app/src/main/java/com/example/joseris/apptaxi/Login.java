package com.example.joseris.apptaxi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;
import com.example.joseris.apptaxi.Interfaces.InterLogin;
import com.example.joseris.apptaxi.Modelos.Request.RequesLogin;
import com.example.joseris.apptaxi.Modelos.Request.RequesLoginDatos;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Responses.Example;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServicioLogin;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Login extends AppCompatActivity {
    TextView TextRegistro;
    EditText email;
    EditText password;
    TextView RecuperarContrasena;
    private ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextRegistro = (TextView) findViewById(R.id.textregistro);
        RecuperarContrasena = (TextView) findViewById(R.id.textrecupearacontrasena);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        email=(EditText) findViewById(R.id.editemaillogin);
        password=(EditText) findViewById(R.id.editpasswordlogin);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        TextRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RegistroUsuario.class);
                startActivity(i);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });

        RecuperarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, RecuperarContrasenaUsuario.class);
                startActivity(i);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });

        CoordinatorLayout vista=(CoordinatorLayout)findViewById(R.id.coordinatorlayout);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().isEmpty()==false & password.getText().toString().isEmpty()==false)
                {

                    RequesLoginDatos requeslogindatos= new RequesLoginDatos(email.getText().toString(),"kdmmdjdkdndjn",password.getText().toString());
                    UsuarioLogin(requeslogindatos);

                }
             //   RequesLoginDatos requeslogindatos= new RequesLoginDatos("isabel2017369@gmail.com","kdmmdjdkdndjn","12345");
               // onShowDialogHeadersClick();
               // Intent i = new Intent(Login.this, Actividad_principalTaxi.class);
               // startActivity(i);
               // overridePendingTransition(R.anim.left_in,R.anim.left_out);
              //  ServRegistroUsuario registro=new ServRegistroUsuario();
                //RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario("V211111","12345","Isa","4142122",1,"isabel2017369@gmail.com","pasajero",null,null);
               // registro.registrarUsuario(requestCrearUsuario);


            }
        });


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    public void onBackPressed() { }
    public void UsuarioLogin(RequesLoginDatos requestlogindatos)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apptaxi.esy.es/API/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        InterLogin service=retrofit.create(InterLogin.class);
        Call<Example> call=service.ingresarLogin(requestlogindatos);
        loading = ProgressDialog.show(this, "Cargando", "Por favor espere", false, false);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                if (response.isSuccessful()) {
                    Gson gson=new Gson();
                    gson.toJson(response.body());
                    Log.e("Login Exito", ":" +  gson.toJson(response.body()));
                    Intent i = new Intent(Login.this, Actividad_principalTaxi.class);
                    startActivity(i);
                    try {
                        JSONObject account = new JSONObject(new Gson().toJson(response.body().getAccount()));
                        if (response.isSuccessful()) {
                            Log.e("Login", account.getString("name"));
                        }else
                        {
                            Log.e("No Login", "------");
                            //Log.e("No Login", "------"+ call.request().url().toString());
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    overridePendingTransition(R.anim.left_in,R.anim.left_out);
                    loading.dismiss();

                }else
                {
                    loading.dismiss();

                    Toast.makeText(Login.this, "Usuario no registrado o contraseña invàlida"
                            + "", Toast.LENGTH_LONG).show();
                    Log.e("No Login", "------");
                    Log.e("No Login", "------"+ call.request().url().toString());
                }
            }
            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("Error base datos", "------"+ t);
                loading.dismiss();
            }
        });


   }

}
