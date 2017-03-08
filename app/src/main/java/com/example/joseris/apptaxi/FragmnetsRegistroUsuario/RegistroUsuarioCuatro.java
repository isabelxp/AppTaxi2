package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.AuthConfig;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.example.joseris.apptaxi.Login;
import com.example.joseris.apptaxi.Modelos.Request.RequestCrearUsuario;
import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.example.joseris.apptaxi.Servicios.ServRegistroUsuario;
import com.example.joseris.apptaxi.UltimoPasoActivity;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistroUsuarioCuatro extends Fragment {

    private static final String TWITTER_KEY = "Mdz9xqqz77fcDahuZzF7mIB4m";
    private static final String TWITTER_SECRET = "1DXHn1iRkhqHCQXXoAD4EqkI5hJKaanTk2cPUGTA8vHv2MnSa2";
    private AuthCallback authCallback;
    DigitsAuthButton digitsButton;

    public RegistroUsuarioCuatro() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Digits.Builder digitsBuilder = new Digits.Builder().withTheme(R.style.CustomDigitsTheme);
        Fabric.with(getContext(), new TwitterCore(authConfig), digitsBuilder.build());
        Fabric.with(getContext(), new TwitterCore(authConfig), new Digits.Builder().build());
        View v=inflater.inflate(R.layout.fragment_registro_usuario_cuatro, container, false);
        digitsButton = (DigitsAuthButton) v.findViewById(R.id.auth_button);

        new Digits.Builder().withTheme(R.style.CustomDigitsTheme).build();
        digitsButton.setAuthTheme(R.style.CustomDigitsTheme);
        Digits.clearActiveSession();
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
               // Intent i = new Intent(getContext(), Login.class);
               // startActivity(i);
              //  ((RegistroUsuario)getActivity()).UltimoPaso();
                 // ServRegistroUsuario registro=new ServRegistroUsuario();
                 // RequestCrearUsuario requestCrearUsuario = new RequestCrearUsuario("V"+((RegistroUsuario)getActivity()).registro.getCi(),((RegistroUsuario)getActivity()).registro.getPassword(),((RegistroUsuario)getActivity()).registro.getName(),((RegistroUsuario)getActivity()).registro.getPhone(),1,((RegistroUsuario)getActivity()).registro.getEmail(),"pasajero",null,null);
                  Log.e("Datos de Registro", ":" +((RegistroUsuario)getActivity()).registro.toString());
                  //registro.registrarUsuario(requestCrearUsuario);
                //Intent i = new Intent(getContext(), Login.class);
               // startActivity(i);
                  Toast.makeText(getContext(), "Usuario Registrado con Exito"
                        + phoneNumber, Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });
        digitsButton.performClick();
      authCallback = new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                  //    Intent i = new Intent(getContext(), UltimoPasoActivity.class);
                  //    startActivity(i);

               // ((RegistroUsuario)getActivity()).UltimoPaso();
                 Intent i = new Intent(getContext(), UltimoPasoActivity.class);
                 i.putExtra("nombre",((RegistroUsuario)getActivity()).registro.getName());
                 i.putExtra("ci",((RegistroUsuario)getActivity()).registro.getCi());
                 i.putExtra("password",((RegistroUsuario)getActivity()).registro.getPassword());
                 i.putExtra("email",((RegistroUsuario)getActivity()).registro.getEmail());
                 i.putExtra("phone",((RegistroUsuario)getActivity()).registro.getPhone());
                 startActivity(i);

                 Log.e("Datos de Registro", ":" +((RegistroUsuario)getActivity()).registro.toString());

                      }
            @Override
             public void failure(DigitsException exception) {
                // Do something on failure
                // }
            };

                //digitsButton.performClick();
        };
        AuthConfig.Builder authConfigBuilder = new AuthConfig.Builder()
                .withAuthCallBack(authCallback)
                .withPhoneNumber("+58"+((RegistroUsuario)getActivity()).getNumerodecel());

        Digits.authenticate(authConfigBuilder.build());
        return v;

    }

       public AuthCallback getAuthCallback(){
              return authCallback;
        }


}
