package com.example.trabalhoavaliativo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RandomValorViewHolder extends RecyclerView.ViewHolder {
    public TextView valorTextView;

    public RandomValorViewHolder(@NonNull View itemView) {
        super(itemView);
        valorTextView = itemView.findViewById(R.id.valor_text_view);
    }
}
