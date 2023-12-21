package com.example.gestiondestock.AdminPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestiondestock.DataBaseDevices;
import com.example.gestiondestock.R;

public class MainActivity_supprimer extends AppCompatActivity {
    Button buttonSupprimer;
    EditText editTextcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_supprimer);

        buttonSupprimer=findViewById(R.id.buttonSupprimer);


        buttonSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editTextcode.getText().toString();

                DataBaseDevices dbHelper = new DataBaseDevices(MainActivity_supprimer.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                int rowsDeleted = db.delete("devices", "code=?", new String[]{code});

                if (rowsDeleted > 0) {
                    Toast.makeText(MainActivity_supprimer.this, "Produit supprimé avec succès !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity_supprimer.this, "Erreur lors de la suppression de Produit ", Toast.LENGTH_SHORT).show();
                }

                db.close();
            }
        });



    }
}