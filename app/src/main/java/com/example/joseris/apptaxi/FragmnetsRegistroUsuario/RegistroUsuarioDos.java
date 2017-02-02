package com.example.joseris.apptaxi.FragmnetsRegistroUsuario;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.example.joseris.apptaxi.R.id.fab;


public class RegistroUsuarioDos extends Fragment {
    ImageView imagencedu;
    TextView TextFoto;
    String rutaImagenCapturada = null;
    public RegistroUsuarioDos() {
        // Required empty public constructor
    }


    public static RegistroUsuarioDos newInstance(String param1, String param2) {
        RegistroUsuarioDos fragment = new RegistroUsuarioDos();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_registro_usuario_dos, container, false);
        TextFoto = (TextView) v.findViewById(R.id.textView4);
        imagencedu = (ImageView) v.findViewById(R.id.imagecedula);
        String font_path = "font/Roboto-Light.ttf";
        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        imagencedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFoto();
            }
        });

        FloatingActionButton botonchck=(FloatingActionButton) v.findViewById(fab);

        botonchck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RegistroUsuario)getActivity()).RegistroTres();
            }
        });

        return v;
    }
    public void obtenerFoto() {

        CharSequence options[] = new CharSequence[]{"Camara", "Galeria"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Image Source");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    String rutaCarpetaTemporal = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp_taxi/";

                    File carpetaFisica = new File(rutaCarpetaTemporal);

                    carpetaFisica.mkdirs();

                    rutaImagenCapturada = rutaCarpetaTemporal + "Taxi.jpg";

                    Uri output = Uri.fromFile(new File(rutaImagenCapturada));

                    takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, output);

                    takePhotoIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);

                    try {
                        startActivityForResult(takePhotoIntent, 2);
                    } catch (ActivityNotFoundException anfe) {


                    }
                } else if (which == 1) {
                    Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    galleryIntent.setType("image/*");
                    try {
                        startActivityForResult(galleryIntent, 1);
                    } catch (ActivityNotFoundException anfe) {

                    }
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intentRecibido) {
        super.onActivityResult(requestCode, resultCode, intentRecibido);


        if ((requestCode == 2 || requestCode == 1) && resultCode == Activity.RESULT_OK) {

            if (requestCode == 2) {
                String imgUriCam;
                imgUriCam = rutaImagenCapturada;
                Log.d(" mal", "--->RRUEBA 1 " + imgUriCam);

                File imgFile = new File(imgUriCam);
                if (!imgFile.exists()) {
                    Toast.makeText(getContext(), "No se pudo montar la imagen", Toast.LENGTH_SHORT).show();
                    return;
                }
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                Drawable d = new BitmapDrawable(getResources(), myBitmap);
                imagencedu.setImageBitmap(myBitmap);

            } else {

                Uri imgUriGal = intentRecibido.getData();
                if (imgUriGal == null) {
                    Toast.makeText(getContext(), "ninguna imagen seleccionada", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    InputStream is = getContext().getContentResolver().openInputStream(imgUriGal);
                    Bitmap bmp = BitmapFactory.decodeStream(is);
                      imagencedu.setImageBitmap(bmp);

                } catch (FileNotFoundException e) {
                    Toast.makeText(getContext(), "No se pudo montar la imagen", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }


        }


    }

}
