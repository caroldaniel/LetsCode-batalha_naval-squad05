import java.util.Arrays;

public class Jogo {
    Jogador jogador1;
    Jogador maquina;

    public Jogo(Jogador jogador1, Jogador maquina) {
        this.jogador1 = jogador1;
        this.maquina = maquina;
    }

    public void play() {
        this.jogador1.board.startBoard();
        this.maquina.board.startBoard();
        this.jogador1.showGrade();
        this.jogador1.placeShips();
        this.maquina.placeComputerShips();
        System.out.println(Arrays.deepToString(this.maquina.ships.ships));

        do {
            this.jogador1.showGrade();
            this.jogador1.darTiroAliado();
            if (this.jogador1.acertou(this.maquina.ships.ships)) {
                ++this.jogador1.acertos;
            }

            this.jogador1.board.updateBoard(this.maquina.ships.ships, this.jogador1);
            this.maquina.darTiroInimigo();
            if (this.maquina.acertou(this.jogador1.ships.ships)) {
                ++this.maquina.acertos;
            }

            this.maquina.board.updateBoard(this.jogador1.ships.ships, this.maquina);
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