import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

import javax.json.JsonArray;

public class Map {

	private HashMap<Coord, Mezo> map = new HashMap<Coord, Mezo>();
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
	
	public HashMap<Coord, Mezo> GetMezo() {
		return map;
	}
	
	//"ArrayList map" be�ll�t�sa
	
	public void SetMezo(HashMap<Coord, Mezo> tmp) {
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
	
	public String getCoord(Mezo m) {
		Coord tmp = getKeyByValue(map, m);
		return tmp.getCoord();
	}
	
	public static Coord getKeyByValue(HashMap<Coord, Mezo> map, Mezo value) {
	    for (Entry<Coord, Mezo> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
	private static class Coord {
		int x; int y;
	    public Coord(int x, int y) {
	       this.x = x;
	       this.y = y;
	    }
	    public String getCoord() {
	    	return new String("("+String.valueOf(x)+","+String.valueOf(y)+")");
	    }
	    public int getX() {
	    	return x;
	    }
	    public int getY() {
	    	return y;
	    }
	}
	
	/*public void Save() {
		for (Entry<Coord, Mezo> entry : map.entrySet()) {
			
		}
	}*/
}

