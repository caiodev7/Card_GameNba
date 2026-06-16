package entities;

public class JogadorNBA {
    private String nome;
    private int ataque;
    private int defesa;
    private int overall;

    public JogadorNBA(String nome, int ataque, int defesa, int overall) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.overall = overall;
    }

    public String getNome() {
        return nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getOverall() {
        return overall;
    }

    public void mostrarInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println("Overall: " + overall);
        System.out.println("----------------------");
    }
}
