import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JPanel;

public class View {
	private JPanel panel;
	private Map m;
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	
	View(Map ma){
		m=ma;
	}
	public void DrawAll() {
		for(Entry<Coord, Mezo> entry:m.GetMezo().entrySet()) {
			if (entry.getValue().GetThings().size()!=0)
				entry.getValue().GetThings().get(entry.getValue().GetThings().size()-1).dr.Draw();
			else if (entry.getValue().GetThings().size()==0) {
				entry.getValue().dr.Draw();
			}
		}
		
		
	}
	
	public void DologMoved(Dolgok d) {
		DrawAll();
	}
	
	/*public void DologRemoved(Dolgok d) {
		DrawAll();
	}*/
}
