package com.example.lesson31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView car;
    private Button go;
    private EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        AddImage();
        OnClickListener();



    }

    private void OnClickListener() {
        go.setOnClickListener(view -> {
            String log = login.getText().toString();
            String pass = password.getText().toString();
            if (log.isEmpty()){
                login.setError("Логин пустой");
            }else if(pass.length() <6){
                password.setError("Пароль должен быть не менее из 6 символов");
            }else {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("login",log);
                intent.putExtra("password",pass);
                startActivity(intent);
                finish();
            }
        });

    }

    private void AddImage() {
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

    private void InitView() {
        car = findViewById(R.id.im_car);
        go = findViewById(R.id.btn_go);
        login = findViewById(R.id.username);
        password = findViewById(R.id.password_main);
    }
}