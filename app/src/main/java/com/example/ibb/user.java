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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class user {

    private static final String URL = "https://latihan000.000webhostapp.com/login.php";
    private static final String URL_REGISTER = "https://latihan000.000webhostapp.com/register.php";

    private String ID;
    private String Username;
    private String Password;

    public user(){
    }

    public user(String ID, String Username, String Password){
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
    }

    public String getID() { return ID; }

    public void setID(String ID) { this.ID = ID; }

    public String getUserName() { return Username; }

    public void setUserName(String username) { Username = username; }

    public String getPassword() { return Password; }

    public void setPassword(String password) { Password = password; }

    public void login(final Context context, final String username, final String password){
        if (!username.isEmpty() && !password.isEmpty()){
            System.out.println(username);
            System.out.println(password);

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response){
                            System.out.println(response);
                            try{
                                JSONObject jsonObject = new JSONObject(response);
                                String success = jsonObject.getString("success");
                                JSONArray jsonArray = jsonObject.getJSONArray("login");
                                if(success.equals("1")){
                                    for(int i=0; i < jsonArray.length();i++){
                                        JSONObject object = jsonArray.getJSONObject(i);
                                        if (object.get("Username").equals("AdminIBB")){
                                            Toast.makeText(context, "Login Success! Welcome", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(context, AdminMenuActivity.class);
                                            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                                            context.startActivity(intent);
                                        }
                                        else if (object.get("Username").equals("OwnerIBB")){
                                            Toast.makeText(context, "Login Success! Welcome", Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(context, OwnerPageActivity.class);
                                            intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                                            context.startActivity(intent);
                                        }
                                        else{}
                                        Toast.makeText(context, "", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }
                            catch (JSONException x){
                                x.printStackTrace();
                                Toast.makeText(context, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                    new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError error){
                            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Username", username);
                    params.put("Password", password);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(stringRequest);
        }
        else{
            Toast.makeText(context, "Username and Password can not be empty!", Toast.LENGTH_SHORT).show();
        }
    }
}