package com.example.blackmonk.exam1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG_";
    OkHttpClient client = new OkHttpClient();

    private EditText username;
    private EditText password;

    private String myJSONHTTP = "";

    private ArrayAdapter<String> valAdapter;

    private SharedPreferences studentPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Context context = this;
        studentPref = context.getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE);




        username = (EditText)findViewById(R.id.main_user);
        password = (EditText)findViewById(R.id.main_pass);






        try {
            //myJSONHTTP = run("https://randomuser.me/api");

            myJSONHTTP = run("http://www.mocky.io/v2/57a01bec0f0000c10d0f650f");

            Log.d(TAG, "onCreate: " + myJSONHTTP);

            valAdapter = getValues(myJSONHTTP);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
    }


    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public ArrayAdapter<String> getValues(String vals){

        ExamParser parser = new ExamParser(vals);
        return parser.parseMagic();
    }

    public void lookupMagic(View view){

        String user = username.getText().toString();
        String pass = password.getText().toString();

        studentPref.edit().putString(username.toString(), password.toString());

        



        Log.d(TAG, "lookupMagic: POSITION: " + user);



        // do lookup and pass values with shared preferences to StatusActvity






    }


}
