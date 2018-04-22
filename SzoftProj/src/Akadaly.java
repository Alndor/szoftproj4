import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

//a mezõkön elhelyezhetõ akadályok osztálya
public class Akadaly extends Dolgok {
	
	//ha az akadályra dolgozó lépne
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[akadaly].HitByDolgozo(d, i)");
		
		d.Refuse();
		
		System.out.println("<\t<-[akadaly].HitByDolgozo(d, i)");
		
	}

	//ha az akadályra láda lépne
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		System.out.println(">\t->[akadaly].HitByLada(l, i)");
		
		l.Refuse();
		
		System.out.println("<\t<-[akadaly].HitByLada(l, i)");
	}
	
	public JsonObject Saved() {

		JsonObject out = Json.createObjectBuilder()
				.add("akadaly", "")
				.add("weight", String.valueOf(weight))
				.build();
		return out;
	}
}
