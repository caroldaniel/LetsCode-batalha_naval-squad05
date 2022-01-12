public class Board {
	// inicialização das variáveis de tabuleiro e de localização
    int[][] grid = new int[10][10];
    String[] lettersArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

	// método de inicialização do tabuleiro
    public void startBoard() {
        for (int line = 0; line < 10; ++line) {
            for (int column = 0; column < 10; ++column) {
                // inicializar grid com todas as posições vazias
				this.grid[line][column] = -1; 
            }
        }
    }
	
	// método de impressão do tabuleiro na tela
    public void showBoard(boolean isPlayer) {
        if (isPlayer) {
            System.out.println("---------------------------------------------------");
            System.out.println("                     JOGADOR");
            System.out.println("---------------------------------------------------");
        } else {
            System.out.println("---------------------------------------------------");
            System.out.println("                     MAQUINA");
            System.out.println("---------------------------------------------------");
        }
		// imprime o número das colunas
        System.out.println("    1    2    3    4    5    6    7    8    9   10");

        for (int line = 0; line < 10; ++line) {
			// imprime a letra de indicação de cada linha
            System.out.print(this.lettersArray[line]);
			// imprime a indicação de cada posição daquela linha
            for (int column = 0; column < 10; ++column) {
				if (this.grid[line][column] == -1) {
					System.out.print("  | |");
                } else if (this.grid[line][column] == 0) {
					System.out.print("  |-|");
                } else if (this.grid[line][column] == 1) {
					System.out.print("  |*|");
                } else if (this.grid[line][column] == 2) {
					System.out.print("  |N|");
                } else if (this.grid[line][column] == 3) {
					System.out.print("  |X|");
                } else if (this.grid[line][column] == 4) {
					System.out.print("  |n|");
                }
            }
			System.out.println();
        }
    }

	// método de atulização do tabuleiro depois de cada jogada
    public void updateBoard(int[][] enemy, Player user) {
        if (user.hit(enemy)) {
            if (this.grid[user.shoot[0]][user.shoot[1]] == 2) {
                this.grid[user.shoot[0]][user.shoot[1]] = 3;
            } else {
                this.grid[user.shoot[0]][user.shoot[1]] = 1;
            }
        } else if (this.grid[user.shoot[0]][user.shoot[1]] == 2) {
            this.grid[user.shoot[0]][user.shoot[1]] = 4;
        } else {
            this.grid[user.shoot[0]][user.shoot[1]] = 0;
        }
    }
}
