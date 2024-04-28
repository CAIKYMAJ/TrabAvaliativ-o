package com.example.trabalhoavaliativo;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CodigoViewHolder extends RecyclerView.ViewHolder {

    public TextView numberTextView;

    public CodigoViewHolder(View itemView) {
        super(itemView);
        numberTextView = itemView.findViewById(R.id.number_text_view);
    }
}
