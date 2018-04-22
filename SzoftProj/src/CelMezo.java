import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class CelMezo extends Dolgok {

	protected Map m = new Map();
	
	//amennyiben dolgozó lép rá nem történik semmi
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[celmezo].HitByDolgozo(d, i)");
		System.out.println("<\t<-[celmezo].HitByDolgozo(d, i)");
	}

	//amennyiben ládát tolunk rá, pontot kapunk
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[celmezo].HitByLada(l, i)");
		
		Score(l);
		
		System.out.println("<\t<-[celmezo].HitByLada(l, i)");
	}
	
	//pontot kapunk és a ládát megsemmisítjük,  helyére falat emelünk
	public void Score(Lada l) {
		System.out.println("<\t->[celmezo].Score(l)");
		
		m.AddPoints();
		l.Smashed();
		
		System.out.println("<\t<-[celmezo].Score(l)");
	}
	
	//"Map m" lekérdezése
	
	public Map GetMap() {
		return m;
	}
	
	//"Map m" beállítása
	
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
	public JsonObject Saved() {
		JsonObject value = Json.createObjectBuilder()
				.add("map", m.toString())
				.add("weight", String.valueOf(weight))
				.build();
		JsonObject out = Json.createObjectBuilder()
				.add("celmezo", value)
				.build();
		return out;
	}
}
