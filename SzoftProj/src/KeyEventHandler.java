import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler implements KeyListener{

	private Game game/*= new Game()*/;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		Iranyok i=Iranyok.NOTHING;
		if(e.getKeyChar()=='w')	i=Iranyok.UP;
		else if(e.getKeyChar()=='s') i=Iranyok.DOWN;
		else if(e.getKeyChar()=='a') i=Iranyok.LEFT;
		else if(e.getKeyChar()=='d') i=Iranyok.RIGHT;
		else if(e.getKeyChar()=='x') i=Iranyok.NOTHING;
		game.getMap().Running();
		game.getMap().getCurrent().Move(i);
		game.getMap().fireTableDataChanged();
	}



	public void setGame(Game g) {
		game=g;
	}
	public Game getGame() {
		return game;
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
