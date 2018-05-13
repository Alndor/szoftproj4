import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicMez implements Drawable {

	private Mez mez;
	
	private ImageIcon img=new ImageIcon("Mez.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		mez.current.l.setIcon(img);
	}

}
