package com.appluz.splashscreen.model;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jose Antonio on 10/10/2017.
 */

public class LoginModel {
    private static final String URL = "http://plancolima.col.gob.mx/apis/get_login";
    RequestQueue requestQueue;
    StringRequest request;
    Boolean validar = false;

    public LoginModel(RequestQueue requestQueue, StringRequest request) {
        this.requestQueue = requestQueue;
        this.request = request;
    }


   public boolean Login(final String name, final String pass) {

        if (name != "" && pass != "") {

            request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if (jsonObject.names().get(0).equals("user")) {
                            validar = true;
                        } else {

                            validar = false;
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<String, String>();
                    hashMap.put("email", name);
                    hashMap.put("password", pass);
                    return hashMap;
                }
            };

            requestQueue.add(request);

        }

        return validar;
    }


}
