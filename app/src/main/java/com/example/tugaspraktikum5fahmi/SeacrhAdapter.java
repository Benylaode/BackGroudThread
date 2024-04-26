package com.example.tugaspraktikum5fahmi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SeacrhAdapter extends RecyclerView.Adapter<SeacrhAdapter.ViewHolder> {
    private ArrayList<MamaliaPurba> mamaliaPurbas ;

    public SeacrhAdapter(ArrayList<MamaliaPurba> mamaliaPurbas) {
        this.mamaliaPurbas = mamaliaPurbas;
    }
    @NonNull
    @Override
    public SeacrhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardsearch, parent, false);
        return new SeacrhAdapter.ViewHolder(view);
    }
    public void onBindViewHolder(@NonNull SeacrhAdapter.ViewHolder holder, int position) {

        MamaliaPurba mamaliaPurba = mamaliaPurbas.get(position);

        holder.IV_Search.setImageResource(mamaliaPurba.getFotoProfile());
        holder.tv_username.setText(mamaliaPurba.getUsername());
        holder.tv_name.setText(mamaliaPurba.getName());

        holder.IV_Search.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("mamalia", mamaliaPurbas);
            holder.context.startActivity(intent);
        });

        holder.tv_username.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("mamalia", mamaliaPurbas);
            holder.context.startActivity(intent);
        });
        holder.tv_name.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, ProfileActivity.class);
            intent.putExtra("mamalia", mamaliaPurbas);
            holder.context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView IV_Search;
        TextView tv_username, tv_name;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_Search = itemView.findViewById(R.id.iv_search);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_name = itemView.findViewById(R.id.tv_name);
            context = itemView.getContext();
        }
    }
}