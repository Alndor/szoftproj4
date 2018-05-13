import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventHandler extends KeyAdapter{

	private Game game= null;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		Iranyok i=Iranyok.NOTHING;
		if(e.getKeyChar()=='w')	i=Iranyok.UP;
		else if(e.getKeyChar()=='s') i=Iranyok.DOWN;
		else if(e.getKeyChar()=='a') i=Iranyok.LEFT;
		else if(e.getKeyChar()=='d') i=Iranyok.RIGHT;
		else if(e.getKeyChar()=='x') i=Iranyok.NOTHING;
		game.getMap().getCurrent().Move(i);
	}



	public void setGame(Game g) {
		game=g;
	}
	public Game getGame() {
		return game;
	}
}
