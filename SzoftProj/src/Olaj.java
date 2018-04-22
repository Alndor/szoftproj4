import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Olaj extends Item {

	//Az olaj mezejének módosítójának beállítása az olaj módosítójának függvényében
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
				.add("olaj", value)
				.build();
		return out;
	}
}
