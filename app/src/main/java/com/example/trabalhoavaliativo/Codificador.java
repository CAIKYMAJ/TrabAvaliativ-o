package com.example.trabalhoavaliativo;

import static android.net.Uri.decode;
import static android.net.Uri.encode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Codificador extends AppCompatActivity {
    EditText inputText;
    TextView outputText;
    Button encodeButton;
    Button decodeButton;
    Button voltarMenu;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.codificador);

        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);
        encodeButton = findViewById(R.id.encode_button);
        decodeButton = findViewById(R.id.decode_button);
        voltarMenu = findViewById(R.id.voltarMenu);

        encodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputText.getText().toString();
                String encodeMessage = encode(message, 12);
                outputText.setText(encodeMessage);
            }
            private String encode(String message, int shift) {
                StringBuilder encoded = new StringBuilder();
                for (int i = 0; i < message.length(); i++){
                    char currentChar = message.charAt(i);
                    if (Character.isLetter(currentChar)) {
                        char base = Character.isUpperCase(currentChar) ? 'A' : 'a';
                        encoded.append((char) ((currentChar - base + shift) % 26 + base));
                    } else {
                        encoded.append(currentChar);
                    }
                }
                return encoded.toString();
            }
        });

        decodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodedMessage = inputText.getText().toString();
                String decodedMessage = decode(encodedMessage, 12);
                outputText.setText(decodedMessage);
            }

            private String decode(String encodedMessage, int shift) {
                return encode(encodedMessage, String.valueOf(26 - shift));
            }
        });

        voltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Codificador.this, MenuPrincipal.class);
                startActivity(intent);
            }
        });
    }
}
