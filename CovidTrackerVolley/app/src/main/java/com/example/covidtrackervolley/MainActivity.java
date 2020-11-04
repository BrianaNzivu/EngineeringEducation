package com.example.covidtrackervolley;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView totalCasesWorld, totalDeathsWorld, totalRecoveredWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the objects
        totalCasesWorld = (TextView) findViewById(R.id.newCasesWorld);
        totalDeathsWorld = (TextView) findViewById(R.id.newDeathsWorld);
        totalRecoveredWorld = (TextView) findViewById(R.id.newRecoveredWorld);

        getData();

    }

    private void getData() {

        // Create a String request using Volley Library

        String myUrl = "https://corona.lmao.ninja/v2/all";

        StringRequest myRequest = new StringRequest(Request.Method.GET, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{
                            //Create a JSON object containing information from the API.
                            JSONObject myJsonObject = new JSONObject(response.toString());

                            totalCasesWorld.setText(
                                    myJsonObject.getString(
                                            "cases"));

                            totalRecoveredWorld.setText(
                                    myJsonObject.getString(
                                            "recovered"));

                            totalDeathsWorld.setText(
                                    myJsonObject.getString(
                                            "deaths"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(
                                MainActivity.this,
                                volleyError.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(myRequest);
    }
}
