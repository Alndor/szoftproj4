import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Kapcsolo extends Dolgok {
	//azt a mez�t k�pviseli, amelyre a lyuk felker�lhet
	private Mezo lyukable = new Mezo();
	//a felrakhat� lyuk
	private Lyuk segedlyuk = new Lyuk();
	//protected boolean open = false;
	private String name="Kapcsolo";
	public String getName() {
		return name;
	}


	//ha dolgoz� l�p r�, megvizsg�lja a v�lt� �ll�s�t, �s az alapj�n alak�t rajta
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[kapcsolo].HitByDolgozo(d, i)");
		
		SwitchD();
		
		//System.out.println("<\t<-[kapcsolo].HitByDolgozo(d, i)");
	}

	//ha l�da tol�dik r�, megvizsg�lja a v�lt� �ll�s�t, �s az alapj�n alak�t rajta
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[kapcsolo].HitByLada(l, i)");
		
		SwitchL();
		
		//System.out.println("<\t<-[kapcsolo].HitByLada(l, i)");
	}
	
	//megvizsg�lja a mez�n l�v� Dolgokat, �s aszerint j�r el, hogy tartalmazta-e a lyukat
	public void SwitchL() {
		//System.out.println(">\t->[kapcsolo].SwitchL()");
		
		//csak akkor tesz�nk bele, ha m�g nem tartalmazza
		
		if(!lyukable.GetThings().contains(segedlyuk)) {
			lyukable.Accept(segedlyuk);
		}
			
		//System.out.println("<\t<-[kapcsolo].SwitchL()");
	}
	
	//megvizsg�lja a mez�n l�v� Dolgokat, �s aszerint j�r el, hogy tartalmazta-e a lyukat
	public void SwitchD() {
	  	//System.out.println(">\t->[kapcsolo].SwitchD()");
	  	
	  	//ha van rajta a bizonyos lyuk, akkor leszedj�k r�la, mivel Dolgoz� l�pett a kapcsol�ra
	  	
	  	if(lyukable.GetThings() != null && lyukable.GetThings().contains(segedlyuk)) {
	  		lyukable.Remove(segedlyuk);
	  	}
	  	
	 	//System.out.println("<\t<-[kapcsolo].SwitchD()");
	}
	
	//"Mezo lyukable" lek�rdez�se
	
	public Mezo GetLyukable() {
		return lyukable;
	}
	
	//"Mezo lyukable" be�ll�t�sa
	
	public void SetLyukable(Mezo tmp) {
		lyukable = tmp;
	}
	
	//"Lyuk segedlyuk" lek�rdez�se
	
	public Lyuk GetSegedLyuk() {
		return segedlyuk;
	}
	
	//"Lyuk segedlyuk" be�ll�t�sa
	
	public void SetSegedLyuk(Lyuk tmp) {
		segedlyuk = tmp;
	}
	
	public JsonObject Save() {
		JsonObject out = Json.createObjectBuilder()
				.add("type", "kapcsolo")
				.add("lyukable", lyukable.getPosition())
				.add("segedlyuk", segedlyuk.Save())
				.add("weight", weight)
				.build();

		return out;
	}

	@Override
	public void Load(JsonObject ob, Map map) {
		weight = ob.getInt("weight");
		Lyuk l = new Lyuk();
		l.Load(ob.getJsonObject("segedlyuk"), map);
		segedlyuk = l;
		String pos = ob.getString("lyukable");
		String[] tmp = pos.split(",");
		int x = tmp[0].charAt(1) - '0';
		int y = tmp[1].charAt(0) - '0';
		Coord coord = new Coord(x, y);
		
		map.kapcsok.put(this, coord);
		
	}
}
