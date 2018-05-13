import java.awt.Button;
import java.util.ArrayList;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	private Map currentMap=new Map();
	
	private Button b1=new Button("olaj");
	private Button b2= new Button("mez");
	
	
	private View view;
	private Controller c= new Controller(this);
	
	public Controller getController() {
		return c;
	}
	
	public void setController(Controller co) {
		c=co;
	}
	
	
	//elinditja es futtatja a jatekot
	public void StartGame() {
		b1.addMouseListener(c.meh);
		b2.addMouseListener(c.meh);
		while(currentMap.getInGame().size()!=0) {
			currentMap.Running();
			
			
			
			
		}
		
		EndGame();
	}
	
	//véget vet a játéknak
	public void EndGame() {
		for(int i=0;i<currentMap.GetScores().size();i++)
			System.out.println(currentMap.GetScores().get(i).getName()+"\t"+currentMap.GetScores().get(i).GetPoints());
		System.exit(0);
	}
	
	
	//a játék feladására szolgál
	public void Concede() {
		
		currentMap.getInGame().remove(currentMap.getCurrent());
		//EndGame();
		
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
}
