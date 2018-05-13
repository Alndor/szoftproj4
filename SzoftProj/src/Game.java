import java.util.ArrayList;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	private Map currentMap=new Map();
	
	private View view;
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
		for(int i=0;i<currentMap.GetScores().size();i++)
			System.out.println(currentMap.GetScores().get(i));
		
	}
	
	
	//a j�t�k felad�s�ra szolg�l
	public void Concede() {
		
		currentMap.getInGame().remove(currentMap.getCurrent());
		//EndGame();
		
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
}
