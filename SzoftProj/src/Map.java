import java.util.ArrayList;

public class Map {

	private ArrayList<Mezo> map = new ArrayList<>();
	//a pontok számontartására szolgáló lista
	private ArrayList<Dolgozo> scores = new ArrayList<>();
	
	
	//megöli az épp soron lévõ dolgozót
	public void Kill() {
		System.out.println(">\t->[map].Kill()");
		System.out.println("<\t-<[map].Kill()");
	}
	
	//a játék folyását irányítja
	public void Running() {
		System.out.println(">\t->[map].Running()");
		
		while(!scores.isEmpty()) {
			for(Dolgozo d : scores) {
			}
		}
		
		System.out.println("<\t-<[map].Running()");
	}
	
	
	//meghívja a pontot adó függvényét az épp soron lévõ játékosnak
	public void AddPoints() {
		System.out.println(">\t->[map].AddPoints()");
		

		
		System.out.println("<\t-<[map].AddPoints()");
	}
	
	//"ArrayList map" lekérdezése
	
	public ArrayList<Mezo> GetMezo() {
		return map;
	}
	
	//"ArrayList map" beállítása
	
	public void SetMezo(ArrayList<Mezo> tmp) {
		map = tmp;
	}
	
	//"ArrayList scores" lekérdezése
	
	public ArrayList<Dolgozo> GetScores() {
		return scores;
	}
	
	//"ArrayList scores" beállítása
	
	public void SetScores(ArrayList<Dolgozo> tmp) {
		scores = tmp;
	}
}
