import java.util.ArrayList;

public class Map {

	private ArrayList<Mezo> map = new ArrayList<>();
	//a pontok sz�montart�s�ra szolg�l� lista
	private ArrayList<Dolgozo> scores = new ArrayList<>();
	
	
	//meg�li az �pp soron l�v� dolgoz�t
	public void Kill() {
		System.out.println(">\t->[map].Kill()");
		System.out.println("<\t-<[map].Kill()");
	}
	
	//a j�t�k foly�s�t ir�ny�tja
	public void Running() {
		System.out.println(">\t->[map].Running()");
		
		while(!scores.isEmpty()) {
			for(Dolgozo d : scores) {
			}
		}
		
		System.out.println("<\t-<[map].Running()");
	}
	
	
	//megh�vja a pontot ad� f�ggv�ny�t az �pp soron l�v� j�t�kosnak
	public void AddPoints() {
		System.out.println(">\t->[map].AddPoints()");
		

		
		System.out.println("<\t-<[map].AddPoints()");
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
}
