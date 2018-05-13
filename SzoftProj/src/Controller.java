import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;

public class Controller {

	KeyEventHandler keh= new KeyEventHandler();
	MouseEventHandler meh= new MouseEventHandler();
	
	Controller(Game g) {
		keh.setGame(g);
		meh.setGame(g);
	}
	
	public KeyEventHandler getKeh() {
		return keh;
	}
	
	public void setKeh(KeyEventHandler k) {
		keh=k;
	}
	
	public MouseEventHandler getMeh() {
		return meh;
	}
	
	public void setMeh(MouseEventHandler k) {
		meh=k;
	}
	
	
}
