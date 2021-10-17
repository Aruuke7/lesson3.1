package com.example.lesson31;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



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