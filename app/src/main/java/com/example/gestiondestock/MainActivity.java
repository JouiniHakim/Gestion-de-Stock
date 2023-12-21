package com.example.gestiondestock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestiondestock.AdminPackage.MainActivity_supprimer;
import com.example.gestiondestock.ClientPackage.MainActivity_clientside;

public class MainActivity extends AppCompatActivity {

    Button connexion, inscription;
    EditText name, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connexion = findViewById(R.id.connexion);
        inscription = findViewById(R.id.inscription);  // Add this line
        name = findViewById(R.id.nom);
        pass = findViewById(R.id.pass);

        connexion.setOnClickListener(v -> {

            String username = name.getText().toString();
            String password = pass.getText().toString();


            if (username.equals("admin") && password.equals("admin")) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            } else {
                DataBaseDevices dbHelp = new DataBaseDevices(MainActivity.this);
                SQLiteDatabase db = dbHelp.getReadableDatabase();
                String query = "SELECT username, password FROM USERS WHERE username = ? and password = ?";
                Cursor cursor = db.rawQuery(query, new String[]{username, password});

                if (cursor.moveToFirst()) {

                        Intent i = new Intent(MainActivity.this, MainActivity_clientside.class); // clientside
                        startActivity(i);


                } else {

                    Toast.makeText(MainActivity.this, "nom d'utilisateur ou mot de passe invalide", Toast.LENGTH_SHORT).show();
                }


                cursor.close();
                db.close();
            }
        });

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity3_inscription.class);
                startActivity(i);
            }
        });
    }
}
