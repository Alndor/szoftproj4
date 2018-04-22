import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Mez extends Item{
	
	//A méz mezejének módosítójának beállítása a méz módosítójának függvényében
	@Override
	public void Modify() {
		current.SetMod(modifier);
	}
	
	public JsonObject Saved() {
		JsonObject value = Json.createObjectBuilder()
				.add("modifier", String.valueOf(modifier))
				.add("weight", String.valueOf(weight))
				.build();
		JsonObject out = Json.createObjectBuilder()
				.add("mez", value)
				.build();
		return out;
	}
}
