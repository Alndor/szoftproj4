import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Kapcsolo extends Dolgok {
	
	Kapcsolo(){
		dr= new GraphicKapcsolo();

	}
	
	//azt a mezõt képviseli, amelyre a lyuk felkerülhet
	private Mezo lyukable = new Mezo();
	//a felrakható lyuk
	private Lyuk segedlyuk = new Lyuk();
	//protected boolean open = false;
	private String name="Kapcsolo";
	public String getName() {
		return name;
	}
	
	//ha dolgozó lép rá, megvizsgálja a váltó állását, és az alapján alakít rajta
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		
		SwitchD();
	}

	//ha láda tolódik rá, megvizsgálja a váltó állását, és az alapján alakít rajta
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		
		SwitchL();
	}
	
	//megvizsgálja a mezõn lévõ Dolgokat, és aszerint jár el, hogy tartalmazta-e a lyukat
	public void SwitchL() {
		
		//csak akkor teszünk bele, ha még nem tartalmazza
		
		if(!lyukable.GetThings().contains(segedlyuk)) {
			for(Dolgok dolog : lyukable.GetThings())
				if(dolog.getName().equals("Dolgozo")) {
					Dolgozo d = (Dolgozo)dolog;
					d.Kill();
				}
			lyukable.GetThings().clear();
			lyukable.Accept(segedlyuk);
		}
	}
	
	//megvizsgálja a mezõn lévõ Dolgokat, és aszerint jár el, hogy tartalmazta-e a lyukat
	public void SwitchD() {
  	
	  	//ha van rajta a bizonyos lyuk, akkor leszedjük róla, mivel Dolgozó lépett a kapcsolóra
	  	
	  	if(lyukable.GetThings() != null && lyukable.GetThings().contains(segedlyuk)) {
	  		lyukable.Remove(segedlyuk);
	  	}
	}
	
	//"Mezo lyukable" lekérdezése
	
	public Mezo GetLyukable() {
		return lyukable;
	}
	
	//"Mezo lyukable" beállítása
	
	public void SetLyukable(Mezo tmp) {
		lyukable = tmp;
	}
	
	//"Lyuk segedlyuk" lekérdezése
	
	public Lyuk GetSegedLyuk() {
		return segedlyuk;
	}
	
	//"Lyuk segedlyuk" beállítása
	
	public void SetSegedLyuk(Lyuk tmp) {
		segedlyuk = tmp;
	}
	
	public JsonObject Save() {
		JsonObject out = Json.createObjectBuilder()
				.add("type", "kapcsolo")
				.add("lyukable", lyukable.getPosition())
				.add("segedlyuk", segedlyuk.Save())
				.add("weight", weight)
				.build();

		return out;
	}

	@Override
	public void Load(JsonObject ob, Map map) {
		weight = ob.getInt("weight");
		Lyuk l = new Lyuk();
		l.Load(ob.getJsonObject("segedlyuk"), map);
		segedlyuk = l;
		String pos = ob.getString("lyukable");
		String[] tmp = pos.split(",");
		int x = tmp[0].charAt(1) - '0';
		int y = tmp[1].charAt(0) - '0';
		Coord coord = new Coord(x, y);
		
		map.kapcsok.put(this, coord);
		
	}
}
