public class Main {
    public static void main(String[] args) {
		// inicialização dos tabuleiros
        Board boardUser = new Board();
        Board boardEnemy = new Board();

		// inicialização dos navios 
        Ships shipsUser = new Ships();
        Ships shipsEnemy = new Ships();

		// inicialização dos jogadores
        Player user = new Player(boardUser, shipsUser, true);
        Player enemy = new Player(boardEnemy, shipsEnemy, false);

		// inicialização do jogo
        Game battleship = new Game(user, enemy);

		// start!
        battleship.play();
    }
}
