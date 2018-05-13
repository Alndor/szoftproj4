import javax.swing.ImageIcon;

import javafx.scene.image.Image;

public class GraphicKapcsolo implements Drawable {

	private Kapcsolo kp;
	
	private ImageIcon img=new ImageIcon("Kapcsolo.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		kp.current.l.setIcon(img);
	}
}
