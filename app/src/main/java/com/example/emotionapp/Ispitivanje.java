package com.example.emotionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ispitivanje extends AppCompatActivity {

    ImageButton kamera;
    CheckBox c1, c2, c3, c4, c5, c6;
    // marketinska slika
    ImageView slika;
    // brojac da bismo znali koja slika je na redu, po defaultu stavljena na prvu
    final int[] br = {1};

    // putanja da slike emocije korisnika
    String currentPhotoPath;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ispitivanje);

        kamera = findViewById(R.id.kamera);
        c1 = (CheckBox)findViewById(R.id.checkbox_e1);
        c2 = (CheckBox)findViewById(R.id.checkbox_e2);
        c3 = (CheckBox)findViewById(R.id.checkbox_e3);
        c4 = (CheckBox)findViewById(R.id.checkbox_e4);
        c5 = (CheckBox)findViewById(R.id.checkbox_e5);
        c6 = (CheckBox)findViewById(R.id.checkbox_e6);
        slika = findViewById(R.id.slika);
        slika.setImageResource(R.drawable.p1);
        Button sledeca = findViewById(R.id.btnSledecaSlika);

        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentKamere();
            }
        });

        sledeca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                br[0]++;
                switch (br[0]){
                    case 2: slika.setImageResource(R.drawable.p2);
                        break;
                    case 3: slika.setImageResource(R.drawable.p3);
                        break;
                    case 4: slika.setImageResource(R.drawable.p4);
                        break;
                    case 5: slika.setImageResource(R.drawable.p5);
                        break;
                    case 6: slika.setImageResource(R.drawable.p6);
                        break;
                    default: finish();
                }

            }
        });


    }

    private void intentKamere(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.emotionapp.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Naziv slike je JPEG_1_ i jos neki random brojevi nzm
        String imageFileName = "JPEG_" + br[0] + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

/*
// Ovaj deo nam daje pristup konkretnoj slici
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            Bitmap myBitmap = BitmapFactory.decodeFile(currentPhotoPath);
        //    slika.setImageBitmap(myBitmap);
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
*/

}
