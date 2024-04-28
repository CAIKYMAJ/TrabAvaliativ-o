package com.example.trabalhoavaliativo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randomizar extends AppCompatActivity {
    private List<String> valoresList;
    private RecyclerView recyclerView;
    private RandomValorAdapter adapter;
    private EditText entradaEditText;
    private TextView valorSorteadoTextView;
    private Button adicionarButton, sortearButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randomizador);

        recyclerView = findViewById(R.id.recycler_view);
        entradaEditText = findViewById(R.id.entrada_edit_text);
        adicionarButton = findViewById(R.id.adicionar_button);
        sortearButton = findViewById(R.id.sortear_button);
        valorSorteadoTextView = findViewById(R.id.valor_sorteado_text_view);

        valoresList = new ArrayList<>();
        adapter = new RandomValorAdapter(valoresList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adicionarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarValor();
            }
        });

        sortearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortearValor();
            }
        });

        findViewById(R.id.voltarB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Randomizar.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void adicionarValor() {
        String entrada = entradaEditText.getText().toString().trim();
        if (!entrada.isEmpty()) {
            String[] valores = entrada.split(",");
            for (String valor : valores) {
                valoresList.add(valor.trim());
            }
            adapter.notifyDataSetChanged();
            entradaEditText.setText("");
        } else {
            Toast.makeText(this, "Insira um valor antes de adicionar", Toast.LENGTH_SHORT).show();
        }
    }

    private void sortearValor() {
        if (!valoresList.isEmpty()) {
            Random random = new Random();
            int indexSorteado = random.nextInt(valoresList.size());
            String valorSorteado = valoresList.get(indexSorteado);
            valorSorteadoTextView.setText("Valor sorteado: " + valorSorteado);
            recyclerView.smoothScrollToPosition(indexSorteado);
        } else {
            Toast.makeText(this, "Adicione valores antes de sortear", Toast.LENGTH_SHORT).show();
        }
    }
}
