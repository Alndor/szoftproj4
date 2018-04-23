import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class CelMezo extends Dolgok {

	protected Map m = new Map();
	private String name = "CelMezo";
	//amennyiben dolgoz� l�p r� nem t�rt�nik semmi
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[celmezo].HitByDolgozo(d, i)");
		//System.out.println("<\t<-[celmezo].HitByDolgozo(d, i)");
	}

	//amennyiben l�d�t tolunk r�, pontot kapunk
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[celmezo].HitByLada(l, i)");
		
		Score(l);
		
		//System.out.println("<\t<-[celmezo].HitByLada(l, i)");
	}
	
	//pontot kapunk �s a l�d�t megsemmis�tj�k,  hely�re falat emel�nk
	public void Score(Lada l) {
		//System.out.println("<\t->[celmezo].Score(l)");
		
		m.AddPoints();
		l.Smashed();
		
		//System.out.println("<\t<-[celmezo].Score(l)");
	}
	
	//"Map m" lek�rdez�se
	
	public Map GetMap() {
		return m;
	}
	
	//"Map m" be�ll�t�sa
	
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
	
	public String getName() {
		return name;
	}

}
