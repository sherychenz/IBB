package com.example.ibb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminPage2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page2);
    }

    public void AddNew(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminMenuActivity.class);
        startActivity(intent);
    }
}