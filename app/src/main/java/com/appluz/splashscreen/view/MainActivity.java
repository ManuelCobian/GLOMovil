package com.appluz.splashscreen.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.appluz.splashscreen.R;
import com.appluz.splashscreen.StartActivity;
import com.appluz.splashscreen.controller.StartApp;
import com.appluz.splashscreen.model.LoginModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText password,email;
    CheckBox recordar;
    LoginModel loginModel;
    private RequestQueue requestQueue;

    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StartApp startApp = new StartApp(getApplicationContext());
        if (startApp.isFirstTimeLaunch()) {
            startActivity(new Intent(MainActivity.this, StartActivity.class));
        }



        requestQueue= Volley.newRequestQueue(this);
        loginModel=new LoginModel(requestQueue,request);


        email=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String correo=email.getText().toString();
                String pass=password.getText().toString();

                if (!correo.isEmpty() && !pass.isEmpty()){



                    if (loginModel.Login(correo,pass)){

                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Usuario no registrado ", Toast.LENGTH_LONG).show();
                    }
                }

                else{

                    Toast.makeText(MainActivity.this, "Ingrese Campos", Toast.LENGTH_LONG).show();
                }


            }
        });


    }





}
