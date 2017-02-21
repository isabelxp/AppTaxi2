package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;

public class ConfirmarFoto extends Fragment {


    private BottomSheetMenuDialog mBottomSheetDialog;
    private boolean mShowingHeaderDialog;
    Button buttonNuevaFoto;
    Button buttonCancelar;
    public ImageView imagencedulaconfirmar;
    public ConfirmarFoto() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_confirmar_foto, container, false);
        buttonNuevaFoto=(Button)v.findViewById(R.id.buttonNuevaFoto);
        buttonCancelar=(Button) v.findViewById(R.id.buttonAceptarFoto);
        imagencedulaconfirmar=(ImageView)v.findViewById(R.id.imagencedulaconfirmar);
        imagencedulaconfirmar.setImageBitmap(((RegistroUsuario)getActivity()).getImagencedulabig());


        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).RegistroConfirmarFoto();
            }
        });

        buttonNuevaFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).RegistroDos();
            }
        });

        return v;
    }


  

}
