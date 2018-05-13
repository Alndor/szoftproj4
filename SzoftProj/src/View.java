import java.util.ArrayList;

import javax.swing.JPanel;

public class View {
	private JPanel panel;
	
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	public void DrawAll() {
		for(Drawable d : drawables) {
			d.Draw();
		}
	}
	
	public void DologMoved(Dolgok d) {
		DrawAll();
	}
	
	public void DologRemoved(Dolgok d) {
		DrawAll();
	}
}
