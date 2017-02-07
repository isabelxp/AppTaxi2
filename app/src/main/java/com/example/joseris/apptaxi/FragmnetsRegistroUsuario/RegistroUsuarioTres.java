package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

import static com.example.joseris.apptaxi.R.id.fab;


public class RegistroUsuarioTres extends Fragment {
    private static final String TWITTER_KEY = "Mdz9xqqz77fcDahuZzF7mIB4m";
    private static final String TWITTER_SECRET = "1DXHn1iRkhqHCQXXoAD4EqkI5hJKaanTk2cPUGTA8vHv2MnSa2";
    TextView TextFoto;
    ServRegistroUsuario registro=new ServRegistroUsuario();




    public RegistroUsuarioTres() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Digits.Builder digitsBuilder = new Digits.Builder().withTheme(R.style.CustomDigitsTheme);
        Fabric.with(getContext(), new TwitterCore(authConfig), digitsBuilder.build());
        View v= inflater.inflate(R.layout.fragment_registro_usuario_tres, container, false);




        FloatingActionButton botonchck=(FloatingActionButton) v.findViewById(fab);

        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registro.Registrar_usurario("isabel.indriago23@gmail.com","Joseris","0412",25274878,"1","pasajero",1, "sdf" ,"2017-02-06", 4545, 45454);
            }
        });



        DigitsAuthButton digitsButton = (DigitsAuthButton) v.findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getContext(), "Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });

        TextFoto = (TextView) v.findViewById(R.id.textView8);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        return v;
    }

}
