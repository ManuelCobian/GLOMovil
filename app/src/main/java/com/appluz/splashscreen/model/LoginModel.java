package com.appluz.splashscreen.model;

import android.widget.Toast;

/**
 * Created by Jose Antonio on 10/10/2017.
 */

public class LoginModel {

    public boolean logeo(String email, String pass){
        boolean logeo= false;
        if(email.equals("cobianl066@gmail.com") && pass.equals("1234") )
        {

            return true;
        }
        else {
            return false;
        }

    }
}
