package com.example.joseris.apptaxi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joseris.apptaxi.InterComuni.InterRecuperarContra;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.Modelos.Request.RequestRecuperarPass;
import com.example.joseris.apptaxi.Servicios.ServRecuperarPass;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;

import static android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED;
import static android.support.design.widget.BottomSheetBehavior.STATE_HIDDEN;

public class RecuperarContrasenaUsuario extends AppCompatActivity implements InterRecuperarContra {
    EditText RecuperarContr;
    ImageView imageX;
    private BottomSheetDialog mBottomSheetDialog;
    private BottomSheetDialog bottonSheetD;
    private boolean mShowingHeaderDialog;
    TextView textError;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contrasena_usuario);
        RecuperarContr=(EditText) findViewById(R.id.editRecuperarCont);
        fab=(FloatingActionButton) findViewById(R.id.fab);
        textError=(TextView) findViewById(R.id.textError);
        imageX=(ImageView) findViewById(R.id.imageX);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(RecuperarContr.getText().length()>8)
              {
                  RequestRecuperarPass recuperar=new RequestRecuperarPass(RecuperarContr.getText().toString(),"");
                  ServRecuperarPass recuperarPass=new ServRecuperarPass(recuperar, RecuperarContrasenaUsuario.this);
              }
            }
        });
        RecuperarContr.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s,
                                          int start, int count, int after) {


            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(RecuperarContr.getText().toString().isEmpty()==false)
                {
                    imageX.setVisibility(View.VISIBLE);
                    textError.setVisibility(View.INVISIBLE);
                }else
                    imageX.setVisibility(View.INVISIBLE);
            }
        });


        imageX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecuperarContr.setText("");
                textError.setVisibility(View.INVISIBLE);
            }
        });



    }

    public void DialogSheet()
    {
        RecuperarContr.setText("");
        bottonSheetD = new BottomSheetDialog(RecuperarContrasenaUsuario.this);
        View parentView = getLayoutInflater().inflate(R.layout.listo_recuperamos_contrasena, null);
        bottonSheetD.setContentView(parentView);
        BottomSheetBehavior bottomSheet = BottomSheetBehavior.from((View) parentView.getParent());
        bottomSheet.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100, getResources().getDisplayMetrics()));
        bottomSheet.setState(bottomSheet.STATE_EXPANDED);
        bottonSheetD.show();
    }

    @Override
    public void showMessage() {
        DialogSheet();
    }

    @Override
    public void showMessageError() {
        textError.setVisibility(View.VISIBLE);
    }

}
