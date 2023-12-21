package com.example.gestiondestock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context ;
    private ArrayList id,code,produit,categorie,prix,quantite;

    public MyAdapter(Context context, ArrayList id, ArrayList code, ArrayList produit, ArrayList categorie,ArrayList prix, ArrayList quantite) {
        this.context = context;
        this.id = id;
        this.code = code;
        this.produit = produit;
        this.categorie = categorie;
        this.prix=prix;
        this.quantite = quantite;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.deviceentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(id.get(position)));
        holder.code.setText(String.valueOf(code.get(position)));
        holder.produit.setText(String.valueOf(produit.get(position)));
        holder.categorie.setText(String.valueOf(categorie.get(position)));
        holder.prix.setText(String.valueOf(prix.get(position)));
        holder.quantite.setText(String.valueOf(quantite.get(position)));

    }

    @Override
    public int getItemCount() {
        return code.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  id,code,produit,categorie,prix,quantite;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            code=itemView.findViewById(R.id.code);
            produit=itemView.findViewById(R.id.produit);
            categorie=itemView.findViewById(R.id.categorie);
            prix=itemView.findViewById(R.id.prix);
            quantite=itemView.findViewById(R.id.quantite);
        }
    }
}
