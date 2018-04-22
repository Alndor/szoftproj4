import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Lyuk extends Dolgok {
	protected Map m = new Map();
	
	//amennyiben dolgozó lép a lyukra, meghívja az annak megölésére szolgáló függvényt
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[lyuk].HitByDolgozo(d, i)");
		
		m.Kill();
		
		System.out.println("<\t<-[lyuk].HitByDolgozo(d, i)");
	}

	//amennyiben láda lép a lyukra, meghívja az annak megsemmisítését elõidézõ függvényt
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[lyuk].HitByLada(l, i)");
		
		l.Smashed();
		
		System.out.println("<\t<-[lyuk].HitByLada(l, i)");
	}
	
	//"Map m" lekérdezése
	
	public Map GetMap() {
		return m;
	}
			
	//"Map m" beállítása
			
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
//	public void Save()
//	{
//		JsonObject value = Json.createObjectBuilder()
//				.add("map", m.toString())
//				.build();
//		JsonObject out = Json.createObjectBuilder()
//				.add("lyuk", value)
//				.add("weight", String.valueOf(weight))
//				.build();
//		try {
//			JsonWriter w = Json.createWriter(new FileWriter("lyuk.txt"));
//			w.writeObject(out);
//			w.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public JsonObject Saved() {
		JsonObject value = Json.createObjectBuilder()
				.add("map", m.toString())
				.build();
		JsonObject out = Json.createObjectBuilder()
				.add("lyuk", value)
				.add("weight", String.valueOf(weight))
				.build();
		return out;
	}
}
