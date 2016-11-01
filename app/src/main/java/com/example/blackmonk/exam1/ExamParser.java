package com.example.blackmonk.exam1;

import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


import android.widget.ArrayAdapter;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by blackmonk on 11/1/2016.
 */

public class ExamParser {
    private String myJson;/* = "[\n" +
            "    {\"name\" : \"Juan\", \"age\": 20, \"grade\": 8.1},\n" +
            "    {\"name\" : \"Miguel\", \"age\": 23, \"grade\": 8.3},\n" +
            "    {\"name\" : \"Roberto\", \"age\": 39, \"grade\": 9.3},\n" +
            "    {\"name\" : \"Luis\", \"age\": 19, \"grade\": 6.9},\n" +
            "    {\"name\" : \"Gaudencio\", \"age\": 25, \"grade\": 4.3}\n" +
            "]";*/

    public  ExamParser (String val){
        this.myJson = val;
    }


    public ArrayAdapter<String> parseMagic(){
        Gson gson = new GsonBuilder().create();
        Type listType = new TypeToken<List<Student>>(){}.getType();

        return gson.fromJson(myJson, listType);
    }




}