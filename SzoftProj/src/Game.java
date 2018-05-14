import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	private Map currentMap=new Map();
	
	//private View view;
	private Controller c= new Controller(this);
	
	
	//elindítja a játékot
	public void StartGame() {
		
		while(currentMap.getInGame().size()!=0) {
			currentMap.Running();
			
			
			
			
		}
		
		EndGame();
	}
	
	//véget vet a játéknak
	public void EndGame() {
		/*for(int i=0;i<currentMap.GetScores().size();i++)
			System.out.println(currentMap.GetScores().get(i));*/
		
		Component frame1 = null;
		Component frame2 = null;
		String tmp = "";
		int i;
		for (i = 0; i < currentMap.GetScores().size(); i++) {
			tmp += (i+1) + ". Játékos: "+ currentMap.GetScores().get(i).GetPoints() + " pont" + "\n";
		}
		JOptionPane.showMessageDialog(frame1,
			    tmp,
			    "Pontszámok",
			    JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frame2,
			    "A játéknak vége!",
			    "Nembaj, majd legközelebb!",
			    JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	
	
	//a játék befejezése, ha nincs több mozgatható láda
	public void Concede() {
		Component frame1 = null;
		Component frame2 = null;
		String tmp = "";
		int i;
		for (i = 0; i < currentMap.GetScores().size(); i++) {
			tmp += (i+1) + ". Játékos: "+ currentMap.GetScores().get(i).GetPoints() + " pont" + "\n";
		}
		JOptionPane.showMessageDialog(frame2,
			    tmp,
			    "Pontszámok",
			    JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frame1,
			    "A játéknak vége, mert nincs több mozgatható láda!",
			    "Nembaj, majd legközelebb!",
			    JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	
	
	//kiválaszthatjuk a pályát
	public Map ChooseMap() {
		for(int i=0;i<maps.size();i++) {
			System.out.println(i+1+".\t"+maps.get(i).getName());
		}
		
		//temporary solution, még úgyse kell
		currentMap=maps.get(0);
		return maps.get(0);
	}
	
	//"ArrayList maps" lekérdezése
	
	public ArrayList<Map> GetMaps() {
		return maps;
	}
	
	public Map getMap() {
		return currentMap;
	}
	
	public void setMap(Map m) {
		currentMap=m;
	}
	
	//"ArrayList maps" beállítása
	
	public void SetMaps(ArrayList<Map> tmp) {
		maps = tmp;
	}
	
	public Controller getController(){
		return c;
	}
}
