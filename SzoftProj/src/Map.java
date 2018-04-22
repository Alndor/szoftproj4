import java.util.ArrayList;

public class Map {
	
	
	private String name=new String();
	private ArrayList<Mezo> map = new ArrayList<>();
	//a pontok számontartására szolgáló lista
	private ArrayList<Dolgozo> scores = new ArrayList<>();
	private ArrayList<Dolgozo>	inGame= new ArrayList<>();
	private Dolgozo current= new Dolgozo();
	
	//megöli az épp soron lévõ dolgozót
	public void Kill(Dolgozo d) {
		if(inGame.contains(d))
			inGame.remove(d);
		if (current==d) 
			current=null;
		
	}
	
	//a játék folyását irányítja
	public void Running() {
		//temporary solution, még úgyse kell
		
		if (current!=null)
		inGame.add(current);
		current=inGame.remove(0);
			
		
	}
	
	
	//meghívja a pontot adó függvényét az épp soron lévõ játékosnak
	public void AddPoints() {
	
		current.PointsGiven();	
		
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
	
	public Dolgozo getCurrent() {
		return current;
	}
	
	public ArrayList<Dolgozo> getInGame(){
		return inGame;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name=s;
	}
}
