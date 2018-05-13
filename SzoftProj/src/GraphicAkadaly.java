import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicAkadaly implements Drawable {

	private Akadaly ak;
	
	private ImageIcon img=new ImageIcon("Akadaly.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		ak.current.l.setIcon(img);
	}
}
