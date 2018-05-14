import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;



public class Lyuk extends Dolgok {
	
	Lyuk(){
	//	dr= new GraphicLyuk();
	}
	
	protected Map m = new Map();
	private String name = "Lyuk";
	
	
	//amennyiben dolgoz� l�p a lyukra, megh�vja az annak meg�l�s�re szolg�l� f�ggv�nyt
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lyuk].HitByDolgozo(d, i)");
		
		m.Kill(d);
		
		//System.out.println("<\t<-[lyuk].HitByDolgozo(d, i)");
	}

	//amennyiben l�da l�p a lyukra, megh�vja az annak megsemmis�t�s�t el�id�z� f�ggv�nyt
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lyuk].HitByLada(l, i)");
		
		l.Smashed();
		
		//System.out.println("<\t<-[lyuk].HitByLada(l, i)");
	}
	
	//"Map m" lek�rdez�se
	
	public Map GetMap() {
		return m;
	}
			
	//"Map m" be�ll�t�sa
			
	public void SetMap(Map tmp) {
		m = tmp;
	}
	
	public JsonObject Save() {
		JsonObject out = Json.createObjectBuilder()
				.add("type", "lyuk")
				.add("weight", weight)
				.build();

		return out;
	}

	@Override
	public void Load(JsonObject ob, Map map) {
		m = map;	
	}
	
	public String getName() {
		return name;
	}
	
	
}
