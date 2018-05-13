import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicLada implements Drawable {

	private Lada ld;
	
	private ImageIcon img=new ImageIcon("Lada.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		ld.current.l.setIcon(img);
	}
}
