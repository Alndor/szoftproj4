import java.io.FileWriter;
import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Lada extends Dolgok {
	//változó, ami számon tartja, hogy a dobozt meg kell-e semmisíteni
	protected boolean smashed = false;
	//változó, ami számon tartja, hogy sikerült-e a mozgás
	protected boolean refused = false;
	protected Iranyok irany = null;
	
	private boolean mozgathato = true;
	
	public void Mozgathato() {
		int akadalyszam = 0;
		int i;
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.DOWN).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.DOWN).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.UP).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.UP).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.RIGHT).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.RIGHT).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		for (i = 0; i < this.GetCurrent().GetNeighbor(Iranyok.LEFT).GetThings().size(); i++) {
			if (this.GetCurrent().GetNeighbor(Iranyok.LEFT).GetThings().get(i).getName().equals("Akadaly")) {
				akadalyszam++;
			}
		}
		
		if (akadalyszam > 1) {
			mozgathato = false;
		}
		
	}
	
	public boolean GetMozgathato() {
		return mozgathato;
	}
	
	private String name="Lada";
	
	public Lada() {
		this.SetWeight(10);
	}
	public String getName() {
		return name;
	}
	
	//a paraméterül kapott Dologhoz hozzáüti a ládát
	@Override
	public void CollideWith(Dolgok d) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].CollideWith(d)");
		
		d.HitByLada(this, irany);
		
		//System.out.println("<\t<-[lada].CollideWith(d)");
	}

	//a paraméterül kapott dolgozó egy megfelelõ irányba löki
	@Override
	public void HitByDolgozo(Dolgozo d, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].HitByDolgozo(d, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		if(nextMezo == null)
			return;
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a mozgás sikertelen a láda marad jelenlegi helyén
			d.Refuse();
			current.Accept(this);
			refused=false;
		}
		//amennyiben a láda megsemmisül, nem helyezõdik fel egyetlen mezõre sem
		else if(smashed)
			return;
		else {
			nextMezo.Accept(this);
			this.Mozgathato();
		}							
		//System.out.println("<\t<-[lada].HitByDolgozo(d, i)");
	}
	
	//a paraméterül kapott láda egy megfelelõ irányba löki
	@Override
	public void HitByLada(Lada l, Iranyok i) {
		// TODO Auto-generated method stub
		//System.out.println(">\t->[lada].HitByLada(d, i)");
		
		irany = i;
		Mezo nextMezo = current.GetNeighbor(i);
		nextMezo.GetDolgok(this);
		current.Remove(this);
		if(refused) {
			//amennyiben a mozgás sikertelen a láda marad jelenlegi helyén
			l.Refuse();
			current.Accept(this);
			refused=false;
		}
		//amennyiben a láda megsemmisül, nem helyezõdik fel egyetlen mezõre sem
		if(smashed)
			return;
		
		else 
			nextMezo.Accept(this);
		
			
		//System.out.println("<\t<-[lada].HitByLada(d, i)");
	}
	
	//a mozgás sikertelenségének nyilvántartása
	public void Refuse() {
		//System.out.println(">\t->[lada].Refuse()");	
		
		refused = true;
		
		//System.out.println("<\t<-[lada].Refuse()");
	}
	
	//a láda megsemmisülésének nyilvántartása
	public void Smashed() {
		//System.out.println(">\t->[lada].Smashed()");
		
		smashed = true;
		
		//System.out.println("<\t<-[lada].Smashed()");
	}
	
	//"Iranyok irany" lekérdezése
	
	public Iranyok GetIrany() {
		return irany;
	}
		
	//"Iranyok irany" beállítása
		
	public void SetIrany(Iranyok tmp) {
		irany = tmp;
	}
	
	public JsonObject Save() {
		JsonObject out = Json.createObjectBuilder()
				.add("type", "lada")
				.add("weight", weight)
				.build();

		return out;
	}

	@Override
	public void SetWeight(int x) {
		// TODO Auto-generated method stub
		if (x>0)
			super.SetWeight(x);
	}
	
	@Override
	public void Load(JsonObject ob, Map map) {
		SetWeight(ob.getInt("weight"));
	}
	
	
	
	
}
