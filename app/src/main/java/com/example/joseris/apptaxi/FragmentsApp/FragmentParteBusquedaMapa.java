package com.example.joseris.apptaxi.FragmentsApp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joseris.apptaxi.R;


public class FragmentParteBusquedaMapa extends Fragment {

    public FragmentParteBusquedaMapa() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fragment_parte_busqueda_mapa, container, false);
    }



}
