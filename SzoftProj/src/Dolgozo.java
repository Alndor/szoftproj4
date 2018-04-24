import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;

//a j�t�kosok �ltal ir�ny�tott dolgoz�k oszt�lya
public class Dolgozo extends Dolgok {
	
	private double strength=14;
	private String name= "Dolgozo";
	//az adott j�t�kos pontjait t�rol� v�ltoz�
	private int points;
	private Iranyok irany = null;
	//valtozo, ami szamon tartja, hogy sikerult-e a mozgatas
	protected boolean refused = false;
	//valtozo, ami szamon tartja, hogy el-e a dolgozo
	protected boolean dead = false;
	//a megfelel� kommunik�l�shoz haszn�lt v�ltoz�k
	private Map m = new Map();
	private Game g = new Game();
	//A dolgoz� letehet� Itemjeinek gy�jtem�nye
	private ArrayList<Item> items = new ArrayList<>();
	
	//a param�ter�l kapott Dologhoz hozz��ti a dolgoz�t
	@Override
	public void CollideWith(Dolgok d) {
		// TODO Auto-generated method stub
	//	System.out.println(">\t->[dolgozo].CollideWith(d)");
		
		d.HitByDolgozo(this, irany);
		
		//System.out.println("<\t<-[dolgozo].CollideWith(d)");
	}

	//a param�ter�l kapott dolgoz�t egy megfelel� ir�nyba �ti
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[dolgozo].HitByDolgozo(d, i)");
		//dolgoz� nem l�phet dolgoz�ra
		d.Refuse();
		//System.out.println("<\t<-[dolgozo].HitByDolgozo(d, i)");
	}

	//a param�ter�l kapott l�da egy megfelel� ir�nyba �ti
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[dolgozo].HitByLada(l, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		int weight=0;
		weight+=current.CountWeight(i);
		if (weight>strength) refused=true;
		if(refused!=true)
			nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a dolgoz�t nem lehet a k�vetkez� mez�re tolni, meghal
			m.Kill(this);
			return;
		}
		else
			nextMezo.Accept(this);
		
		
		//System.out.println("<\t<-[dolgozo].HitByLada(l, i)");
	}
	
	
	//a j�t�kos mozgatja a dolgoz�t egy ir�nyba, vagy d�nthet �gy is, hogy nem mozdul a k�rben
	public void Move(Iranyok i) {
		//System.out.println(">\t->[dolgozo].Move(i)");
		if(i.getDir()!='x') {
				Mezo nextMezo = current.GetNeighbor(i);
				if(nextMezo == null)
					return;
				int weight=0;
				weight+=current.CountWeight(i);
				if (weight>strength) refused=true;
				if(refused!=true)
				nextMezo.GetDolgok(this);
				
				current.Remove(this);
				if(dead) {
					current = null;
					return;
				}
				
				//amennyiben a dolgoz� nem l�phet a k�vetkez� mez�re az aktu�lis mez�n marad
				if(refused) {
					current.Accept(this);
					refused=false;
				}		
				else
					nextMezo.Accept(this);
		}
		else current.Accept(this);
		
		
		//System.out.println("<\t<-[dolgozo].Move(i)");
	}
	
	
	//n�veli a dolgoz� pontjainak sz�m�t egyel, ha sikeresen a hely�re tolt egy l�d�t, akkor h�v�dik meg
	public void PointsGiven(){
		//System.out.println(">\t->[dolgozo].PointsGiven()");
		
		points++;		
		
		//System.out.println("<\t<-[dolgozo].PointsGiven()");
	}
	
	//Megoli a dolgozot
	
	public void Kill() {
		dead = true;
	}
	
	//a j�t�kos feladhatja a j�t�kot, ha �gy �rzi, hogy m�r nem vezet sehova
	public void GiveUp() {
		//System.out.println(">\t->[dolgozo].GiveUp()");
		
		g.Concede();
		
		//System.out.println("<\t<-[dolgozo].GiveUp()");
	}
	
	
	//amennyiben dolgoz� l�pne dolgoz�ra ez a f�ggv�ny h�v�dik meg, ami nem engedi a l�p�st
	public void Refuse() {
		
		refused = true;
		
		
	}
	
	//Item lerak�sa
	public void PlaceItem(Item it){
		current.Accept(it);
	}
	
	//"int points" lek�rdez�se
	
	public int GetPoints() {
		return points;
	}
	
	//"int points" be�ll�t�sa
	
	public void SetPoints(int tmp) {
		points = tmp;
	}
	
	//"Iranyok irany" lek�rdez�se
	
	public Iranyok GetIrany() {
		return irany;
	}
	
	//"Iranyok irany" be�ll�t�sa
	
	public void SetIrany(Iranyok tmp) {
		irany = tmp;
	}
	
	//"Map m" lek�rdez�se
	
	public Map GetMap() {
		return m;
	}
		
	//"Map m" be�ll�t�sa
		
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
	//"Game g" lek�rdez�se
	
	public Game GetGame() {
		return g;
	}
		
	//"Game g" be�ll�t�sa
		
	public void SetGame(Game tmp) {
		g = tmp;
	}
	
	//"ArrayList items" lek�rdez�se
	
	public ArrayList<Item> GetItems(){
		return items;
	}
	
	//"ArrayList items" bea�llyt�sa
	
	public void SetItems(ArrayList<Item> tmp){
		items = tmp;
	}
	
	public JsonObject Save()
	{
		JsonObject out = Json.createObjectBuilder()
				.add("type", "dolgozo")
				.add("points", points)
				.add("weight", weight)
				.add("strength", strength)
				.add("itemek", saveItems())
				.build();

		return out;
	}
	
	private JsonArray saveItems() {
		JsonArrayBuilder itemek = Json.createArrayBuilder();
		
		if(items.isEmpty())
			return itemek.add("").build();
		itemek.add("nemures");
		for(Item item : items) {
			itemek.add(item.Save());
		}
		
		return itemek.build();
	}

	@Override
	public void Load(JsonObject ob, Map map) {
		weight = ob.getInt("weight");
		strength = ob.getInt("strength");
		points = ob.getInt("points");
		m = map;
		map.addDolgozo(this);
		JsonArray itemek = ob.getJsonArray("itemek");
		if(!itemek.getString(0).equals(""))
			for(int i = 1; i < itemek.size(); ++i) {
				JsonObject item = itemek.getJsonObject(i);
				if("mez".equals(item.getString("type"))){
					Mez mez = new Mez();
					mez.Load(item, map);
					items.add(mez);
				}
				else if("olaj".equals(item.getString("type"))) {
					Olaj olaj = new Olaj();
					olaj.Load(item, map);
					items.add(olaj);
				}
			}
	}
	
	public String getName() {
		return name;
	}

	public void setStrength(double s) {
		strength=s;
	}
	
	public double getStrength() {
		return strength;
	}
}
