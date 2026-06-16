package application;

import entities.JogadorNBA;
import services.BatalhaService;

import java.util.Random;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        ArrayList<JogadorNBA> cartas = new ArrayList<>();

        cartas.add(new JogadorNBA("LeBron James", 95, 85, 96));
        cartas.add(new JogadorNBA("Stephen Curry", 98, 75, 95));
        cartas.add(new JogadorNBA("Kevin Durant", 96, 80, 95));
        cartas.add(new JogadorNBA("Giannis Antetokounmpo", 93, 95, 97));
        cartas.add(new JogadorNBA("Luka Doncic", 94, 78, 94));
        cartas.add(new JogadorNBA("Nikola Jokic", 92, 85, 96));
        cartas.add(new JogadorNBA("Kawhi Leonard", 90, 92, 94));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        BatalhaService batalhaService = new BatalhaService();

        int opcao;

        do {

            System.out.println("\n=== JOGO DE CARTAS NBA ===");
            System.out.println("1 - Listar jogadores");
            System.out.println("2 - Batalhar cartas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:

                    for (int i = 0; i < cartas.size(); i++) {

                        System.out.println("ID: " + i);

                        cartas.get(i).mostrarInfo();
                    }

                    break;

                case 2:

                    int jogadorIndex = random.nextInt(cartas.size());
                    int maquinaIndex;

                    do {
                        maquinaIndex = random.nextInt(cartas.size());
                    } while (maquinaIndex == jogadorIndex);

                    JogadorNBA jogador = cartas.get(jogadorIndex);
                    JogadorNBA maquina = cartas.get(maquinaIndex);

                    System.out.println("\n=== SUA CARTA ===");
                    jogador.mostrarInfo();

                    System.out.println("\nEscolha o atributo:");
                    System.out.println("1 - Ataque");
                    System.out.println("2 - Defesa");
                    System.out.println("3 - Overall");

                    int atributo = scanner.nextInt();

                    int valorJogador = 0;
                    int valorMaquina = 0;

                    switch (atributo) {

                        case 1:
                            valorJogador = jogador.getAtaque();
                            valorMaquina = maquina.getAtaque();
                            break;

                        case 2:
                            valorJogador = jogador.getDefesa();
                            valorMaquina = maquina.getDefesa();
                            break;

                        case 3:
                            valorJogador = jogador.getOverall();
                            valorMaquina = maquina.getOverall();
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }

                    System.out.println("\n=== CARTA DA MÁQUINA ===");
                    maquina.mostrarInfo();

                    System.out.println("\nSeu valor: " + valorJogador);
                    System.out.println("Valor da máquina: " + valorMaquina);

                    if (valorJogador > valorMaquina) {

                        System.out.println("""
                                ╔══════════════════╗
                                ║ 🏆 VOCÊ VENCEU! ║
                                ╚══════════════════╝
                                """);

                    } else if (valorMaquina > valorJogador) {

                        System.out.println("""
                                ╔════════════════════╗
                                ║ 🤖 MÁQUINA VENCEU ║
                                ╚════════════════════╝
                                """);

                    } else {

                        System.out.println("""
                                ╔══════════╗
                                ║ 🤝 EMPATE ║
                                ╚══════════╝
                                """);
                    }

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}