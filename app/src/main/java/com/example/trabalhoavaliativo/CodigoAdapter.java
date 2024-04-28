package com.example.trabalhoavaliativo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodigoAdapter extends RecyclerView.Adapter<CodigoAdapter.CodigoViewHolder> {

    private List<List<Integer>> historicoTentativas;

    public CodigoAdapter(List<List<Integer>> historicoTentativas) {
        this.historicoTentativas = historicoTentativas;
    }

    @NonNull
    @Override
    public CodigoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new CodigoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CodigoViewHolder holder, int position) {
        List<Integer> tentativa = historicoTentativas.get(position);
        String tentativaString = tentativa.toString(); // Converte a tentativa para uma string para exibição
        holder.textViewTentativa.setText(tentativaString);
    }

    @Override
    public int getItemCount() {
        return historicoTentativas.size();
    }

    public void setTentativas(List<List<Integer>> novasTentativas) {
        int startPosition = historicoTentativas.size();
        historicoTentativas.addAll(novasTentativas.subList(startPosition, novasTentativas.size()));
        notifyItemRangeInserted(startPosition, novasTentativas.size() - startPosition);
    }

    public static class CodigoViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTentativa;

        public CodigoViewHolder(View itemView) {
            super(itemView);
            textViewTentativa = itemView.findViewById(R.id.number_text_view);
        }
    }
}
