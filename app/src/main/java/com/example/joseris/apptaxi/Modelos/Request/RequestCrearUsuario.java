package com.example.joseris.apptaxi.Modelos.Request;

/**
 * Created by hector on 06/02/17.
 */
import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RequestCrearUsuario extends HashMap<String, RequestBody> {

    public RequestCrearUsuario(String ci, String password, String name, String phone, Integer inCne, String email, String role, Bitmap photo, Bitmap ciPhoto) {

        ByteArrayOutputStream output = new ByteArrayOutputStream(photo.getByteCount());
        photo.compress(Bitmap.CompressFormat.PNG, 100, output);
        byte[] profileBytes = output.toByteArray();

        this.put("email", toRequestBody(email));
        this.put("password", toRequestBody(password));
        this.put("name", toRequestBody(name));
        this.put("phone", toRequestBody(phone));
        this.put("ci", toRequestBody(ci));

        if(photo != null) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), profileBytes);
            this.put("photo\"; filename=\"" + ci + ".jpeg\"", fileBody);
        }

        if(ciPhoto != null) {
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), profileBytes);
            this.put("ciPhoto\"; filename=\"" + ci + ".jpeg\"", fileBody);
        }

        this.put("in_cne", toRequestBody(Integer.toString(inCne)));
        this.put("role", toRequestBody(role));
    }

    private RequestBody toRequestBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

}