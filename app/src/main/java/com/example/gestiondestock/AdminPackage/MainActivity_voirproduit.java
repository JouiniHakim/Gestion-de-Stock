package com.example.gestiondestock.AdminPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestiondestock.DataBaseDevices;
import com.example.gestiondestock.R;

public class MainActivity_voirproduit extends AppCompatActivity {

    Button search;
    EditText editTextSearch;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_voirproduit);

        search=findViewById(R.id.buttonSearch);
        editTextSearch=findViewById(R.id.editTextSearch);
        textViewResult=findViewById(R.id.textViewResult);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeString = editTextSearch.getText().toString();

                if (codeString.isEmpty()) {
                    Toast.makeText(MainActivity_voirproduit.this, "SVP enter votre code", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convert the code to long
                long code = Long.parseLong(codeString);

                DataBaseDevices dbHelper = new DataBaseDevices(MainActivity_voirproduit.this);
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                String query = "SELECT produits, catégorie, prix, quantité FROM devices WHERE code = ?";

                Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(code)});

                if (cursor.moveToFirst()) {
                    String produit = cursor.getString(0);
                    String categorie = cursor.getString(1);
                    double prix = cursor.getDouble(2);
                    long quantite = cursor.getLong(3);

                    String result = "produits: " + produit + "\ncategorie: " + categorie + "\nPrix: " + prix + "\nquantite: " + quantite;
                    textViewResult.setText(result);
                } else {
                    //textViewResult.setText("device not found");
                    Toast.makeText(MainActivity_voirproduit.this, "Produit n'existe pas.", Toast.LENGTH_SHORT).show();
                }

                cursor.close();
                db.close();
            }
        });

    }
}