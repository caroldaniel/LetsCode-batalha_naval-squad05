import java.util.Arrays;

public class Jogo {
    Jogador jogador1;
    Jogador maquina;

    public Jogo(Jogador jogador1, Jogador maquina) {
        this.jogador1 = jogador1;
        this.maquina = maquina;
    }

    public void play() {
        this.jogador1.tabuleiro.inicializaTabuleiro();
        this.maquina.tabuleiro.inicializaTabuleiro();
        this.jogador1.showGrade();
        this.jogador1.placeShips();
        this.maquina.placeComputerShips();
        System.out.println(Arrays.deepToString(this.maquina.navios.navios));

        do {
            this.jogador1.showGrade();
            this.jogador1.darTiroAliado();
            if (this.jogador1.acertou(this.maquina.navios.navios)) {
                ++this.jogador1.acertos;
            }

            this.jogador1.tabuleiro.alteraTabuleiro(this.maquina.navios.navios, this.jogador1);
            this.maquina.darTiroInimigo();
            if (this.maquina.acertou(this.jogador1.navios.navios)) {
                ++this.maquina.acertos;
            }

            this.maquina.tabuleiro.alteraTabuleiro(this.jogador1.navios.navios, this.maquina);
            if (this.jogador1.acertos == 10) {
                System.out.println("JOGADOR VENCEU O JOGO");
                break;
            }

            if (this.maquina.acertos == 10) {
                System.out.println("MAQUINA VENCEU O JOGO");
                break;
            }
        } while(this.jogador1.acertos != 10 || this.maquina.acertos != 10);

        this.jogador1.showGrade();
        this.maquina.showGrade();
    }
}