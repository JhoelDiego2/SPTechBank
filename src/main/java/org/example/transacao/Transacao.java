package org.example.transacao;

import java.time.LocalDateTime;

public class Transacao {
    String descricao;
    double valor;
    LocalDateTime dataHora;

    public Transacao(String novaDescricao, double novoValor) {
        this.descricao = novaDescricao;
        this.valor = novoValor;
        this.dataHora = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String formatarTexto() {
        return String.format("Data: %s | Descrição: %s | Valor: %.2f", dataHora.toString(), descricao, valor);
    }
}