package com.example.gestiondestock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3_inscription extends AppCompatActivity {
    Button inscription;
    EditText editTextPassword,editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_inscription);


        inscription = findViewById(R.id.inscri);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextUsername=findViewById(R.id.editTextUsername);




        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString(); // Password as string

                DataBaseDevices dbhelper = new DataBaseDevices(MainActivity3_inscription.this);
                SQLiteDatabase db = dbhelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put("username", username); // Column name should be "username"
                values.put("password", password);

                long newRowId = db.insert("USERS", null, values);

                if (newRowId != -1) {
                    Toast.makeText(MainActivity3_inscription.this, "Utilisateur ajouté avec succès!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity3_inscription.this, "Erreur lors de l'ajout d'un utilisateur !", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });
    }
}