import javax.swing.ImageIcon;

import javafx.scene.image.Image;

public class GraphicCelmezo implements Drawable {

	private CelMezo cm;
	
	private ImageIcon img=new ImageIcon("Celmezo.gif");
	
	@Override
	public void Draw() {
		cm.current.l.setIcon(img);
	}
}
