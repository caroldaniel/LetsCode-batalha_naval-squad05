public class Board {
    int[][] grid = new int[10][10];
    String[] lettersArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void startBoard() {
        for (int line = 0; line < 10; ++line) {
            for (int collum = 0; collum < 10; ++collum) {
                this.grid[line][collum] = -1;
            }
        }

    }

    public void showBoard(boolean jogador) {
        if (jogador) {
            System.out.println("--------------------------------------------");
            System.out.println("\t \t \t \t JOGADOR");
            System.out.println("--------------------------------------------");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("\t \t \t \t MAQUINA");
            System.out.println("--------------------------------------------");
        }

        System.out.println("\t 1 \t 2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t10");

        for (int line = 0; line < 10; ++line) {
            System.out.print(this.lettersArray[line]);

            for (int collum = 0; collum < 10; ++collum) {
                if (this.grid[line][collum] == -1) {
                    System.out.print("\t| |");
                } else if (this.grid[line][collum] == 0) {
                    System.out.print("\t|-|");
                } else if (this.grid[line][collum] == 1) {
                    System.out.print("\t|*|");
                } else if (this.grid[line][collum] == 2) {
                    System.out.print("\t|N|");
                } else if (this.grid[line][collum] == 3) {
                    System.out.print("\t|X|");
                } else if (this.grid[line][collum] == 4) {
                    System.out.print("\t|n|");
                }
            }

            System.out.println();
        }

    }

    public void updateBoard(int[][] enemy, Jogador player) {
        if (player.acertou(enemy)) {
            if (this.grid[player.tiro[0]][player.tiro[1]] == 2) {
                this.grid[player.tiro[0]][player.tiro[1]] = 3;
            } else {
                this.grid[player.tiro[0]][player.tiro[1]] = 1;
            }
        } else if (this.grid[player.tiro[0]][player.tiro[1]] == 2) {
            this.grid[player.tiro[0]][player.tiro[1]] = 4;
        } else {
            this.grid[player.tiro[0]][player.tiro[1]] = 0;
        }

    }
}