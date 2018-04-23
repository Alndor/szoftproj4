import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Kapcsolo extends Dolgok {
	//azt a mezõt képviseli, amelyre a lyuk felkerülhet
	private Mezo lyukable = new Mezo();
	//a felrakható lyuk
	private Lyuk segedlyuk = new Lyuk();
	//protected boolean open = false;
	private String name="Kapcsolo";
	public String getName() {
		return name;
	}


	//ha dolgozó lép rá, megvizsgálja a váltó állását, és az alapján alakít rajta
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[kapcsolo].HitByDolgozo(d, i)");
		
		SwitchD();
		
		//System.out.println("<\t<-[kapcsolo].HitByDolgozo(d, i)");
	}

	//ha láda tolódik rá, megvizsgálja a váltó állását, és az alapján alakít rajta
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[kapcsolo].HitByLada(l, i)");
		
		SwitchL();
		
		//System.out.println("<\t<-[kapcsolo].HitByLada(l, i)");
	}
	
	//megvizsgálja a mezõn lévõ Dolgokat, és aszerint jár el, hogy tartalmazta-e a lyukat
	public void SwitchL() {
		//System.out.println(">\t->[kapcsolo].SwitchL()");
		
		//csak akkor teszünk bele, ha még nem tartalmazza
		
		if(!lyukable.GetThings().contains(segedlyuk)) {
			lyukable.Accept(segedlyuk);
		}
			
		//System.out.println("<\t<-[kapcsolo].SwitchL()");
	}
	
	//megvizsgálja a mezõn lévõ Dolgokat, és aszerint jár el, hogy tartalmazta-e a lyukat
	public void SwitchD() {
	  	//System.out.println(">\t->[kapcsolo].SwitchD()");
	  	
	  	//ha van rajta a bizonyos lyuk, akkor leszedjük róla, mivel Dolgozó lépett a kapcsolóra
	  	
	  	if(lyukable.GetThings().contains(segedlyuk)) {
	  		lyukable.Remove(segedlyuk);
	  	}
	  	
	 	//System.out.println("<\t<-[kapcsolo].SwitchD()");
	}
	
	//"Mezo lyukable" lekérdezése
	
	public Mezo GetLyukable() {
		return lyukable;
	}
	
	//"Mezo lyukable" beállítása
	
	public void SetLyukable(Mezo tmp) {
		lyukable = tmp;
	}
	
	//"Lyuk segedlyuk" lekérdezése
	
	public Lyuk GetSegedLyuk() {
		return segedlyuk;
	}
	
	//"Lyuk segedlyuk" beállítása
	
	public void SetSegedLyuk(Lyuk tmp) {
		segedlyuk = tmp;
	}
	
	public JsonObject Saved() {
		JsonObject value = Json.createObjectBuilder()
				.add("lyukasmezo", lyukable.toString())
				.add("segedlyuk", segedlyuk.Saved())
				.add("weight", String.valueOf(weight))
				.build();
		JsonObject out = Json.createObjectBuilder()
				.add("kapcsolo", value)
				.build();
		return out;
	}
}
