import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicMezo implements Drawable {

	private Mezo mezo;
	
	private ImageIcon img=new ImageIcon("Mezo.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		mezo.l.setIcon(img);
	}

}
