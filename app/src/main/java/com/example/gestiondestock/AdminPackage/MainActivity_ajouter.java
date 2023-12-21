package com.example.gestiondestock.AdminPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestiondestock.DataBaseDevices;

import com.example.gestiondestock.R;

public class MainActivity_ajouter extends AppCompatActivity {
    DataBaseDevices dataBaseDevices;

    Button buttonAjouter;
    EditText editTextCode,editTextProduit,editTextPrix,editTextCategorie,editTextQuantite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ajouter);
        editTextCode=findViewById(R.id.editTextCode);
        editTextProduit=findViewById(R.id.editTextProduit);
        editTextCategorie=findViewById(R.id.editTextCategorie);
        editTextPrix=findViewById(R.id.editTextPrix);
        editTextQuantite=findViewById(R.id.editTextQuantite);





        buttonAjouter=findViewById(R.id.buttonAjouter);

        buttonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long code = Integer.parseInt(editTextCode.getText().toString());
                String produit = editTextProduit.getText().toString();
                String categorie = editTextCategorie.getText().toString();
                double prix = Double.parseDouble(editTextPrix.getText().toString());
                long quantite = Integer.parseInt(editTextQuantite.getText().toString());



                DataBaseDevices dbHelp = new DataBaseDevices(MainActivity_ajouter.this);
                SQLiteDatabase db = dbHelp.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("Code", code);
                values.put("produits", produit);
                values.put("catégorie", categorie);
                values.put("prix", prix);
                values.put("quantité", quantite);

                long newRowId = db.insert("Devices", null, values);

                if (newRowId != -1) {
                    Toast.makeText(MainActivity_ajouter.this, "Produit ajouté avec succès!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity_ajouter.this, "Erreur lors de l'ajout de produit.", Toast.LENGTH_SHORT).show();
                }

                // Close the database
                db.close();


            }
        });
    }
}