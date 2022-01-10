public class Main {

    public static void main(String[] args) {
        Board boardJogador = new Board();
        Board boardMaquina = new Board();
        Ships naviosJogador = new Ships();
        Ships naviosMaquina = new Ships();
        Jogador joao = new Jogador(boardJogador, naviosJogador, true);
        Jogador maquina = new Jogador(boardMaquina, naviosMaquina, false);
        Jogo batalhaNaval = new Jogo(joao, maquina);


        batalhaNaval.play();
    }
}