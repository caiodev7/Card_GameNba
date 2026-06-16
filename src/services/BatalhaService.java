package services;

import entities.JogadorNBA;

public class BatalhaService {

    public String batalhar(JogadorNBA jogador1, JogadorNBA jogador2) {

        if (jogador1.getOverall() > jogador2.getOverall()) {
            return "🏆 " + jogador1.getNome() + " venceu!";
        }

        if (jogador2.getOverall() > jogador1.getOverall()) {
            return "🏆 " + jogador2.getNome() + " venceu!";
        }

        return "🤝 Empate!";
    }
}