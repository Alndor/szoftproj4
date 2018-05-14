import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	private Map currentMap=new Map();
	
	//private View view;
	private Controller c= new Controller(this);
	
	
	//elind�tja a j�t�kot
	public void StartGame() {
		
		while(currentMap.getInGame().size()!=0) {
			currentMap.Running();
			
			
			
			
		}
		
		EndGame();
	}
	
	//v�get vet a j�t�knak
	public void EndGame() {
		/*for(int i=0;i<currentMap.GetScores().size();i++)
			System.out.println(currentMap.GetScores().get(i));*/
		
		Component frame1 = null;
		Component frame2 = null;
		String tmp = "";
		int i;
		for (i = 0; i < currentMap.GetScores().size(); i++) {
			tmp += (i+1) + ". J�t�kos: "+ currentMap.GetScores().get(i).GetPoints() + " pont" + "\n";
		}
		JOptionPane.showMessageDialog(frame1,
			    tmp,
			    "Pontsz�mok",
			    JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frame2,
			    "A j�t�knak v�ge!",
			    "Nembaj, majd legk�zelebb!",
			    JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	
	
	//a j�t�k befejez�se, ha nincs t�bb mozgathat� l�da
	public void Concede() {
		Component frame1 = null;
		Component frame2 = null;
		String tmp = "";
		int i;
		for (i = 0; i < currentMap.GetScores().size(); i++) {
			tmp += (i+1) + ". J�t�kos: "+ currentMap.GetScores().get(i).GetPoints() + " pont" + "\n";
		}
		JOptionPane.showMessageDialog(frame2,
			    tmp,
			    "Pontsz�mok",
			    JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frame1,
			    "A j�t�knak v�ge, mert nincs t�bb mozgathat� l�da!",
			    "Nembaj, majd legk�zelebb!",
			    JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	
	
	//kiv�laszthatjuk a p�ly�t
	public Map ChooseMap() {
		for(int i=0;i<maps.size();i++) {
			System.out.println(i+1+".\t"+maps.get(i).getName());
		}
		
		//temporary solution, m�g �gyse kell
		currentMap=maps.get(0);
		return maps.get(0);
	}
	
	//"ArrayList maps" lek�rdez�se
	
	public ArrayList<Map> GetMaps() {
		return maps;
	}
	
	public Map getMap() {
		return currentMap;
	}
	
	public void setMap(Map m) {
		currentMap=m;
	}
	
	//"ArrayList maps" be�ll�t�sa
	
	public void SetMaps(ArrayList<Map> tmp) {
		maps = tmp;
	}
	
	public Controller getController(){
		return c;
	}
}
