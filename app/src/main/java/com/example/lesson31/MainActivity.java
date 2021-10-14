package com.example.lesson31;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout userName;
    private ImageView car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.text_layout);
        car = findViewById(R.id.im_car);


        Glide.with(this)
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWdeWJQgtUb5OgPMHGGF07g8ZcCEuq72JqlFQPIMBymrG89nzQh0PgJFx0FGfGGog4Zt4&usqp=CAU")
                .into(car);



        TextInputLayout emailTextInputLayout = new TextInputLayout(this, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);

        emailTextInputLayout.setHint("Username");
        emailTextInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        emailTextInputLayout.setBoxCornerRadii(5, 5, 5, 5);
        TextInputEditText edtEmail = new TextInputEditText(emailTextInputLayout.getContext());
        emailTextInputLayout.addView(edtEmail);


        TextInputLayout passTextInputLayout = new TextInputLayout(this, null, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);

        passTextInputLayout.setHint("Password");
        passTextInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
        passTextInputLayout.setBoxCornerRadii(5, 5, 5, 5);
        TextInputEditText edtPass = new TextInputEditText(passTextInputLayout.getContext());
        passTextInputLayout.addView(edtPass);



    }
}