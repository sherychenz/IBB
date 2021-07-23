package com.example.ibb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AdminPage2Activity extends AppCompatActivity {
    private EditText ProductNameText, NewStockText;
    private String StockName, Stock;

    stock stock = new stock();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page2);

        ProductNameText       = findViewById(R.id.ProductNameText);
        NewStockText            = findViewById(R.id.NewStockText);
    }

    public void AddNew(View view) {
        StockName = ProductNameText.getText().toString().trim();
        Stock = NewStockText.getText().toString().trim();

        if (StockName.isEmpty() && Stock.isEmpty()){
            ProductNameText.setError("Can't be Empty");
            NewStockText.setError("Can't be Empty");
        }else  if(StockName.isEmpty()){
            ProductNameText.setError("Can't be Empty");
        }else  if(Stock.isEmpty()){
            NewStockText.setError("Can't be Empty");
        }else{
            stock.addNewStock(getApplicationContext(), StockName, Stock);
        }
    }
}