import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Navios {
    int[][] navios = new int[10][2];
    char[] colunasArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};


    public void iniciaNaviosAliados(int[][] tabuleiro) {
        int i;
        for (i = 0; i < 10; ++i) {
            Scanner linha = new Scanner(System.in);
            Scanner coluna = new Scanner(System.in);
            System.out.println("Indique uma posição (linha, coluna) ");
            this.navios[i][0] = (new String(this.colunasArray)).indexOf(linha.next().toUpperCase(Locale.ROOT));
            this.navios[i][1] = coluna.nextInt() - 1;
        }

        for (i = 0; i < 10; ++i) {
            tabuleiro[this.navios[i][0]][this.navios[i][1]] = 2;
        }

    }

    public void iniciaNaviosInimigos(int[][] tabuleiro) {
        Random sorteio = new Random();

        int navio;
        for (navio = 0; navio < 10; ++navio) {
            this.navios[navio][0] = sorteio.nextInt(10);
            this.navios[navio][1] = sorteio.nextInt(10);

            for (int anterior = 0; anterior < navio; ++anterior) {
                if (this.navios[navio][0] == this.navios[anterior][0] && this.navios[navio][1] == this.navios[anterior][1]) {
                    do {
                        this.navios[navio][0] = sorteio.nextInt(10);
                        this.navios[navio][1] = sorteio.nextInt(10);
                    } while (this.navios[navio][0] == this.navios[anterior][0] && this.navios[navio][1] == this.navios[anterior][1]);
                }
            }
        }

        for (navio = 0; navio < 10; ++navio) {
            tabuleiro[this.navios[navio][0]][this.navios[navio][1]] = 2;
        }

    }
}
