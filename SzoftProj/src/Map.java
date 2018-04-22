import java.util.ArrayList;

public class Map {
	
	
	private String name=new String();
	private ArrayList<Mezo> map = new ArrayList<>();
	//a pontok sz�montart�s�ra szolg�l� lista
	private ArrayList<Dolgozo> scores = new ArrayList<>();
	private ArrayList<Dolgozo>	inGame= new ArrayList<>();
	private Dolgozo current= new Dolgozo();
	
	//meg�li az �pp soron l�v� dolgoz�t
	public void Kill(Dolgozo d) {
		if(inGame.contains(d))
			inGame.remove(d);
		if (current==d) 
			current=null;
		
	}
	
	//a j�t�k foly�s�t ir�ny�tja
	public void Running() {
		//temporary solution, m�g �gyse kell
		
		if (current!=null)
		inGame.add(current);
		current=inGame.remove(0);
			
		
	}
	
	
	//megh�vja a pontot ad� f�ggv�ny�t az �pp soron l�v� j�t�kosnak
	public void AddPoints() {
	
		current.PointsGiven();	
		
	}
	
	//"ArrayList map" lek�rdez�se
	
	public ArrayList<Mezo> GetMezo() {
		return map;
	}
	
	//"ArrayList map" be�ll�t�sa
	
	public void SetMezo(ArrayList<Mezo> tmp) {
		map = tmp;
	}
	
	//"ArrayList scores" lek�rdez�se
	
	public ArrayList<Dolgozo> GetScores() {
		return scores;
	}
	
	//"ArrayList scores" be�ll�t�sa
	
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
