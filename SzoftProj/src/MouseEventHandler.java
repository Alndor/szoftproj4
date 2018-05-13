

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler extends MouseAdapter {

	private Game game = null;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.paramString()=="olaj")
			game.getMap().getCurrent().PlaceItem(game.getMap().getCurrent().GetItems().get(0));
		else if(e.paramString()=="mez")
			game.getMap().getCurrent().PlaceItem(game.getMap().getCurrent().GetItems().get(1));
		
	}

	
	public void setGame(Game g) {
		game=g;
	}
	public Game getGame() {
		return game;
	}

}
