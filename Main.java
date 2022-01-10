public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Tabuleiro tabuleiroJogador = new Tabuleiro();
        Tabuleiro tabuleiroMaquina = new Tabuleiro();
        Navios naviosJogador = new Navios();
        Navios naviosMaquina = new Navios();
        Jogador joao = new Jogador(tabuleiroJogador, naviosJogador, true);
        Jogador maquina = new Jogador(tabuleiroMaquina, naviosMaquina, false);
        Jogo batalhaNaval = new Jogo(joao, maquina);
        batalhaNaval.play();
    }
}