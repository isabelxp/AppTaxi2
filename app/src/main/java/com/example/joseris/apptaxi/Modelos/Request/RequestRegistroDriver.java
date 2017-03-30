package com.example.joseris.apptaxi.Modelos.Request;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Andy on 10/03/2017.
 */

public class RequestRegistroDriver extends HashMap<String, RequestBody> {

    public RequestRegistroDriver(){

    }

    private RequestBody toRequestBody(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }
}
