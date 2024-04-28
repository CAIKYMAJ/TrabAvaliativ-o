package com.example.trabalhoavaliativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CodigoSecreto {

    private static final int TAMANHO_CODIGO = 4;
    private List<Integer> codigoSecreto;
    private List<List<Integer>> historicoTentativas;
    private int numeroTentativas;
    private List<List<Integer>> todasTentativas;

    public CodigoSecreto() {
        codigoSecreto = gerarCodigoSecreto();
        historicoTentativas = new ArrayList<>();
        todasTentativas = new ArrayList<>(); // Inicializa a lista de todas as tentativas
        numeroTentativas = 0; // Inicializa o contador de tentativas
    }

    private List<Integer> gerarCodigoSecreto() {
        Random random = new Random();
        List<Integer> codigo = new ArrayList<>();
        for (int i = 0; i < TAMANHO_CODIGO; i++) {
            codigo.add(random.nextInt(10)); // Dígitos aleatórios de 0 a 9
        }
        return codigo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> tentativa : getHistoricoTentativas()) {
            sb.append("Tentativa: ");
            for (Integer numero : tentativa) {
                sb.append(numero).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void adicionarTentativa(List<Integer> tentativa) {
        historicoTentativas.add(tentativa);
        todasTentativas.add(tentativa); // Adiciona a tentativa à lista de todas as tentativas
        numeroTentativas++; // Incrementa o contador de tentativas
        if (verificarAcerto(tentativa)) {
            System.out.println("Parabéns! Você acertou o código secreto.");
        }
    }

    public boolean verificarAcerto(List<Integer> tentativa) {
        return tentativa.equals(codigoSecreto);
    }

    public String exibirFeedback(List<Integer> tentativa) {
        StringBuilder feedback = new StringBuilder("Feedback: ");

        // Verifica se a tentativa é igual ao código secreto
        if (tentativa.equals(codigoSecreto)) {
            feedback.append("Parabéns! Você acertou o código secreto.");
        } else {
            // Se não for igual, verifica cada dígito da tentativa em relação ao código secreto
            for (int i = 0; i < TAMANHO_CODIGO; i++) {
                if (tentativa.get(i).equals(codigoSecreto.get(i))) {
                    feedback.append("Certo \n");
                } else if (codigoSecreto.contains(tentativa.get(i))) {
                    feedback.append("Certo na posição errada \n");
                } else {
                    feedback.append("Errado \n");
                }
            }
        }

        return feedback.toString();
    }

    public List<List<Integer>> getHistoricoTentativas() {
        return historicoTentativas;
    }

    public List<Integer> getCodigoSecreto() {
        return codigoSecreto;
    }

    public int getNumeroTentativas() {
        return numeroTentativas;
    }
}
