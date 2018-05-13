import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicOlaj implements Drawable {

	private Olaj oj;
	
	private ImageIcon img=new ImageIcon("Olaj.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		oj.current.l.setIcon(img);
	}

}
