import java.util.ArrayList;

public class Game {

	private ArrayList<Map> maps = new ArrayList<>();
	
	
	//elindítja a játékot
	public void StartGame() {
		System.out.println(">\t->[game].StartGame()");
			
		System.out.println("<\t<-[game].StartGame()");
	}
	
	//véget vet a játéknak
	public void EndGame() {
		System.out.println(">\t->[game].EndGame()");
	 
		
		System.out.println("<\t<-[game].EndGame()");
	}
	
	
	//a játék feladására szolgál
	public void Concede() {
		System.out.println(">\t->[game].EndGame()");
		
		EndGame();
		
		System.out.println("<\t<-[game].EndGame()");
	}
	
	
	//kiválaszthatjuk a pályát
	public void ChooseMap() {
		System.out.println(">\t->[game].ChooseMap()");
		
		//Gondolom itt tolti fel a mapot
		
		System.out.println("<\t<-[game].ChooseMap()");
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
