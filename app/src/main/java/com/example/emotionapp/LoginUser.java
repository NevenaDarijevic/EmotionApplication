package com.example.emotionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginUser extends AppCompatActivity {

    EditText txtUsername, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        txtUsername = findViewById(R.id.txtUsernameU);
        txtPass = findViewById(R.id.txtPasswordU);
    }

    public void loginUser(View view) {
        String username = txtUsername.getText().toString();
        String pass = txtPass.getText().toString();

        User user = new User();
        user.setUsername(username);
        user.setPassword(pass);
        // provera u bazi
        /*
        if(konekcijaKorisnik.exists(user)){
                Intent i1 = new Intent(this, ProfileUser.class);
                i1.putExtra("username",user.username);
                startActivity(i1);
            }
            else{
                Toast.makeText(this,"Pogresno korisnicko ime ili sifra",Toast.LENGTH_LONG).show();
            }
         */
        Intent i = new Intent(this,PocetnaUser.class);
        startActivity(i);
    }

    public void registerUser(View view) {
        Intent i = new Intent(this, Registracija.class);
        startActivity(i);

    }
}