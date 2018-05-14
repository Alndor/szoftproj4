import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Map.Entry;

public class KeyEventHandler implements KeyListener{

	private Game game;
	@Override
	public void keyTyped(KeyEvent e) {
		game.getMap().Running();
		Iranyok i=Iranyok.NOTHING;
		if(e.getKeyChar()=='h') {
			/*if (game.getMap().getCurrent()==null)
				game.getMap().Running();*/
			game.getMap().getCurrent().GiveUp();;
			game.getMap().fireTableDataChanged();
			Ellenorzesek();
			return;
		}
		else if(e.getKeyChar()=='w')	i=Iranyok.UP;
		else if(e.getKeyChar()=='s') i=Iranyok.DOWN;
		else if(e.getKeyChar()=='a') i=Iranyok.LEFT;
		else if(e.getKeyChar()=='d') i=Iranyok.RIGHT;
		else if(e.getKeyChar()=='x') i=Iranyok.NOTHING;	
		else if(e.getKeyChar()=='p') {
			/*if(game.getMap().getCurrent()==null)
				game.getMap().Running();*/
			Mez mez = new Mez();
			game.getMap().getCurrent().PlaceItem(mez);
		}
		else if(e.getKeyChar()=='o') {
		/*	if(game.getMap().getCurrent()==null)
				game.getMap().Running();*/
			Olaj olaj = new Olaj();
			game.getMap().getCurrent().PlaceItem(olaj);
		}
		
		//game.getMap().Running();
		game.getMap().getCurrent().Move(i);
		game.getMap().fireTableDataChanged();
		Ellenorzesek();
		
		
	}

	private void Ellenorzesek() {
		if ((game.getMap().getInGame().size() == 0) && game.getMap().getCurrent() == null) {
			game.EndGame();
			return;
		}
	/*	else if((game.getMap().getKjsz() == 1) && (game.getMap().getCurrent() == null))
			game.EndGame();
		*/
		
		int cmsz = 0;
		
		for(Entry<Coord, Mezo> entry : game.getMap().GetMezo().entrySet()){
			ArrayList<Dolgok> dolgok = entry.getValue().GetThings();
			for(Dolgok dolog : dolgok)
				if(dolog.getName().equals("CelMezo"))
					++cmsz;
		}
		
		if(cmsz == 0) {
			game.Gratula();
			return;
		}
			
		int k = 0;
		
		for (Entry<Coord, Mezo> entry : game.getMap().GetMezo().entrySet()) {
			if (entry.getValue().VanMozgathatoLada()) {
				k++;
			}
		}
		
		if (k == 0) {
			game.Concede();
			return;
		}
		
		
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
