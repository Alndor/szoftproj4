import javax.swing.ImageIcon;

import com.sun.prism.Image;

public class GraphicLyuk implements Drawable {

	private Lyuk ly;
	
	private ImageIcon img=new ImageIcon("Lyuk.gif");
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		ly.current.l.setIcon(img);
	}
}
