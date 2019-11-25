package com.nayan.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText email,password;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.mail);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext= String.valueOf(email.getText());
                String passwordtext=String.valueOf(password.getText());
                boolean error=true;

                if(TextUtils.isEmpty(emailtext)){
                    error=false;
                    email.setError("Field Can Not Be Empty!");

                }else if(!emailtext.contains("@")){
                    error=false;
                    email.setError("Please Provide A Valid Email Address!");

                }else if (TextUtils.isEmpty(passwordtext)){
                    error=false;
                    password.setError("Field Can Not Be Empty!");

                }else if (passwordtext.length()<8){
                    Log.e("password",passwordtext);
                    error=false;
                    password.setError("Password Length Too Short!");
                }

                if(error){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else {
                    error=true;
                }
            }
        });
    }
}
