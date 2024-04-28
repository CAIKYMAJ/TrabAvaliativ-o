package com.example.trabalhoavaliativo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class JogoPedra extends AppCompatActivity {
    private ImageView jogadorEscolheImageView, computadorEscolherImageView;
    private Button pedraBtn, papelBtn, tesouraBtn, voltarBtn;
    private TextView resultadoTextView;

    private enum Choice {
        ROCK, PAPER, SCISSORS
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedra_papel_tesoura);

        jogadorEscolheImageView = findViewById(R.id.player_choice_image);
        computadorEscolherImageView = findViewById(R.id.computer_choice_image);
        pedraBtn = findViewById(R.id.rock_button);
        papelBtn = findViewById(R.id.paper_button);
        tesouraBtn = findViewById(R.id.scissors_button);
        resultadoTextView = findViewById(R.id.result_textview);
        voltarBtn = findViewById(R.id.voltarBtn);

        pedraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(Choice.ROCK);
            }
        });

        papelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(Choice.PAPER);
            }
        });

        tesouraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame(Choice.SCISSORS);
            }
        });

        voltarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JogoPedra.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void playGame(Choice playerChoice) {
        Choice[] choices = Choice.values();
        Choice computerChoice = choices[new Random().nextInt(choices.length)];

        displayChoice(playerChoice, jogadorEscolheImageView);
        displayChoice(computerChoice, computadorEscolherImageView);

        String result = determineResult(playerChoice, computerChoice);
        resultadoTextView.setText(result);
    }

    private void displayChoice(Choice choice, ImageView imageView) {
        switch (choice) {
            case ROCK:
                imageView.setImageResource(R.drawable.pedra1);
                break;
            case PAPER:
                imageView.setImageResource(R.drawable.papel);
                break;
            case SCISSORS:
                imageView.setImageResource(R.drawable.tesoura1);
                break;
        }
    }

    private String determineResult(Choice playerChoice, Choice computerChoice) {
        if (playerChoice == computerChoice) {
            return "Empate!";
        } else if ((playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
                (playerChoice == Choice.PAPER && computerChoice == Choice.ROCK) ||
                (playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)) {
            return "Você venceu!";
        } else {
            return "Você perdeu!";
        }
    }
}
