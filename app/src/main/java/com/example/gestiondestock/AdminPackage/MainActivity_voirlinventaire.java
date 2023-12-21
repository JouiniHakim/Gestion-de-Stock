package com.example.gestiondestock.AdminPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gestiondestock.DataBaseDevices;
import com.example.gestiondestock.MyAdapter;
import com.example.gestiondestock.R;

import java.util.ArrayList;

// MainActivity.java
public class MainActivity_voirlinventaire extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id,code,produit,categorie,prix,quantite;
    DataBaseDevices DB;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_voirlinventaire);


        DB = new DataBaseDevices(this);
        id= new ArrayList<>();
        code= new ArrayList<>();
        produit= new ArrayList<>();
        categorie= new ArrayList<>();
        prix= new ArrayList<>();
        quantite= new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this,id,code,produit,categorie,prix,quantite);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


   


    }

    private void displaydata() {
        Cursor cursor = DB.getData();
        if(cursor.getCount()==0){
            Toast.makeText(MainActivity_voirlinventaire.this,"No ENTRY",Toast.LENGTH_SHORT).show();
            return;

        }else{

            while(cursor.moveToNext()){
                id.add(String.valueOf(cursor.getInt(0)));
                code.add(String.valueOf(cursor.getLong(1)));
                produit.add(cursor.getString(2));
                categorie.add(cursor.getString(3));
                prix.add(String.valueOf(cursor.getDouble(4)));
                quantite.add(String.valueOf(cursor.getLong(5)));



            }
        }

    }

}
