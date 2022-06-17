package com.example.emotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registracija extends AppCompatActivity {

    EditText imePrez, txtUsername, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registracija);
        imePrez = findViewById(R.id.txtImePrezime);
        txtUsername = findViewById(R.id.txtUsernameR);
        txtPass = findViewById(R.id.txtPass1);
    }

    public void registracija(View view) {
        User user = new User(imePrez.getText().toString(),txtUsername.getText().toString(),txtPass.getText().toString());
        /*
        ubacivanje u bazu
         */
        finish();
    }
}