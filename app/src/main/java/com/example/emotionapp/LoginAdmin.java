package com.example.emotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAdmin extends AppCompatActivity {

    EditText txtUsername, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        txtUsername = findViewById(R.id.txtUsernameA);
        txtPass = findViewById(R.id.txtPasswordA);
    }

    public void loginAdmin(View view) {
        String username = txtUsername.getText().toString();
        String pass = txtPass.getText().toString();

        if(username.equals("admin") && pass.equals("admin")){
            Intent i = new Intent(this, PocetnaAdmin.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this,"Pogresno korisnicko ime ili sifra",Toast.LENGTH_LONG).show();
        }
    }
}