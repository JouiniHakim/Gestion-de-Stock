package com.example.gestiondestock.ClientPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.example.gestiondestock.AdminPackage.MainActivity_voirlinventaire;
import com.example.gestiondestock.DataBaseDevices;

import com.example.gestiondestock.R;
import com.google.android.material.textfield.TextInputEditText;



public class MainActivity_clientside extends AppCompatActivity {
    Button buttonvoirlinventaire,buttonEmprunter;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clientside);


        buttonEmprunter=findViewById(R.id.buttonEmprunter);
        TextInputEditText editTextCode = findViewById(R.id.editTextCode);
        TextInputEditText editTextProduit = findViewById(R.id.editTextProduit);
        TextInputEditText editTextCategorie = findViewById(R.id.editTextCategorie);



        buttonvoirlinventaire=findViewById(R.id.buttonvoirlinventaire);

        buttonvoirlinventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity_clientside.this,MainActivity_voirlinventaire.class);
                startActivity(i);
            }
        });

        buttonEmprunter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextCode.getText().toString();
                String produit = editTextProduit.getText().toString();
                String categorie = editTextCategorie.getText().toString();

                // Retrieve the current quantity from the database
                DataBaseDevices dbHelper = new DataBaseDevices(MainActivity_clientside.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String query = "SELECT quantité FROM devices WHERE code = ? AND produits = ? AND catégorie = ?";
                Cursor cursor = db.rawQuery(query, new String[]{code, produit, categorie});

                long currentQuantity = 0;
                if (cursor.moveToFirst()) {
                    currentQuantity = cursor.getLong(0);
                }
                cursor.close();


                if (currentQuantity > 0) {
                    currentQuantity--;


                    ContentValues values = new ContentValues();
                    values.put("quantité", currentQuantity);

                    int rowsUpdated = db.update("devices", values, "code=? AND produits=? AND catégorie=?", new String[]{code, produit, categorie});

                    if (rowsUpdated > 0) {
                        Toast.makeText(MainActivity_clientside.this, "Vous avez bien Emprunté ce produit", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity_clientside.this, "Erreur d'emprunté ce produit.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity_clientside.this, "Il n y a pas ce produit 0.", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });





    }}