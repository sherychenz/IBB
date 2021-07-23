package com.example.ibb;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class stock {
    private static final String URL_stockname = "https://latihan000.000webhostapp.com/stockname.php";
    private static final String URL_stockupdate = "https://latihan000.000webhostapp.com/stockupdate.php";

    private String ID;
    private String StockName;
    private String Stock;

    public stock() {
    }

    public stock(String ID, String StockName, String Stock){
        this.ID = ID;
        this.StockName = StockName;
        this.Stock = Stock;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getStockName() { return StockName; }

    public void setStockName(String StockName) { StockName = StockName; }

    public String getStock() { return Stock; }

    public void setStock (String Stock) { Stock = Stock; }

    public void managestock (String StockName, String Stock){

    }

    public void addNewStock(Context context , final String StockName, final String Stock){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_stockname,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(context, "Added Success", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(context, AdminPage2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        } catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(context, "Added Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("stockname", StockName);
                params.put("stock", Stock);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }

    public void UpdateStock(Context context , String stock, String ID){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_stockupdate,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(context, "Success Change", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(context, AdminPage2Activity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);

                        } catch (JSONException e){
                            e.printStackTrace();
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("id", ID);
                params.put("stock", stock);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
