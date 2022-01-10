public class Tabuleiro {
    int[][] grade = new int[10][10];
    String[] colunasArray = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void inicializaTabuleiro() {
        for (int linha = 0; linha < 10; ++linha) {
            for (int coluna = 0; coluna < 10; ++coluna) {
                this.grade[linha][coluna] = -1;
            }
        }

    }

    public void mostraTabuleiro(boolean jogador) {
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

        for (int linha = 0; linha < 10; ++linha) {
            System.out.print(this.colunasArray[linha]);

            for (int coluna = 0; coluna < 10; ++coluna) {
                if (this.grade[linha][coluna] == -1) {
                    System.out.print("\t| |");
                } else if (this.grade[linha][coluna] == 0) {
                    System.out.print("\t|-|");
                } else if (this.grade[linha][coluna] == 1) {
                    System.out.print("\t|*|");
                } else if (this.grade[linha][coluna] == 2) {
                    System.out.print("\t|N|");
                } else if (this.grade[linha][coluna] == 3) {
                    System.out.print("\t|X|");
                } else if (this.grade[linha][coluna] == 4) {
                    System.out.print("\t|n|");
                }
            }

            System.out.println();
        }

    }

    public void alteraTabuleiro(int[][] naviosAdversario, Jogador jogador) {
        if (jogador.acertou(naviosAdversario)) {
            if (this.grade[jogador.tiro[0]][jogador.tiro[1]] == 2) {
                this.grade[jogador.tiro[0]][jogador.tiro[1]] = 3;
            } else {
                this.grade[jogador.tiro[0]][jogador.tiro[1]] = 1;
            }
        } else if (this.grade[jogador.tiro[0]][jogador.tiro[1]] == 2) {
            this.grade[jogador.tiro[0]][jogador.tiro[1]] = 4;
        } else {
            this.grade[jogador.tiro[0]][jogador.tiro[1]] = 0;
        }

    }
}