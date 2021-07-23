package com.example.ibb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText UserNameTx, PasswordTx;
    private String Username, Password;

    user User = new user();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserNameTx = findViewById(R.id.Username);
        PasswordTx = findViewById(R.id.ProductNameText);
    }
    public void Login(View view){
        Username = UserNameTx.getText().toString().trim();
        Password = PasswordTx.getText().toString().trim();

        User.login(getApplicationContext(), Username, Password);
    }
}