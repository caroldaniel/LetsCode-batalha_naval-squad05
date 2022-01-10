import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Jogador {
    Tabuleiro tabuleiro;
    Ships navios;
    int[] tiro = new int[2];
    boolean isPlayer;
    int acertos;
    char[] colunasArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public Jogador(Tabuleiro tabuleiro, Ships navios, boolean isPlayer) {
        this.tabuleiro = tabuleiro;
        this.navios = navios;
        this.isPlayer = isPlayer;
    }

    public void showGrade() {
        this.tabuleiro.mostraTabuleiro(this.isPlayer);
    }

    public void placeShips() {
        this.navios.startPlayerShips(this.tabuleiro.grade);
    }

    public void placeComputerShips() {
        this.navios.startComputerShips(this.tabuleiro.grade);
    }

    public void darTiroAliado() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Linha: ");
        this.tiro[0] = (new String(this.colunasArray)).indexOf(entrada.next().toUpperCase(Locale.ROOT));
        System.out.println("Coluna: ");
        this.tiro[1] = entrada.nextInt() - 1;
    }

    public void darTiroInimigo() {
        Random random = new Random();
        this.tiro[0] = random.nextInt(10);
        this.tiro[1] = random.nextInt(10);
    }

    public boolean acertou(int[][] naviosAdversario) {
        for (int[] ints : naviosAdversario) {
            if (this.tiro[0] == ints[0] && this.tiro[1] == ints[1]) {
                System.out.printf("Você acertou o tiro (%s,%d)\n", this.colunasArray[this.tiro[0]], this.tiro[1] + 1);
                return true;
            }
        }

        return false;
    }
}