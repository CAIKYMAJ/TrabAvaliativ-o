package com.example.trabalhoavaliativo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ValorAdapter extends RecyclerView.Adapter<ValorAdapter.ValorViewHolder> {

    private List<String> valoresList;

    public ValorAdapter(List<String> valoresList) {
        this.valoresList = valoresList;
    }

    @NonNull
    @Override
    public ValorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_valor, parent, false);
        return new ValorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ValorViewHolder holder, int position) {
        String valor = valoresList.get(position);
        holder.valorTextView.setText(valor);
    }

    @Override
    public int getItemCount() {
        return valoresList.size();
    }

    static class ValorViewHolder extends RecyclerView.ViewHolder {
        TextView valorTextView;

        public ValorViewHolder(@NonNull View itemView) {
            super(itemView);
            valorTextView = itemView.findViewById(R.id.valor_text_view);
        }
    }
}
