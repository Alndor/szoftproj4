import java.util.ArrayList;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	private Map currentMap=new Map();
	
	private View view;
	
	
	
	//elindítja a játékot
	public void StartGame() {
		
		while(currentMap.getInGame().size()!=0) {
			currentMap.Running();
						
			
			
			
		}
		
		EndGame();
	}
	
	//véget vet a játéknak
	public void EndGame() {
		for(int i=0;i<currentMap.GetScores().size();i++)
			System.out.println(currentMap.GetScores().get(i));
		
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
		return maps.get(0);
	}
	
	//"ArrayList maps" lekérdezése
	
	public ArrayList<Map> GetMaps() {
		return maps;
	}
	
	//"ArrayList maps" beállítása
	
	public void SetMaps(ArrayList<Map> tmp) {
		maps = tmp;
	}
}
