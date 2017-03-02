package com.example.joseris.apptaxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;
import com.example.joseris.apptaxi.Modelos.Request.RequesLoginDatos;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServicioLogin;

public class Login extends AppCompatActivity {
    TextView TextRegistro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextRegistro = (TextView) findViewById(R.id.textregistro);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        CoordinatorLayout vista=(CoordinatorLayout)findViewById(R.id.coordinatorlayout);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // onShowDialogHeadersClick();
               // Intent i = new Intent(Login.this, Actividad_principalTaxi.class);
               // startActivity(i);
               // overridePendingTransition(R.anim.left_in,R.anim.left_out);
                ServicioLogin login=new ServicioLogin();
                RequesLoginDatos requeslogindatos= new RequesLoginDatos("dadcrazy@gmail.com","12345","kdmmdjdkdndjn");
                login.UsuarioLogin(requeslogindatos);

            }
        });

       // ServRegistroUsuario registro=new ServRegistroUsuario();
       // RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario("V21455","12345","Isa","4142122",1,"isabel2017@gmail.com","pasajero",null,null);
       // registro.registrarUsuario(requestCrearUsuario);
    }



}
