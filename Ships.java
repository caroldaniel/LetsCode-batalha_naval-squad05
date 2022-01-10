import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Ships {
    int[][] ships = new int[10][2];
    char[] lettersArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public void startPlayerShips(int[][] grade) {
        int i;
        for (i = 0; i < 10; ++i) {
            Scanner line = new Scanner(System.in);
            Scanner collum = new Scanner(System.in);
            System.out.println("Indique uma posição (linha, coluna) ");
            this.ships[i][0] = (new String(this.lettersArray)).indexOf(line.next().toUpperCase(Locale.ROOT));
            this.ships[i][1] = collum.nextInt() - 1;
        }

        for (i = 0; i < 10; ++i) {
            grade[this.ships[i][0]][this.ships[i][1]] = 2;
        }

    }

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
