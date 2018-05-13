import javax.swing.ImageIcon;

import javafx.scene.image.Image;

public class GraphicDolgozo implements Drawable {

	private Dolgozo dg;
	
	private ImageIcon img=new ImageIcon("Dolgozo.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		dg.current.l.setIcon(img);
	}
}
