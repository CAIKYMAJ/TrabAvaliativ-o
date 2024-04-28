package com.example.trabalhoavaliativo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RandomValorAdapter extends RecyclerView.Adapter<RandomValorAdapter.ViewHolder> {

    private List<String> valores;

    public RandomValorAdapter(List<String> valores) {
        this.valores = valores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.random_valoritem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String valor = valores.get(position);
        holder.valorTextView.setText(valor);
    }

    @Override
    public int getItemCount() {
        return valores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView valorTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            valorTextView = itemView.findViewById(R.id.valor_text_view);
        }
    }
}
