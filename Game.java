import java.util.Arrays;

public class Game {
    // variáveis de jogador e inimigo
	Player user;
    Player enemy;

	// inicializar jogo com jogadores
    public Game(Player user, Player enemy) {
        this.user = user;
        this.enemy = enemy;
    }

	// método de inicio de jogo 
    public void play() {
		// inicializar tabuleiros
        this.user.board.startBoard();
        this.enemy.board.startBoard();

		// mostrar tabuleiro do usuário e posicionar navios
        this.user.showGrid();
        this.user.placeShips();

		// posicionar randomicamente navios do inimigo
        this.enemy.placeComputerShips();
        System.out.println(Arrays.deepToString(this.enemy.ships.ships));

		// Laço para refazer jogada até um dos participantes terem 10 acertos a navios adversários
        while (true) {
            this.user.showGrid();

            this.user.userShoot();

            if (this.user.hit(this.enemy.ships.ships)) {
                ++this.user.hits;
            }
            this.user.board.updateBoard(this.enemy.ships.ships, this.user);

            instaWin();
            this.enemy.enemyShoot();
            if (this.enemy.hit(this.user.ships.ships)) {
                ++this.enemy.hits;
            }

            this.enemy.board.updateBoard(this.user.ships.ships, this.enemy);
            if (this.user.hits == 10) {
                System.out.println("VOCÊ VENCEU O JOGO");
                break;
            }

            if (this.enemy.hits == 10) {
                System.out.println("O INIMIGO VENCEU O JOGO");
                break;
            }
        }

		// Mostrar grid dos dois jogadores ao final
        this.user.showGrid();
        this.enemy.showGrid();
    }
    // Metodo para a maquina ganhar em uma rodada, apenas para fins avaliativos
    private void instaWin() {
        this.enemy.hits = 9;
        this.enemy.lastHist(this.user.ships.ships);
        if (this.enemy.hit(this.user.ships.ships)) {
            ++this.enemy.hits;
        }
        this.enemy.board.updateBoard(this.user.ships.ships, this.enemy);
    }
}