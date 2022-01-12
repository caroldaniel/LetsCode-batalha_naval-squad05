import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Ships {
	// inicialização das variáveis dos navios
    int[][] ships = new int[10][2];
    char[] lettersArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

	// método para posicionamento manual dos navios do usuário
    public void startPlayerShips(int[][] grade) {
        int i;
        for (i = 0; i < 10; ++i) {
            Scanner line = new Scanner(System.in);
            Scanner column = new Scanner(System.in);
            System.out.printf("Posicione o seu navio #%d\n", i + 1);
            System.out.printf("Digite a linha (de 'A' a 'J'): ");
            this.ships[i][0] = (new String(this.lettersArray)).indexOf(line.next().toUpperCase(Locale.ROOT));
			while (this.ships[i][0] < 0 || this.ships[i][0] > 9) {
				System.out.printf("Inválido!\nDigite a linha (de 'A' a 'J'): ");
				this.ships[i][0] = (new String(this.lettersArray)).indexOf(line.next().toUpperCase(Locale.ROOT));
			}
			System.out.printf("Digite a coluna (de 1 a 10): ");
            this.ships[i][1] = column.nextInt() - 1;
			while (this.ships[i][1] < 0 || this.ships[i][1] > 9) {
				System.out.printf("Inválido!\nDigite a coluna (de 1 a 10): ");
				this.ships[i][1] = column.nextInt() - 1;
			}
        }
        for (i = 0; i < 10; ++i) {
            grade[this.ships[i][0]][this.ships[i][1]] = 2;
        }

    }

	// método para posicionamento aleatório dos navios do inimigo 
    public void startComputerShips(int[][] grade) {
        Random random = new Random();

        int ship;
        for (ship = 0; ship < 10; ++ship) {
            this.ships[ship][0] = random.nextInt(10);
            this.ships[ship][1] = random.nextInt(10);

            for (int before = 0; before < ship; ++before) {
                if (this.ships[ship][0] == this.ships[before][0] && this.ships[ship][1] == this.ships[before][1]) {
                    do {
                        this.ships[ship][0] = random.nextInt(10);
                        this.ships[ship][1] = random.nextInt(10);
                    } while (this.ships[ship][0] == this.ships[before][0] && this.ships[ship][1] == this.ships[before][1]);
                }
            }
        }
        for (ship = 0; ship < 10; ++ship) {
            grade[this.ships[ship][0]][this.ships[ship][1]] = 2;
        }
    }
}
