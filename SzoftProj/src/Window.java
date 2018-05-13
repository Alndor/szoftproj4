import javax.swing.JFrame;

public class Window extends JFrame {
	private Game game;
	
	private Menu menu;
	
	public void SetGame(Game g) {
		//itt kene a map felallitasa, es utana a ciklus
		RunGame();
	}
	
	public void RunGame() {
		game.StartGame();
	}
}
