import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Olaj extends Item {

	
	private String name="Olaj";
	public String getName() {
		return name;
	}
	
	public Olaj() {
		modifier=0.5;
	}
	//Az olaj mezej�nek m�dos�t�j�nak be�ll�t�sa az olaj m�dos�t�j�nak f�ggv�ny�ben
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
