package com.example.joseris.apptaxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.joseris.apptaxi.FragmnetsRegistroUsuario.Actividad_principalTaxi;

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Actividad_principalTaxi.class);
                startActivity(i);
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }
        });
    }

}
