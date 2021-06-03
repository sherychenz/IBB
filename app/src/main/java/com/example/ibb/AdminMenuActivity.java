package com.example.ibb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
    }

    public void UpdateStock(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminPageActivity.class);
        startActivity(intent);
    }

    public void AddNewProduct(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminPage2Activity.class);
        startActivity(intent);
    }

    public void SignOut(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}