import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Mez extends Item{
	
	private String name="Mez";
	public String getName() {
		return name;
	}
	
	public Mez() {
		modifier=2;
	}
	
	//A m�z mezej�nek m�dos�t�j�nak be�ll�t�sa a m�z m�dos�t�j�nak f�ggv�ny�ben
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
