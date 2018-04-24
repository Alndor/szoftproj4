import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class Map {

	private HashMap<Coord, Mezo> map = new HashMap<Coord, Mezo>();
	private TreeMap<Coord, Mezo> palya = new TreeMap<Coord, Mezo>();
	
	
	private String name=new String();
	//a pontok sz�montart�s�ra szolg�l� lista
	private ArrayList<Dolgozo> scores = new ArrayList<>();
	private ArrayList<Dolgozo>	inGame= new ArrayList<>();
	private Dolgozo current= null;
	
	//meg�li az �pp soron l�v� dolgoz�t
	public void Kill(Dolgozo d) {
		if(inGame.contains(d))
			inGame.remove(d);
		if (current==d) 
			current=null;
		d.Kill();
		
	}
	
	//a j�t�k foly�s�t ir�ny�tja
	public void Running() {
		//temporary solution, m�g �gyse kell rendesen
		
		if (current==null && inGame.size()!=0)
		//inGame.add(current);
		current=inGame.get(0);
			
		
	}
	
	
	//megh�vja a pontot ad� f�ggv�ny�t az �pp soron l�v� j�t�kosnak
	public void AddPoints() {
	
		current.PointsGiven();	
		
	}
	
	//"ArrayList map" lek�rdez�se
	
	public TreeMap<Coord, Mezo> GetMezo() {
		return palya;
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
	
	public void Save(String s) {
		JsonArrayBuilder mezok = Json.createArrayBuilder();
		for (Entry<Coord, Mezo> entry :  palya.entrySet()) {
			JsonObject neighbour = Json.createObjectBuilder()
					.add("mezo", entry.getValue().Save())
					.add("x", entry.getKey().getX())
					.add("y", entry.getKey().getY())
					.build();
	        mezok.add(neighbour);
	    }
		
		JsonObject out = Json.createObjectBuilder()
				.add("mezok", mezok.build())
				.build();
		
		try {
			JsonWriter w = Json.createWriter(new FileWriter(s));
			w.writeObject(out);
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMezo(int x, int y, Mezo m) {
		map.put(new Coord(x, y), m);
	}
	
	public void addDolgozo(Dolgozo d) {
		inGame.add(0, d);
		scores.add(0, d);
	}
	
	public HashMap<Kapcsolo, Coord> kapcsok = new HashMap<Kapcsolo, Coord>();
	public void Load(String file) {
		JsonObject mapObject = null;
		
		try {
			InputStream fis;	
			fis = new FileInputStream(file);
			JsonReader reader = Json.createReader(fis);
			
			mapObject = reader.readObject();
			
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(mapObject == null)
			return;
		
		scores.clear();
		inGame.clear();
		map.clear();
		
		JsonArray plain = mapObject.getJsonArray("mezok");
		
		for(int i = 0; i < plain.size(); ++i) {
			Mezo m = new Mezo();
			m.Load(plain.getJsonObject(i).getJsonObject("mezo"), this);
			Coord c = new Coord(plain.getJsonObject(i).getInt("x"), plain.getJsonObject(i).getInt("y"));
			map.put(c, m);
		}
		
		SetTreeMap();
		createNeighbourhood();
		
		for (Entry<Kapcsolo, Coord> entry : kapcsok.entrySet()) {
			Coord c = palya.ceilingKey(entry.getValue());
			
			entry.getKey().SetLyukable(palya.get(c));
		}

	}
	
	public void createNeighbourhood() {
		for (Entry<Coord, Mezo> entry : palya.entrySet()) {
			
			int x = entry.getKey().getX();
			int y = entry.getKey().getY();
			
	        Coord c = new Coord(x, y);
	        Coord c2;
	       	        
	        entry.getValue().setMap(this);
	        
	        entry.getValue().SetNeighbor(Iranyok.DOWN, null);
	        entry.getValue().SetNeighbor(Iranyok.UP, null);
	        entry.getValue().SetNeighbor(Iranyok.LEFT, null);
	        entry.getValue().SetNeighbor(Iranyok.RIGHT, null);
	        
	        c.setX(x-1);
	        
	        c2 = palya.ceilingKey(c);
	        
	        if(c2 != null && c.equals(c2)) 
	        	entry.getValue().SetNeighbor(Iranyok.UP, palya.get(c2));
	        
	        c.setX(x+1);
	        
	        c2 = palya.ceilingKey(c);
	        
	        if(c2 != null && c.equals(c2)) 
	        	entry.getValue().SetNeighbor(Iranyok.DOWN, palya.get(c2));
	        
	        c.setX(x);
	        c.setY(y-1);
	        
	        c2 = palya.ceilingKey(c);
	        
	        if(c2 != null && c.equals(c2)) 
	        	entry.getValue().SetNeighbor(Iranyok.LEFT, palya.get(c2));
	        
	        c.setY(y+1);
	        
	        c2 = palya.ceilingKey(c);
	        
	        if(c2 != null && c.equals(c2)) 
	        	entry.getValue().SetNeighbor(Iranyok.RIGHT, palya.get(c2));
	    }
	}
	
	public void SetTreeMap() {
		for (Entry<Coord, Mezo> entry : map.entrySet()) {
	        palya.put(entry.getKey(), entry.getValue());
	    }
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

