import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Player {
    // variáveis de inicialização do jogador
	Board board;
    Ships ships;
    boolean isPlayer;


    int[] shoot = new int[2];
    int hits;
    char[] lineArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

	// método de inicialização do jogador
    public Player(Board board, Ships ships, boolean isPlayer) {
        this.board = board;
        this.ships = ships;
        this.isPlayer = isPlayer;
    }

	// método para imprimir Grid do jogador ativo
    public void showGrid() {
        this.board.showBoard(this.isPlayer);
    }

	// posicionar navios do usuário
    public void placeShips() {
		this.ships.startPlayerShips(this.board.grid);
    }
	
	// posicionar navios do inimigo
    public void placeComputerShips() {
		this.ships.startComputerShips(this.board.grid);
    }
	
	// atirar no aliado
    public void userShoot() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escolha uma posição para atirar");
        System.out.printf("Digite a linha (de 'A' a 'J'): ");
        this.shoot[0] = (new String(this.lineArray)).indexOf(sc.next().toUpperCase(Locale.ROOT));
		while (this.shoot[0] < 0 || this.shoot[0] > 9) {
			System.out.printf("Inválido!\nDigite a linha a (de 'A' a 'J'): ");
        	this.shoot[0] = (new String(this.lineArray)).indexOf(sc.next().toUpperCase(Locale.ROOT));
		}
		System.out.printf("Digite a coluna (de 1 a 10): ");
        this.shoot[1] = sc.nextInt() - 1;
		while (this.shoot[0] < 0 || this.shoot[0] > 9) {
			System.out.printf("Inválido!\nDigite a coluna (de 1 a 10): ");
        	this.shoot[1] = sc.nextInt() - 1;
		}
    }
	
	// atirar no inimigo
    public void enemyShoot() {
        Random random = new Random();
        this.shoot[0] = random.nextInt(10);
        this.shoot[1] = random.nextInt(10);
    }

    // função para dar o ultimo tiro certeiro, apenas para fins avaliativos
    public void lastHist(int[][] enemyShips) {
        this.shoot[0] = enemyShips[0][0];
        this.shoot[1] = enemyShips[0][1];
    }

	// imprimir a mensagem se o usuário acertar o tiro
    public boolean hit(int[][] enemyShips) {
        for (int[] ints : enemyShips) {
            if (this.shoot[0] == ints[0] && this.shoot[1] == ints[1]) {
                System.out.printf("\nVocê acertou o inimigo na posição (%s,%d)!\n", this.lineArray[this.shoot[0]], this.shoot[1] + 1);
                return true;
            }
        }
        return false;
    }
}
