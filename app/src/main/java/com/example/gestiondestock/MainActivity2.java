package com.example.gestiondestock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestiondestock.AdminPackage.MainActivity_ajouter;
import com.example.gestiondestock.AdminPackage.MainActivity_supprimer;
import com.example.gestiondestock.AdminPackage.MainActivity_voirlinventaire;
import com.example.gestiondestock.AdminPackage.MainActivity_voirproduit;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button ajouter,supprimer,voirlinventaire,voirleproduit;

        ajouter=findViewById(R.id.ajouter);
        supprimer =findViewById(R.id.supprimer);
        voirleproduit=findViewById(R.id.voirleproduit);
        voirlinventaire=findViewById(R.id.voirlinventaire);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity_ajouter.class);
                startActivity(i);
            }
        });

        voirleproduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity_voirproduit.class);
                startActivity(i);

            }
        });

        voirlinventaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity_voirlinventaire.class);
                startActivity(i);

            }
        });

        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, MainActivity_supprimer.class);
                startActivity(i);

            }
        });



    }
}