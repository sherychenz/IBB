package com.example.ibb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }

    public void Update(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminPageActivity.class);
        startActivity(intent);
    }
}