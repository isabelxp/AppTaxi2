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
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joseris.apptaxi.R;
import com.example.joseris.apptaxi.RegistroUsuario;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetBuilder;
import com.github.rubensousa.bottomsheetbuilder.BottomSheetMenuDialog;
import com.github.rubensousa.bottomsheetbuilder.adapter.BottomSheetItemClickListener;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static com.example.joseris.apptaxi.R.id.fab;


public class RegistroUsuarioDos extends Fragment {
    public ImageView imagencedu;
    TextView TextFoto;
    private static final int SELECT_FILE = 1;
    private BottomSheetMenuDialog mBottomSheetDialog;
    private boolean mShowingHeaderDialog;
    public static Context contextOfApplication;
    private static int TAKE_PICTURE = 1;
    private static int SELECT_PICTURE = 2;
    String rutaImagenCapturada = null;
    private String name = "";
    private Uri output;
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

        if(((RegistroUsuario)getActivity()).getImagencedulabig()!=null)
        {
            imagencedu.setImageBitmap(((RegistroUsuario)getActivity()).getImagencedulabig());
        }


        Typeface TF = Typeface.createFromAsset(getContext().getAssets(),font_path);
        TextFoto.setTypeface(TF);
        imagencedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onShowOpcionesdepago();
                //((RegistroUsuario)getActivity()).RegistrodosOpcionCamaraFoto();
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


    public void onShowOpcionesdepago() {
        if (mBottomSheetDialog != null) {
            mBottomSheetDialog.dismiss();
        }
        Log.e("Item click ", ":" );

        mShowingHeaderDialog = true;
        mBottomSheetDialog = new BottomSheetBuilder(getContext(), R.style.AppTheme_BottomSheetDialog_Custom)
                .setMode(BottomSheetBuilder.MODE_LIST)
                .setMenu(R.menu.menu_camara_o_galeria)
                .expandOnStart(true)
                .setItemClickListener(new BottomSheetItemClickListener() {
                    @Override
                    public void onBottomSheetItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.camara) {
                            Fotografia();
                            Log.e("Item click1", ":");
                        }else
                        if (id == R.id.galeria) {
                            abrirGaleria();
                            Log.e("Item click2", ":");
                        }
                        mShowingHeaderDialog = false;
                    }
                })
                .createDialog();
        mBottomSheetDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                mShowingHeaderDialog = false;
            }
        });
        mBottomSheetDialog.show();
    }


    public void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        Uri output = Uri.fromFile(new File(name));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
        int code = SELECT_PICTURE;
        startActivityForResult(intent, code);
    }
    public void Fotografia() {
        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String rutaCarpetaTemporal = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tmp_taxi/";

        File carpetaFisica = new File(rutaCarpetaTemporal);

        carpetaFisica.mkdirs();

        rutaImagenCapturada = rutaCarpetaTemporal + "Taxi.jpg";

        Uri output = Uri.fromFile(new File(rutaImagenCapturada));

        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, output);

        takePhotoIntent.putExtra("android.intent.extras.CAMERA_FACING", 1);

        try {
            startActivityForResult(takePhotoIntent, 1);
        } catch (ActivityNotFoundException anfe) {


        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SELECT_PICTURE){
            Uri selectedImage = data.getData();
            InputStream is;
            try {
                is =  getActivity().getApplicationContext().getContentResolver().openInputStream(selectedImage);
                BufferedInputStream bis = new BufferedInputStream(is);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                imagencedu.setImageBitmap(bitmap);
                ((RegistroUsuario)getActivity()).setImagencedulabig(bitmap);
                ((RegistroUsuario)getActivity()).RegistrodosOpcionCamaraFoto();
            } catch (FileNotFoundException e) {}
        }else
        if (requestCode == TAKE_PICTURE){

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
            ((RegistroUsuario)getActivity()).setImagencedulabig(myBitmap);
            ((RegistroUsuario)getActivity()).RegistrodosOpcionCamaraFoto();
        }

    }







}
