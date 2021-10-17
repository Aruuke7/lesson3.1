package com.example.lesson31;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class SecondActivity extends AppCompatActivity {
    private EditText userNameView, passwordView;
    private ImageView image;
    private TextView editPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        InitView();
        AddLoginAndPassword();

        editPhoto.setOnClickListener(view -> {
            SelectImage();
        });


    }

    private void SelectImage(){
            final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
            AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
            builder.setTitle("Add Photo!");
            builder.setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int item) {
                    if (options[item].equals("Take Photo"))
                    { if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                        requestPermissions(new String[]{Manifest.permission.CAMERA},1);
                    }else {
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent, 1);

                    } }
                    else if (options[item].equals("Choose from Gallery"))
                    {
                        Intent intent = new   Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(intent, 2);
                    }
                    else if (options[item].equals("Cancel")) {
                        dialog.dismiss();
                    }
                }
            });
            builder.show();
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data !=null && requestCode == 1){
           Bundle extras = data.getExtras();
           Bitmap imageBitmap = (Bitmap) extras.get("data");
           image.setImageBitmap(imageBitmap);
        }
        if (resultCode==RESULT_OK && data !=null&& requestCode == 2){
            Uri selectedImage = data.getData();
            image.setImageURI(selectedImage);
        }
    }

    private void AddLoginAndPassword() {
        String log = getIntent().getStringExtra("login");
        userNameView.setText(log);

        String pass = getIntent().getStringExtra("password");
        passwordView.setText(pass);
    }

    private void InitView() {
        userNameView = findViewById(R.id.login_second);
        passwordView = findViewById(R.id.password_second);
        image = findViewById(R.id.image);
        editPhoto = findViewById(R.id.edit_photo);
    }

}