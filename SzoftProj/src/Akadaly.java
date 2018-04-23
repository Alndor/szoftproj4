import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

//a mez�k�n elhelyezhet� akad�lyok oszt�lya
public class Akadaly extends Dolgok {
	
	private String name="Akadaly";
	//ha az akad�lyra dolgoz� l�pne
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[akadaly].HitByDolgozo(d, i)");
		
		d.Refuse();
		
		//System.out.println("<\t<-[akadaly].HitByDolgozo(d, i)");
		
	}

	//ha az akad�lyra l�da l�pne
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[akadaly].HitByLada(l, i)");
		
		l.Refuse();
		
		//System.out.println("<\t<-[akadaly].HitByLada(l, i)");
	}
	
	public JsonObject Saved() {

		JsonObject out = Json.createObjectBuilder()
				.add("akadaly", "")
				.add("weight", String.valueOf(weight))
				.build();
		return out;
	}
	public String getName() {
		return name;
	}

	
}
